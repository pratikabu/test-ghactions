/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.util.Properties;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Pratik
 */
public class UsefulMethods {
    public static int DOWNLOAD_FILES = 1, PROCESS_TRANSFERRABLE_OBJECT = 2;
    public static Properties props = new Properties();
    public static Properties savedIPs = new Properties();

    public static final String P_PORT_NUMBER_KEY = "portNumber";
    public static final String P_LAST_SAVE_LOCATION = "lastSaveLoc";
    
    public static final Integer DEFAULT_PORT_NUMBER = 21212;

    /**
     * Fetches the port number from the properties file.
     * If available then returns it else sets the default port number.
     * @return
     */
    public static Integer getPortNumber() {
        String value = props.getProperty(P_PORT_NUMBER_KEY);
        
        try {
            return Integer.parseInt(value);
        } catch(Exception e) {
            return DEFAULT_PORT_NUMBER;
        }
    }

    /**
     * Gives the last used save location.
     * @return
     */
    public static String getLastSavedLocation() {
        String value = props.getProperty(P_LAST_SAVE_LOCATION);
        if(value == null)
            value = FileSystemView.getFileSystemView().getDefaultDirectory().getAbsolutePath();
        
        return value;
    }

    /**
     * Get the saved port number for the passed IP.
     * @param ip
     * @return
     */
    public static Integer getPortNumberForIP(String ip) {
        String value = savedIPs.getProperty(ip);

        try {
            return Integer.parseInt(value);
        } catch(Exception e) {
            return DEFAULT_PORT_NUMBER;
        }
    }

    public static boolean isIPSaved(String ip) {
        String value = savedIPs.getProperty(ip);
        return value != null;
    }

    /**
     * Representable form of the file size.
     * @param size The file size.
     * @return
     */
    public static String getFileSize(long size) {
        String strSize;
        double tempSize = size / 1024.0;
        if (size < 1024)
            strSize = String.format("%.2f", tempSize * 1024.0) + " Bytes";
        else if (tempSize < 1024)
            strSize = String.format("%.2f", tempSize) + " KB";
        else if ((tempSize = tempSize / 1024.0) < 1024)
            strSize = String.format("%.2f", tempSize) + " MB";
        else
            strSize = String.format("%.2f", tempSize / 1024.0) + " GB";
        return strSize;
    }
}
