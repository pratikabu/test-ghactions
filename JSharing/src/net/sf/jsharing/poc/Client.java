package net.sf.jsharing.poc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 
 * @author Pratik
 */
public class Client {
    private Socket clientSocket;
    private int portNumber;
    private InetAddress serverAddress;

    private int taskType;

    public static int DOWNLOAD_FILES = 1, PROCESS_FILE_INFO = 2;

    public Client(InetAddress serverAddress, int portNumber, int taskType) {
        this.portNumber = portNumber;
        this.serverAddress = serverAddress;
        this.taskType = taskType;
    }

    public void triggerClientTask() {
        if(connectToServer()) {
            if(taskType == PROCESS_FILE_INFO) {
                processFileInfoData();
            } else if(taskType == DOWNLOAD_FILES) {

            }
        }
    }

    private boolean connectToServer() {
        try{
            clientSocket = new Socket(serverAddress, portNumber);
            return true;
        } catch(Exception e) {
            System.out.println("Error connecting to Server.");
            System.out.println("Error Message: " + e.getMessage());
            return false;
        }
    }

    private void processFileInfoData() {
        try{
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            FileInfoManager fi = (FileInfoManager)ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error processing FileInfo data.");
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    public boolean closeConnection() {
        try {
            clientSocket.close();
            return true;
        } catch(IOException ioe) {
            System.out.println("Error closing connection.");
            System.out.println("Error Message: " + ioe.getMessage());
            return false;
        }
    }
}