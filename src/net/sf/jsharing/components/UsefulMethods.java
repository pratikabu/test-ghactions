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
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Properties;
import javax.swing.filechooser.FileSystemView;
import org.apache.log4j.Level;
import pratikabu.logging.log4j.FileLog;
import pratikabu.logging.log4j.Log;

/**
 *
 * @author Pratik
 */
public class UsefulMethods {
    public static int DOWNLOAD_FILES = 1, PROCESS_TRANSFERRABLE_OBJECT = 2;
    public static Properties props = new Properties();
    public static LinkedHashMap<String, SavedIPInfo> savedIPs = new LinkedHashMap<String, SavedIPInfo>();

    public static final String P_PORT_NUMBER_KEY = "portNumber";
    public static final String P_LAST_SAVE_LOCATION = "lastSaveLoc";
    public static final String P_SERVER_NAME = "serverName";
    public static final String P_MAIN_WINDOW_SHOW_ON_LOAD = "mainWindowShow";
    public static final String P_SYSTEM_ICON_LOAD = "systemIconLoad";
    public static final String P_CHUNK_SIZE = "chunkSize";

    public static final String LOCAL_HOST_IP = "127.0.0.1";

    public static Log log;

    public static void loadFiles(){
        //1. load properties
        loadProperties();

        //2. load saved ips
        loadSavedIPs();

        //3. instantiate logger
        File folder = new File(FileModule.LOG_FOLDER);
        if(!folder.exists())
            folder.mkdirs();//create all folder if not available
        Calendar cal = Calendar.getInstance();
        String date = cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONDAY) + "-" + cal.get(Calendar.YEAR);
        try {
            log = new FileLog("JSharing Logs", FileModule.LOG_FOLDER + File.separatorChar + date + ".xml", true);
        } catch(IOException e) {
            e.printStackTrace();
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
     * Get the object of Saved IPs.
     * @param ip
     * @return
     */
    public static SavedIPInfo getSavedIPInfo(String ip) {
        return savedIPs.get(ip);
    }

    /**
     * Get the saved port number for the passed IP.
     * @param ip
     * @return
     */
    public static Integer getPortNumberForIP(String ip) {
        SavedIPInfo sip = getSavedIPInfo(ip);

        if(sip != null)
            return sip.getPort();
        else
            return getPortNumber();
    }

    public static boolean isIPSaved(String ip) {
        return savedIPs.containsKey(ip);
    }

    public static String getShortNameOfIP(String ip) {
        SavedIPInfo sip = getSavedIPInfo(ip);
        if(sip != null)
            return sip.getName();
        else
            return ip;
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
            props.load(new FileInputStream(new File(FileModule.PROPERTIES_LOCATION)));
        } catch(IOException e) {
        }
    }

    private static void loadSavedIPs() {
    }

    public static void saveProperties() {
        try {
            props.store(new FileOutputStream(new File(FileModule.PROPERTIES_LOCATION)), "The properties have been modified at: " + new Date());
        } catch(IOException e) {
            log.log(Level.ERROR, "Error saving properties file.", e);
        }
    }

    public static void placeAtRightBottomLocation(Component c) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension d = toolkit.getScreenSize();
        Insets i = toolkit.getScreenInsets(c.getGraphicsConfiguration());
        Rectangle r = c.getBounds();

        //actual dimension
        d.width = d.width - (i.left + i.right);
        d.height = d.height - (i.bottom + i.top);

        //center
        r.x = d.width - c.getWidth();
        r.y = d.height - c.getHeight();

        c.setBounds(r);
    }

    public static String getComputerName() {
        String value = props.getProperty(P_SERVER_NAME);
        
        if(value != null)
            return value;
        else
            return System.getProperty("user.name");
    }

    public static int getChunkSize() {
        int chunkSize;
        try {
            chunkSize = Integer.parseInt(props.getProperty(P_CHUNK_SIZE));
        } catch(Exception e) {
            chunkSize = 1024;
        }
        return chunkSize;
    }

    public static boolean getBooleanDefaultTrue(String key) {
        try {
            return Boolean.parseBoolean(UsefulMethods.props.getProperty(key));
        } catch (Exception e) {
            return true;
        }
    }
}