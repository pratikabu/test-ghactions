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
import net.sf.jsharing.boundary.DownloadPopup;
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

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
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

        MainWindow.mw.addConnection(ip, portNumber);
        processRequest();
        MainWindow.mw.removeConnection(ip, portNumber);
    }

    private void processRequest() {
        try {
            if(to.getTaskType() == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
                populateFiles(to);
            } else if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
                System.out.println("Request to upload from: " + clientSocket.getInetAddress().getHostAddress());
                uploadFile(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadFile(TransferrableObject to) {
        try {
            OutputStream os = clientSocket.getOutputStream();
            for(FileInfo fi : to.getFiles()) {
                System.out.println("Uploading File: " + fi.getAbsolutePath());
                FileInputStream fis = new FileInputStream(fi.getAbsolutePath());
                byte[] dataArray = new byte[1024];
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
        DownloadPopup.showDownloadPopup(to);
    }
}
