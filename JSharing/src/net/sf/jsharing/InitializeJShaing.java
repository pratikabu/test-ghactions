/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing;

import javax.swing.UIManager;
import net.sf.jsharing.boundary.MainWindow;
import net.sf.jsharing.components.UsefulMethods;

/**
 *
 * @author Pratik
 */
public class InitializeJShaing {

    private static void initPrerequisiteFiles() {
        UsefulMethods.loadFiles();
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

    public static void main(String args[]) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}

        initPrerequisiteFiles();
        initMainWindow();
        initSystemIcon();
    }
}
