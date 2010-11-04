/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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
    public static int chunkSize;

    private static final String PROPERTIES_LOCATION = "jsharingproperties.properties";

    static{
        //load properties
        loadProperties();

        //update the chunkSize
        try{
            chunkSize = Integer.parseInt(props.getProperty("chunksize"));
        } catch (Exception e) {
            chunkSize = 1024;
        }
    }

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
            return 21212;
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
            return getPortNumber();
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

    private static void loadProperties() {
        try {
            props.load(new FileInputStream(new File(PROPERTIES_LOCATION)));
        } catch(IOException e) {
        }
    }

    public static void saveProperties() {
        try {
            props.store(new FileOutputStream(new File(PROPERTIES_LOCATION)), "The properties have been modified at: " + new Date());
        } catch(IOException e) {
        }
    }

    public static void placeAtRightBottomLocation(Component c){
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension d=toolkit.getScreenSize();
        Insets i=toolkit.getScreenInsets(c.getGraphicsConfiguration());
        Rectangle r=c.getBounds();

        //actual dimension
        d.width=d.width-(i.left+i.right);
        d.height=d.height-(i.bottom+i.top);

        //center
        r.x=d.width-c.getWidth();
        r.y=d.height-c.getHeight();

        c.setBounds(r);
    }
}
