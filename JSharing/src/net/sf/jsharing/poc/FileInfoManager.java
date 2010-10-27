/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.poc;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pratik
 */
public class FileInfoManager implements Serializable {
    private ArrayList<FileInfo> files = new ArrayList<FileInfo>();

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
