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
    private InetAddress serverAddress;
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

    public ArrayList<FileInfo> getDownloadableFiles() {
        return null;
    }
}
