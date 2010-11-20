/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IPAddress.java
 *
 * Created on 30 Oct, 2010, 3:05:02 PM
 */

package net.sf.jsharing.boundary;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * @author Pratik
 */
public class IPAddressForm extends javax.swing.JDialog {
	private String ipAddress = null;

	/** Creates new form IPAddress */
	private IPAddressForm(java.awt.Frame parent, String ip) {
		super(parent, true);
		initComponents();

		renderIP(ip);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				jButton1ActionPerformed(null);
			}
		});

		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	public static String showIPAddressForm(java.awt.Frame parent, String ip) {
		return new IPAddressForm(parent, ip).ipAddress;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jRadioButton1 = new javax.swing.JRadioButton();
		jSpinner2 = new javax.swing.JSpinner();
		jSpinner3 = new javax.swing.JSpinner();
		jSpinner4 = new javax.swing.JSpinner();
		jSpinner5 = new javax.swing.JSpinner();
		jRadioButton2 = new javax.swing.JRadioButton();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Change IP");

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setText("IPv4");
		jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jRadioButton1ItemStateChanged(evt);
			}
		});

		jSpinner2.setModel(new javax.swing.SpinnerNumberModel(127, 0, 255, 1));

		jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

		jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

		jSpinner5.setModel(new javax.swing.SpinnerNumberModel(1, 0, 255, 1));

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("IPv6");
		jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jRadioButton2ItemStateChanged(evt);
			}
		});

		jButton1.setText("Close");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Ok");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(21,
																										21,
																										21)
																								.addComponent(
																										jSpinner2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jSpinner3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jSpinner4,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jSpinner5,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						jRadioButton1)
																				.addComponent(
																						jRadioButton2)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(27, 27,
																		27)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		206,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addContainerGap(
																		123,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton1)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jRadioButton1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jSpinner2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jSpinner3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jSpinner4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jSpinner5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jRadioButton2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jRadioButton1ItemStateChanged
		toggleIPEntry();
	}// GEN-LAST:event_jRadioButton1ItemStateChanged

	private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jRadioButton2ItemStateChanged
		toggleIPEntry();
	}// GEN-LAST:event_jRadioButton2ItemStateChanged

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.ipAddress = null;
		this.dispose();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		if (jRadioButton2.isSelected()) {
			if (jTextField1.getText().isEmpty()) {
				jButton1ActionPerformed(evt);
			} else
				ipAddress = jTextField1.getText();
		} else {
			ipAddress = jSpinner2.getValue().toString() + "."
					+ jSpinner3.getValue().toString() + "."
					+ jSpinner4.getValue().toString() + "."
					+ jSpinner5.getValue().toString();
		}

		this.dispose();
	}// GEN-LAST:event_jButton2ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JSpinner jSpinner2;
	private javax.swing.JSpinner jSpinner3;
	private javax.swing.JSpinner jSpinner4;
	private javax.swing.JSpinner jSpinner5;
	private javax.swing.JTextField jTextField1;

	// End of variables declaration//GEN-END:variables

	private void toggleIPEntry() {
		boolean isIPv4 = jRadioButton1.isSelected();

		jSpinner2.setEnabled(isIPv4);
		jSpinner3.setEnabled(isIPv4);
		jSpinner4.setEnabled(isIPv4);
		jSpinner5.setEnabled(isIPv4);

		jTextField1.setEnabled(!isIPv4);

		if (!isIPv4)
			jTextField1.requestFocus();
	}

	private void renderIP(String ip) {
		try {
			int[] convertedAddress = null;

			convertedAddress = new int[4];
			String[] sip = ip.split("\\.");

			if (sip.length != 4)
				throw new Exception("Unkown Range. :)");

			for (int i = 0; i < 4; i++) {
				convertedAddress[i] = Integer.parseInt(sip[i]);
				if (!(convertedAddress[i] >= 0 && convertedAddress[i] < 256))
					throw new Exception("Out of range exception.");
			}
			jSpinner2.setValue(convertedAddress[0]);
			jSpinner3.setValue(convertedAddress[1]);
			jSpinner4.setValue(convertedAddress[2]);
			jSpinner5.setValue(convertedAddress[3]);

			jRadioButton1.setSelected(true);
		} catch (Exception e) {// it means IPv6
			jRadioButton2.setSelected(true);
			this.jTextField1.setText(ip);
		}
	}
}
