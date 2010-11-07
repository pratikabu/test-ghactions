/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import javax.swing.JPanel;
import net.sf.jsharing.boundary.NewRequestDialog;
import net.sf.jsharing.boundary.PopupPanel;
import net.sf.jsharing.components.threads.InterruptibleThread;
import net.sf.jsharing.components.threads.MyThread;

/**
 *
 * @author Pratik
 */
public class RequestPanel extends JPanel {
    protected TransferrableObject to;
    private PopupPanel pp;
    private MyThread t;
    private boolean canClose;

    public RequestPanel(TransferrableObject to) {
        this.to = to;
        t = new InterruptibleThread(new Runnable() {
            public void run() {
                canClose = false;
                try {
                    MyThread.sleep(5000);
                } catch(InterruptedException e) {
                }
                canClose = true;
                NewRequestDialog.getNewRequestDialog().attemptToClose();
            }
        }, "RequstPanel canClose thread");
    }

    public TransferrableObject getTo() {
        return to;
    }

    public PopupPanel getPopupPanel() {
        if(pp == null)
            pp = new PopupPanel(this);
        return pp;
    }

    public boolean CanClose() {
        return canClose;
    }

    public void startCanClose() {
        t.start();//start the thread
    }
}
