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
    private NetworkActivity na;

    /**
     *
     * @param serverAddress
     * @param portNumber
     * @throws UnknownHostException
     */
    public Client(String serverAddress, int portNumber, NetworkActivity ca) throws UnknownHostException {
        init(InetAddress.getByName(serverAddress), portNumber, ca);
    }

    /**
     *
     * @param serverAddress
     * @param portNumber
     */
    public Client(InetAddress serverAddress, int portNumber, NetworkActivity ca) {
        init(serverAddress, portNumber, ca);
    }

    /**
     * 
     * @param serverAddress
     * @param portNumber
     */
    private void init(InetAddress serverAddress, int portNumber, NetworkActivity ca) {
        this.portNumber = portNumber;
        this.serverAddress = serverAddress;
        this.chunkSize = UsefulMethods.getChunkSize();

        if(ca != null)
            this.na = ca;
        else
            this.na = new DefaultClientActivity();
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
        na.message("Connecting to " + serverAddress.getHostAddress() + " at port#: " + portNumber);
        clientSocket = new Socket(serverAddress, portNumber);
    }

    private void processTransferrableObject(TransferrableObject to) throws IOException {
        if(to.getTaskType() == UsefulMethods.DOWNLOAD_FILES) {
            if(!to.getFiles().isEmpty()) {
                na.message("Initializing download.");
                downloadTransferrableObject(to);
            }
        } else if(to.getTaskType() == UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT) {
            na.message("Getting the Server's OutputStream.");
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            na.message("Closing connection.");
            oos.writeObject(to);
            oos.close();
            closeConnection();
        }
    }

    private void downloadTransferrableObject(TransferrableObject to) throws IOException {
        for(FileInfo fi : to.getFiles()) {
            if(!continueDownload)
                return;

            na.processingFile(fi.getFileName());
            TransferrableObject singleTO = new TransferrableObject(to.getTaskType());
            singleTO.setServerAddress(to.getServerAddress());
            ArrayList<FileInfo> fis = new ArrayList<FileInfo>(1);
            fis.add(fi);
            singleTO.setFiles(fis);
            connectToServer();
            na.message("Getting the Server's OutputStream.");
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            na.message("Sending file download request.");
            oos.writeObject(singleTO);

            na.message("Receiving InputStream from Server.");
            InputStream is = clientSocket.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File(saveToDirectory, fi.getFileName()));

            byte[] data = new byte[chunkSize];
            int count;
            na.message("Writing file contents to local.");
            while(((count = is.read(data)) != -1) && continueDownload) {
                fos.write(data, 0, count);
            }
            UsefulMethods.addDownloadedBytes(fi.getSize());
            na.message("Closing connections and saving file.");
            fos.close();
            is.close();
            oos.close();
            closeConnection();
        }

        na.message("Downloading Completed.");
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

    public NetworkActivity getClientActivity() {
        return na;
    }
}