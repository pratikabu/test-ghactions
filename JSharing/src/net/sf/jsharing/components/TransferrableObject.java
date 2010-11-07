/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;

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

    public TransferrableObject(int taskType) {
        this.taskType = taskType;
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

//    public ArrayList<FileInfo> getDownloadableFiles() {
//        ArrayList<FileInfo> fis = new ArrayList<FileInfo>();
//
//        for(FileInfo fi : files)
//            if(fi.isDownloadMarked())
//                fis.add(fi);
//        return fis;
//    }

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
}
