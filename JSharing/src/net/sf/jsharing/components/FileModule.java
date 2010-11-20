/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.io.File;

/**
 *
 * @author Pratik
 */
public class FileModule {
    public static final String CONFIG_LOCATION = "config";
    public static final String LOG_FOLDER = CONFIG_LOCATION + File.separatorChar + "logs";
    public static final String LIB_FOLDER = CONFIG_LOCATION + File.separatorChar + "lib";
    
    public static final String PROPERTIES_LOCATION = CONFIG_LOCATION + File.separatorChar + "jsharingproperties.properties";
    public static final String SAVED_IP_LOCATION = CONFIG_LOCATION + File.separatorChar + "savedIPs.txt";
}
