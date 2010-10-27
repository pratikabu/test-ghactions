package net.sf.jsharing.network;

import java.io.FileOutputStream;
import net.sf.jsharing.components.TransferrableObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
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
            sendTransferrableObject(to);
        }

        return success;
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

    private void sendTransferrableObject(TransferrableObject to) {
        if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
            if(!to.getFiles().isEmpty()) {
                downloadTransferrableObject(to);
            }
        } else if(to.getTaskType() == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
            try{
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                oos.writeObject(to);
                oos.close();
                closeConnection();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void downloadTransferrableObject(TransferrableObject to) {
        for(FileInfo fi : to.getFiles()) {
            System.out.println("Downloading: " + fi.getAbsolutePath());
            TransferrableObject singleTO = new TransferrableObject(to.getTaskType());
            singleTO.setServerAddress(to.getServerAddress());
            ArrayList<FileInfo> fis = new ArrayList<FileInfo>(1);
            fis.add(fi);
            singleTO.setFiles(fis);
            try {
                if(connectToServer()) {
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    oos.writeObject(singleTO);

                    InputStream is = clientSocket.getInputStream();
                    FileOutputStream fos = new FileOutputStream("D:\\Download\\" + fi.getFileName());

                    byte[] data = new byte[1024];
                    int count;
                    while((count = is.read(data)) != -1) {
                        fos.write(data, 0, count);
                    }
                    fos.close();
                    is.close();
                    oos.close();
                    closeConnection();
                    System.out.println("Download Completed Successfully.");
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean closeConnection() {
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