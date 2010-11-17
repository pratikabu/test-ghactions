/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.sf.jsharing.boundary.DownloadDialog;
import net.sf.jsharing.boundary.MainWindow;
import net.sf.jsharing.components.FileInfo;
import net.sf.jsharing.components.TransferrableObject;
import net.sf.jsharing.components.UsefulMethods;
import pratikabu.threading.AbstractThread;
import pratikabu.threading.implementation.UninterruptibleThread;

/**
 *
 * @author Pratik
 */
public class ClientHandler implements Runnable {
    private AbstractThread t;
    private Socket clientSocket;
    private TransferrableObject to;
    private int chunkSize;
    private NetworkActivity na;

    public ClientHandler(Socket clientSocket, NetworkActivity na) {
        this.clientSocket = clientSocket;
        this.chunkSize = UsefulMethods.getChunkSize();
        this.na = na;
    }

    public void startHandling() {
        try {
            na.message("-------------------------------");
            na.message("Client connected, getting InputStream.");
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            na.message("Preparing TransferrableObject.");
            to = (TransferrableObject)ois.readObject();
            to.setServerAddress(clientSocket.getInetAddress());

            t = new UninterruptibleThread(this, "Serving: " +
                    to.getServerAddress().getHostAddress() + ", " + to.getPortNumber());
            
            t.start();
        } catch(Exception e){}
    }

    public void run() {
        String ip = to.getServerAddress().getHostAddress();
        int portNumber = to.getPortNumber();

        MainWindow.mw.addConnection(UsefulMethods.getShortNameOfIP(ip), ip, portNumber);
        processRequest();
        MainWindow.mw.removeConnection(ip, portNumber);
    }

    private void processRequest() {
        if(to.getTaskType() == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
            na.message("Populating files.");
            populateFiles(to);
        } else if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
            na.message("Upload request from: " + clientSocket.getInetAddress().getHostAddress());
            uploadFile(to);
        }
        na.message("Waiting for client to connect.");
    }

    private void uploadFile(TransferrableObject to) {
        try {
            na.message("Getting client's OutputStream.");
            OutputStream os = clientSocket.getOutputStream();
            for(FileInfo fi : to.getFiles()) {
                na.message("Sending File: " + fi.getFileName());
                FileInputStream fis = new FileInputStream(fi.getAbsolutePath());
                byte[] dataArray = new byte[chunkSize];
                int count;
                while ((count = fis.read(dataArray)) != -1) {
                    os.write(dataArray, 0, count);
                }
                fis.close();
                UsefulMethods.addUploadedBytes(fi.getSize());
            }
            na.message("Closing Connection.");
            os.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateFiles(TransferrableObject to) {
        DownloadDialog.getDD().addDownloadRequest(to);
    }
}
