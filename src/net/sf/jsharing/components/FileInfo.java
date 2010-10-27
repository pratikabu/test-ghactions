/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.io.Serializable;

/**
 *
 * @author Pratik
 */
public class FileInfo implements Serializable {
    private String fileName;
    private String absolutePath;
    private long size;
    private int fileType;

    private boolean downloadMarked = false;

    public static final int FOLDER=1, FILE=2;

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public boolean isFolder() {
        return fileType == FOLDER;
    }

    public boolean isFile() {
        return fileType == FILE;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getSizeFormatted() {
        return null;
    }

    public boolean isDownloadMarked() {
        return downloadMarked;
    }

    public void setDownloadMarked(boolean downloadMarked) {
        this.downloadMarked = downloadMarked;
    }
}
