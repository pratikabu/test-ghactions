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
import net.sf.jsharing.components.threads.MyThread;
import net.sf.jsharing.components.threads.UninterruptibleThread;

/**
 *
 * @author Pratik
 */
public class ClientHandler implements Runnable {
    private MyThread t;
    private Socket clientSocket;
    private TransferrableObject to;
    private int chunkSize;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.chunkSize = UsefulMethods.getChunkSize();
    }

    public void startHandling() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
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
            populateFiles(to);
        } else if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
            System.out.println("Request to upload from: " + clientSocket.getInetAddress().getHostAddress());
            uploadFile(to);
        }
    }

    private void uploadFile(TransferrableObject to) {
        try {
            OutputStream os = clientSocket.getOutputStream();
            for(FileInfo fi : to.getFiles()) {
                FileInputStream fis = new FileInputStream(fi.getAbsolutePath());
                byte[] dataArray = new byte[chunkSize];
                int count;
                while ((count = fis.read(dataArray)) != -1) {
                    os.write(dataArray, 0, count);
                }
                fis.close();
            }
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
