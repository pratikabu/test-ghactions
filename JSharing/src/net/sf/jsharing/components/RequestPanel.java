/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import javax.swing.JPanel;
import net.sf.jsharing.boundary.PopupPanel;

/**
 *
 * @author Pratik
 */
public class RequestPanel extends JPanel {
    protected TransferrableObject to;

    private PopupPanel pp;

    public RequestPanel(TransferrableObject to) {
        this.to = to;
    }

    public TransferrableObject getTo() {
        return to;
    }

    public PopupPanel getPopupPanel() {
        if(pp == null)
            pp = new PopupPanel(this);
        return pp;
    }
}
