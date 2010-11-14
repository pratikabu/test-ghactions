/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pratik
 */
public class TransferrableObject implements Serializable {
    private ArrayList<FileInfo> files = new ArrayList<FileInfo>();
    private String computerName;
    private InetAddress serverAddress;
    private int portNumber;
    private int taskType;
    private long timeStamp;

    public TransferrableObject(int taskType) {
        this.taskType = taskType;
        timeStamp = new Date().getTime();
    }

    public InetAddress getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(InetAddress serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public void addFile(File file) {
        FileInfo fi = new FileInfo();
        
        fi.setFileName(file.getName());
        fi.setAbsolutePath(file.getAbsolutePath());
        fi.setSize(file.length());
        fi.setFileType(file.isFile()?FileInfo.FILE:FileInfo.FOLDER);
        fi.setDownloadMarked(false);

        files.add(fi);
    }

    public ArrayList<FileInfo> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FileInfo> files) {
        this.files = files;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
    

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
