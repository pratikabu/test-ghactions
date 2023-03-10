/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PopupPanel.java
 *
 * Created on 5 Nov, 2010, 1:07:30 AM
 */

package net.sf.jsharing.boundary;

import net.sf.jsharing.components.RequestPanel;
import net.sf.jsharing.components.TransferrableObject;
import net.sf.jsharing.components.UsefulMethods;

/**
 * 
 * @author Pratik
 */
public class PopupPanel extends javax.swing.JPanel {
	private RequestPanel rp;

	/** Creates new form PopupPanel */
	public PopupPanel(RequestPanel rp) {
		initComponents();

		this.rp = rp;
		loadData();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();

		setBackground(new java.awt.Color(204, 255, 255));
		setLayout(new java.awt.BorderLayout());

		jPanel1.setBackground(new java.awt.Color(204, 255, 255));
		jPanel1.setLayout(new java.awt.BorderLayout());

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel1.setText("<html><body>&nbsp;&nbsp;Download:&nbsp;</body></html>");
		jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_START);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel2.setText("<IP, Port Number>");
		jPanel1.add(jLabel2, java.awt.BorderLayout.CENTER);

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel3.setText("<html><body><a href=\"\">Show</a>&nbsp;&nbsp;</body></html>");
		jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel3MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel3, java.awt.BorderLayout.LINE_END);

		add(jPanel1, java.awt.BorderLayout.CENTER);
		add(jSeparator1, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>//GEN-END:initComponents

	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel3MouseClicked
		DownloadDialog.getDD().showDialog();
		NewRequestDialog.getNewRequestDialog().removePopupPanel(this);
	}// GEN-LAST:event_jLabel3MouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JSeparator jSeparator1;

	// End of variables declaration//GEN-END:variables

	private void loadData() {
		TransferrableObject to = rp.getTo();
		String ipAddress = to.getServerAddress().getHostAddress();

		String shortName = to.getComputerName();
		if (UsefulMethods.isIPSaved(ipAddress)) {
			shortName = UsefulMethods.getShortNameOfIP(ipAddress);
		}

		this.jLabel2.setText(shortName + ", " + ipAddress + ", "
				+ to.getPortNumber());

		if (rp instanceof DownloadPanel)
			jLabel1.setText("Download:");
		else
			jLabel1.setText("Chat:");
	}
}
