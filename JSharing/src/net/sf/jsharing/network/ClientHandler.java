/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.sf.jsharing.components.FileInfo;
import net.sf.jsharing.components.TransferrableObject;
import net.sf.jsharing.controller.UsefulMethods;

/**
 *
 * @author Pratik
 */
public class ClientHandler implements Runnable {
    private Thread t;
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        t = new Thread(this);
    }

    public void startHandling() {
        t.start();
    }

    public void run() {
        processRequest();
    }

    private void processRequest() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            TransferrableObject to = (TransferrableObject)ois.readObject();
            to.setServerAddress(clientSocket.getInetAddress());

            if(to.getTaskType() == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
                populateFiles(to);
            } else if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
                System.out.println("Request to upload from: " + clientSocket.getInetAddress());
                uploadFile(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadFile(TransferrableObject to) {
        try {
            for(FileInfo fi : to.getFiles()) {
                OutputStream os = clientSocket.getOutputStream();
                FileInputStream fis = new FileInputStream(fi.getAbsolutePath());
                byte[] dataArray = new byte[1024];
                int count;
                while ((count = fis.read(dataArray)) != -1) {
                    os.write(dataArray, 0, count);
                }
                fis.close();
                os.close();
            }
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error connecting with client.");
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    private void populateFiles(TransferrableObject to) {
        UsefulMethods.to = to;//temporary
        for(FileInfo fi : to.getFiles())
            System.out.println(fi.isDownloadMarked() + ", " + fi.getAbsolutePath());
    }
}
