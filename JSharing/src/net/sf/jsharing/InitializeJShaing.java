/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing;

import net.sf.jsharing.boundary.MainWindow;
import net.sf.jsharing.boundary.UpdateAvailable;
import net.sf.jsharing.components.UsefulMethods;
import pratikabu.threading.AbstractThread;
import pratikabu.threading.ThreadManager;

/**
 *
 * @author Pratik
 */
public class InitializeJShaing {

    private static void initPrerequisiteFiles() {
        UsefulMethods.loadData();
    }
    
    private static void initMainWindow() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mw = new MainWindow();
                MainWindow.mw = mw;

                boolean show = UsefulMethods.getBooleanDefaultTrue(UsefulMethods.P_MAIN_WINDOW_SHOW_ON_LOAD);
                
                if(show)
                    MainWindow.mw.setVisible(true);
            }
        });
    }

    private static void initSystemIcon() {
        boolean load = UsefulMethods.getBooleanDefaultTrue(UsefulMethods.P_SYSTEM_ICON_LOAD);
        if(load) {
            //TODO load system icon
        }
    }

    private static void checkForUpdates() {
        AbstractThread at = AbstractThread.createInstance(new Runnable() {
            public void run() {
                String version = UsefulMethods.checkForUpdate();
                if(!version.equals(UsefulMethods.APPLICATION_VERSION))
                    new UpdateAvailable(MainWindow.mw, version);
            }
        }, "Checking for updates.", ThreadManager.INTERRUPTIBLE_THREAD);

        at.start();
    }

    public static void main(String args[]) {
        initPrerequisiteFiles();
        initMainWindow();
        initSystemIcon();
        checkForUpdates();
    }
}
