package net.sf.jsharing.network;

import java.io.File;
import java.io.FileOutputStream;
import java.net.UnknownHostException;
import net.sf.jsharing.components.TransferrableObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import net.sf.jsharing.boundary.MainWindow;
import net.sf.jsharing.components.FileInfo;
import net.sf.jsharing.components.UsefulMethods;

/**
 * 
 * @author Pratik
 */
public class Client {
    private Socket clientSocket;
    private int portNumber;
    private InetAddress serverAddress;
    private File saveToDirectory;
    private boolean continueDownload = true;
    private int chunkSize;

    /**
     *
     * @param serverAddress
     * @param portNumber
     * @throws UnknownHostException
     */
    public Client(String serverAddress, int portNumber) throws UnknownHostException {
        init(InetAddress.getByName(serverAddress), portNumber);
    }

    /**
     *
     * @param serverAddress
     * @param portNumber
     */
    public Client(InetAddress serverAddress, int portNumber) {
        init(serverAddress, portNumber);
    }

    /**
     * 
     * @param serverAddress
     * @param portNumber
     */
    private void init(InetAddress serverAddress, int portNumber) {
        this.portNumber = portNumber;
        this.serverAddress = serverAddress;
        this.chunkSize = UsefulMethods.getChunkSize();
    }

    /**
     * Triggers the task specified by the TransferrableObject.
     * @param to
     * @throws IOException
     */
    public void triggerServerTask(TransferrableObject to) throws IOException {
        String ip = serverAddress.getHostAddress();
        MainWindow.mw.addConnection(UsefulMethods.getShortNameOfIP(ip), ip, portNumber);
        connectToServer();
        processTransferrableObject(to);
        MainWindow.mw.removeConnection(ip, portNumber);
    }

    /**
     * Tries to connect to server.
     * @throws IOException
     */
    private void connectToServer() throws IOException {
        clientSocket = new Socket(serverAddress, portNumber);
    }

    private void processTransferrableObject(TransferrableObject to) throws IOException {
        if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
            if(!to.getFiles().isEmpty()) {
                downloadTransferrableObject(to);
            }
        } else if(to.getTaskType() == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(to);
            oos.close();
            closeConnection();
        }
    }

    private void downloadTransferrableObject(TransferrableObject to) throws IOException {
        for(FileInfo fi : to.getFiles()) {
            if(!continueDownload)
                return;
            
            TransferrableObject singleTO = new TransferrableObject(to.getTaskType());
            singleTO.setServerAddress(to.getServerAddress());
            ArrayList<FileInfo> fis = new ArrayList<FileInfo>(1);
            fis.add(fi);
            singleTO.setFiles(fis);
            connectToServer();
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(singleTO);

            InputStream is = clientSocket.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File(saveToDirectory, fi.getFileName()));

            byte[] data = new byte[chunkSize];
            int count;
            while(((count = is.read(data)) != -1) && continueDownload) {
                fos.write(data, 0, count);
            }
            fos.close();
            is.close();
            oos.close();
            closeConnection();
        }
    }

    /**
     * Tries to close the connection.
     * @throws IOException
     */
    private void closeConnection() throws IOException {
        clientSocket.close();
    }

    public void setOutputDirectory(File saveToFile) {
        this.saveToDirectory = saveToFile;
    }

    public boolean isContinueDownload() {
        return continueDownload;
    }

    public void setContinueDownload(boolean continueDownload) {
        this.continueDownload = continueDownload;
    }
}