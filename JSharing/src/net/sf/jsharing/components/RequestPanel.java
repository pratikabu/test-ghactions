/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import javax.swing.JPanel;
import net.sf.jsharing.boundary.NewRequestDialog;
import net.sf.jsharing.boundary.PopupPanel;
import pratikabu.threading.AbstractThread;
import pratikabu.threading.implementation.InterruptibleThread;

/**
 * 
 * @author Pratik
 */
public class RequestPanel extends JPanel {
	protected TransferrableObject to;
	private PopupPanel pp;
	private AbstractThread t;
	private boolean canClose;
	protected TransferrableObject sendToServer;

	public RequestPanel(TransferrableObject to) {
		this.to = to;
		sendToServer = new TransferrableObject(this.to.getTaskType());
		sendToServer.setComputerName(to.getComputerName());
		sendToServer.setPortNumber(to.getPortNumber());
		sendToServer.setServerAddress(to.getServerAddress());

		t = new InterruptibleThread(new Runnable() {
			public void run() {
				canClose = false;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
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
		if (pp == null)
			pp = new PopupPanel(this);
		return pp;
	}

	public boolean CanClose() {
		return canClose;
	}

	public void startCanClose() {
		t.start();// start the thread
	}
}
