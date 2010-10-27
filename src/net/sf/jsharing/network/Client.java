package net.sf.jsharing.network;

import net.sf.jsharing.components.TransferrableObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import net.sf.jsharing.components.FileInfo;
import net.sf.jsharing.controller.UsefulMethods;

/**
 * 
 * @author Pratik
 */
public class Client {
    private Socket clientSocket;
    private int portNumber;
    private InetAddress serverAddress;

    private TransferrableObject recievedTO;

    private int taskType;

    public Client(String serverAddress, int portNumber) {
        try {
            init(InetAddress.getByName(serverAddress), portNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client(InetAddress serverAddress, int portNumber) {
        init(serverAddress, portNumber);
    }

    private void init(InetAddress serverAddress, int portNumber) {
        this.portNumber = portNumber;
        this.serverAddress = serverAddress;
    }

    public boolean triggerServerTask(TransferrableObject to) {
        boolean success;
        if(success = connectToServer()) {
            this.taskType = to.getTaskType();
            success = sendTransferrableObject(to);
        }

        return success;
    }

    public void triggerClientTask() {
        if(connectToServer()) {
            if(taskType == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
                recieveTransferrableObject();
            } else if(taskType == UsefulMethods.DOWNLOAD_FILES) {
                downloadTransferrableObject();
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

    private void recieveTransferrableObject() {
        try{
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            recievedTO = (TransferrableObject)ois.readObject();
            ois.close();
        } catch (Exception e) {
            recievedTO = null;
            System.out.println("Error processing FileInfo data.");
            System.out.println("Error Message: " + e.getMessage());
        }

    }

    private void downloadTransferrableObject() {
    }

    private boolean sendTransferrableObject(TransferrableObject to) {
        try{
            for(FileInfo fi : to.getFiles()) {
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                oos.writeObject(to);
                oos.close();
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error processing FileInfo data.");
            System.out.println("Error Message: " + e.getMessage());
            return false;
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