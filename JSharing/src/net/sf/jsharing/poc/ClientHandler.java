/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.poc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

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
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            OutputStream os = clientSocket.getOutputStream();

            if ((inputLine = in.readLine()) != null) {
                FileInputStream fis = new FileInputStream(inputLine);
                byte[] dataArray = new byte[1024];
                int count;
                while ((count = fis.read(dataArray)) != -1) {
                    os.write(dataArray, 0, count);
                }
            }
            os.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error connecting with client.");
            System.out.println("Error Message: " + e.getMessage());
        }
    }
}
