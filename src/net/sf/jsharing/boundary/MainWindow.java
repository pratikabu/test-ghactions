/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on 30 Oct, 2010, 4:17:03 PM
 */

package net.sf.jsharing.boundary;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jsharing.components.FileModule;
import net.sf.jsharing.components.SavedIPInfo;
import net.sf.jsharing.components.UsefulMethods;
import net.sf.jsharing.network.NetworkActivity;
import net.sf.jsharing.network.Server;
import org.apache.log4j.Level;
import pratikabu.logging.log4j.LogExplorer;
import pratikabu.threading.ExitThreadsMonitorWindow;
import pratikabu.threading.ThreadManager;
import pratikabu.threading.ThreadsMonitorWindow;

/**
 * 
 * @author Pratik
 */
public class MainWindow extends javax.swing.JFrame implements NetworkActivity {
	private Server server;

	public static MainWindow mw;

	/** Creates new form MainWindow */
	public MainWindow() {
		server = new Server(this);
		initComponents();

		jButton8.requestFocus();

		tablesInit();
		startServer(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				exitProgram();
			}
		});

		loadSavedIPs();
		this.jTable1.requestFocus();
		UsefulMethods.placeAtRightBottomLocation(this);
		this.pack();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel6 = new javax.swing.JPanel();
		jSeparator2 = new javax.swing.JSeparator();
		jPanel7 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton5 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JPopupMenu.Separator();
		jMenuItem12 = new javax.swing.JMenuItem();
		jMenuItem13 = new javax.swing.JMenuItem();
		jMenuItem15 = new javax.swing.JMenuItem();
		jSeparator7 = new javax.swing.JPopupMenu.Separator();
		jMenuItem16 = new javax.swing.JMenuItem();
		jMenuItem17 = new javax.swing.JMenuItem();
		jSeparator6 = new javax.swing.JPopupMenu.Separator();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenuItem8 = new javax.swing.JMenuItem();
		jSeparator5 = new javax.swing.JPopupMenu.Separator();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JPopupMenu.Separator();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem9 = new javax.swing.JMenuItem();
		jMenuItem10 = new javax.swing.JMenuItem();
		jMenuItem11 = new javax.swing.JMenuItem();
		jSeparator4 = new javax.swing.JPopupMenu.Separator();
		jMenuItem14 = new javax.swing.JMenuItem();
		jMenuItem1 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("JSharing- Alpha Version");

		jPanel6.setLayout(new java.awt.BorderLayout());
		jPanel6.add(jSeparator2, java.awt.BorderLayout.NORTH);

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/net/sf/jsharing/resources/serverrunning.gif"))); // NOI18N
		jLabel2.setToolTipText("Sever is Running");

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel1.setText("Server Status");
		jLabel1.setToolTipText("Server Status");

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel7Layout
										.createSequentialGroup()
										.addContainerGap(19, Short.MAX_VALUE)
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												311,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel2,
						javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(jLabel1,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 24,
						Short.MAX_VALUE));

		jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "Name", "IP", "Port" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/net/sf/jsharing/resources/remove.gif"))); // NOI18N
		jButton5.setToolTipText("Remove Selected Computer.");
		jButton5.setFocusable(false);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/net/sf/jsharing/resources/add.gif"))); // NOI18N
		jButton7.setToolTipText("Add New Computer");
		jButton7.setFocusable(false);
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setText("Send Files");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/net/sf/jsharing/resources/edit.gif"))); // NOI18N
		jButton10.setToolTipText("Edit Selected Computer.");
		jButton10.setFocusable(false);
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																315,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				24,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				148,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton8)))
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												206, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jButton8)
														.addComponent(jButton7)
														.addComponent(jButton10)
														.addComponent(jButton5))
										.addContainerGap()));

		jTabbedPane1.addTab("Saved Connections", jPanel3);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "Name", "IP", "Port" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(jTable2);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 315,
								Short.MAX_VALUE).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 237,
								Short.MAX_VALUE).addContainerGap()));

		jTabbedPane1.addTab("Active Connections (Nil)", jPanel2);

		jMenu1.setText("File");

		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_N,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem2.setMnemonic('S');
		jMenuItem2.setText("Send Files");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);
		jMenu1.add(jSeparator1);

		jMenuItem12.setText("Log Explorer");
		jMenuItem12.setEnabled(false);
		jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem12ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem12);

		jMenuItem13.setText("Thread Monitor");
		jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem13ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem13);

		jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem15.setText("Data Counter");
		jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem15ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem15);
		jMenu1.add(jSeparator7);

		jMenuItem16.setText("Server Logs");
		jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem16ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem16);

		jMenuItem17.setText("Client Logs");
		jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem17ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem17);
		jMenu1.add(jSeparator6);

		jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_Q,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem5.setMnemonic('x');
		jMenuItem5.setText("Exit");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem5);

		jMenuBar1.add(jMenu1);

		jMenu3.setText("Server");

		jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem7.setText("Start Server");
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem7);

		jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_D,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem8.setText("Stop Server");
		jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem8);
		jMenu3.add(jSeparator5);

		jMenuItem3.setMnemonic('P');
		jMenuItem3.setText("Change Port Number");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem3);

		jMenuItem6.setText("Change Computer Name");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem6);
		jMenu3.add(jSeparator3);

		jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_P,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem4.setText("My Current Port Number");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem4);

		jMenuBar1.add(jMenu3);

		jMenu2.setText("Help");

		jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem9.setText("How to Use (Help)");
		jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem9ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem9);

		jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_J,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem10.setText("JSharing Home Page");
		jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem10ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem10);

		jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_H,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem11.setText("Eighty_Coffee Home Page");
		jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem11ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem11);
		jMenu2.add(jSeparator4);

		jMenuItem14.setText("Check for Updates");
		jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem14ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem14);

		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F1,
				java.awt.event.InputEvent.ALT_MASK));
		jMenuItem1.setText("About");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem1);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
						360, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(10, 10, 10)
								.addComponent(jTabbedPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										340, Short.MAX_VALUE)
								.addGap(10, 10, 10)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jTabbedPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										287, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel6,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
		UploadDialog.getUD().addNewUploadForm(null);
	}// GEN-LAST:event_jMenuItem2ActionPerformed

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		UsefulMethods.log.getLogger().info("Port change request initiated.");
		if (server.isRunning()) {
			JOptionPane.showMessageDialog(this, "The server is running.\n"
					+ "You cannot change the Port Number.\n"
					+ "Kindly Stop the server and then try again.",
					"Cannot Change.", JOptionPane.INFORMATION_MESSAGE);
		} else
			PortNumber.showPortNumber(this);
	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
		exitProgram();
	}// GEN-LAST:event_jMenuItem5ActionPerformed

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
		if (SavedIPInfoDialog.showSavedIPInfoDialog(MainWindow.mw, null))
			loadSavedIPs();
	}// GEN-LAST:event_jButton7ActionPerformed

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
		int row = jTable1.getSelectedRow();
		if (row != -1) {
			SavedIPInfo sip = UsefulMethods.getSavedIPInfo(jTable1.getValueAt(
					row, 1).toString());
			UploadDialog.getUD().addNewUploadForm(sip);
		} else
			jMenuItem2ActionPerformed(evt);
	}// GEN-LAST:event_jButton8ActionPerformed

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
		int row = getSavedIPRow();
		if (row != -1) {
			SavedIPInfo sip = UsefulMethods.getSavedIPInfo(jTable1.getValueAt(
					row, 1).toString());
			if (SavedIPInfoDialog.showSavedIPInfoDialog(this, sip))
				loadSavedIPs();
		}
	}// GEN-LAST:event_jButton10ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		int row = getSavedIPRow();
		if (row != -1) {
			SavedIPInfo sip = UsefulMethods.getSavedIPInfo(jTable1.getValueAt(
					row, 1).toString());
			int choice = JOptionPane.showConfirmDialog(this,
					"You are about to delete: " + sip.getName() + "\n" + "IP: "
							+ sip.getIp() + "\n"
							+ "Do you want to remove the selected IP Info?",
					"Confirm Delete", JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.YES_OPTION) {
				UsefulMethods.savedIPs.remove(sip.getIp());
				loadSavedIPs();
			}
		}
	}// GEN-LAST:event_jButton5ActionPerformed

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
		String serverName = JOptionPane.showInputDialog(this, "Computer Name",
				UsefulMethods.getComputerName());
		if (serverName != null) {
			if (!serverName.contains(",")) {
				UsefulMethods.props.setProperty(UsefulMethods.P_SERVER_NAME,
						serverName);
			} else {
				JOptionPane.showMessageDialog(this,
						"The computer name cannot contains \",\".\n"
								+ "Kindly change the name.");
			}
		}
	}// GEN-LAST:event_jMenuItem6ActionPerformed

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem7ActionPerformed
		startServer(false);
	}// GEN-LAST:event_jMenuItem7ActionPerformed

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem8ActionPerformed
		shutDownServer(false);
	}// GEN-LAST:event_jMenuItem8ActionPerformed

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
		PortNumber.showPortNumber(this, false);
	}// GEN-LAST:event_jMenuItem4ActionPerformed

	private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem9ActionPerformed
		UsefulMethods.browse(UsefulMethods.URL_HOW_TO_USE_PAGE);
	}// GEN-LAST:event_jMenuItem9ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		new AboutJSharing(this);
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem10ActionPerformed
		UsefulMethods.browse(UsefulMethods.URL_JSHARING_HOME_PAGE);
	}// GEN-LAST:event_jMenuItem10ActionPerformed

	private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem11ActionPerformed
		UsefulMethods.browse(UsefulMethods.URL_HOME_PAGE);
	}// GEN-LAST:event_jMenuItem11ActionPerformed

	private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem12ActionPerformed
		LogExplorer.showLogExplorer(new File(FileModule.LOG_FOLDER));
	}// GEN-LAST:event_jMenuItem12ActionPerformed

	private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem13ActionPerformed
		ThreadsMonitorWindow.showRunningThreads();
	}// GEN-LAST:event_jMenuItem13ActionPerformed

	private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem14ActionPerformed
		new UpdateAvailable(this, null);
	}// GEN-LAST:event_jMenuItem14ActionPerformed

	private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem15ActionPerformed
		new SessionDataCounter(this);
	}// GEN-LAST:event_jMenuItem15ActionPerformed

	private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem16ActionPerformed
		UsefulMethods.serverConsole.showConsole();
	}// GEN-LAST:event_jMenuItem16ActionPerformed

	private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem17ActionPerformed
		UsefulMethods.clientConsole.showConsole();
	}// GEN-LAST:event_jMenuItem17ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem10;
	private javax.swing.JMenuItem jMenuItem11;
	private javax.swing.JMenuItem jMenuItem12;
	private javax.swing.JMenuItem jMenuItem13;
	private javax.swing.JMenuItem jMenuItem14;
	private javax.swing.JMenuItem jMenuItem15;
	private javax.swing.JMenuItem jMenuItem16;
	private javax.swing.JMenuItem jMenuItem17;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JMenuItem jMenuItem9;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JPopupMenu.Separator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JPopupMenu.Separator jSeparator3;
	private javax.swing.JPopupMenu.Separator jSeparator4;
	private javax.swing.JPopupMenu.Separator jSeparator5;
	private javax.swing.JPopupMenu.Separator jSeparator6;
	private javax.swing.JPopupMenu.Separator jSeparator7;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;

	// End of variables declaration//GEN-END:variables

	private void startServer(boolean byPassException) {
		if (server.isRunning())
			return;

		int portNumber = UsefulMethods.getPortNumber();

		String reason = null;
		if (!byPassException)
			reason = JOptionPane.showInputDialog(this, "Reason for Start",
					"Port Number Change to " + portNumber);
		else
			reason = "Normal startup of Server.";

		if (reason == null)
			return;

		server.setPortNumber(portNumber);
		try {
			server.startServer();
			server.setState(Server.RUNNING);
			UsefulMethods.log.getLogger().log(Level.INFO,
					"Start request of the server. Reason: " + reason + ".");
		} catch (IOException e) {
			if (!byPassException) {
				JOptionPane.showMessageDialog(
						this,
						"The server encountered a problem while Startup.\n"
								+ "The system replied with: "
								+ e.getLocalizedMessage(),
						"Error while Startup", JOptionPane.ERROR_MESSAGE);
			}
			UsefulMethods.log.log(Level.WARN, "Server cannot start.", e);
			server.setState(Server.EXCEPTION_START);
		}
		toggleServerState();
	}

	private void shutDownServer(boolean byPassException) {
		if (server.isStopped())
			return;

		String reason = null;
		if (!byPassException)
			reason = JOptionPane.showInputDialog(this, "Reason for Shutdown",
					"Force Shutdown");
		else
			reason = "Normal termination of program.";

		if (reason == null)
			return;

		try {
			server.shutdownServer();
			server.setState(Server.STOPPED);
			UsefulMethods.log.getLogger().log(Level.INFO,
					"Shutdown request of the server. Reason: " + reason + ".");
		} catch (Exception e) {
			if (!byPassException) {
				JOptionPane.showMessageDialog(
						this,
						"The server encountered a problem while shutting down.\n"
								+ "The system replied with: "
								+ e.getLocalizedMessage(),
						"Error while Shutdown", JOptionPane.ERROR_MESSAGE);
			}
			UsefulMethods.log.log(Level.WARN, "Server cannot stop.", e);
			server.setState(Server.EXCEPTION_STOP);
		}
		toggleServerState();
	}

	private void toggleServerState() {
		String msg;
		if (server.isRunning()) {
			msg = "Server is up and running on Port Number: "
					+ UsefulMethods.getPortNumber();

			jMenuItem7.setEnabled(false);
			jMenuItem8.setEnabled(true);

			jLabel2.setEnabled(true);
		} else {
			msg = "Server is Stopped.";

			jMenuItem7.setEnabled(true);
			jMenuItem8.setEnabled(false);

			jLabel2.setEnabled(false);
		}

		if (server.getState() == Server.EXCEPTION_START) {
			msg = "Port busy. Try other port.";
		} else if (server.getState() == Server.EXCEPTION_STOP) {
			msg = "Exception occurred while stopping.";
		}

		if (!server.isRunning())
			message(msg);
		jLabel2.setToolTipText(msg);
	}

	private void tablesInit() {
		jTable1.getTableHeader().setReorderingAllowed(false);
		jTable2.getTableHeader().setReorderingAllowed(false);

		jTable1.getParent().setBackground(Color.WHITE);
		jTable2.getParent().setBackground(Color.WHITE);
	}

	private void exitProgram() {
		boolean exit = true;
		if (!ThreadManager
				.ensureThreadsCompleted(new int[] { ThreadManager.UNINTERRUPTIBLE_THREAD })) {
			exit = false;
			// show running threads
			exit = ExitThreadsMonitorWindow.showRunningThreads(this,
					new int[] { ThreadManager.UNINTERRUPTIBLE_THREAD });
		}

		if (exit) {
			shutDownServer(true);
			UsefulMethods.saveData();
			System.exit(0);
		}
	}

	public void addConnection(String name, String ip, int portNumber) {
		Object[] data = new Object[3];
		data[0] = name;
		data[1] = ip;
		data[2] = portNumber + "";
		((DefaultTableModel) jTable2.getModel()).addRow(data);
		calculateActiveConnections();
	}

	public void removeConnection(String ip, int portNumber) {
		for (int i = 0; i < jTable2.getRowCount(); i++) {
			if (jTable2.getValueAt(i, 1).equals(ip)
					&& jTable2.getValueAt(i, 2).equals(portNumber + "")) {
				((DefaultTableModel) jTable2.getModel()).removeRow(i);
				calculateActiveConnections();
				break;
			}
		}
	}

	private void calculateActiveConnections() {
		int size = jTable2.getRowCount();
		String data = size + "";
		if (size == 0)
			data = "Nil";

		jTabbedPane1.setTitleAt(1, "Active Connections (" + data + ")");
	}

	public void loadSavedIPs() {
		for (int i = jTable1.getRowCount() - 1; i >= 0; i--)
			((DefaultTableModel) jTable1.getModel()).removeRow(i);

		for (Entry<String, SavedIPInfo> entry : UsefulMethods.savedIPs
				.entrySet()) {
			Object[] data = new Object[] { entry.getValue().getName(),
					entry.getValue().getIp(), entry.getValue().getPort() };
			((DefaultTableModel) jTable1.getModel()).addRow(data);
		}
	}

	private int getSavedIPRow() {
		int row = jTable1.getSelectedRow();
		if (row == -1)
			JOptionPane.showMessageDialog(this, "No row selected.\n"
					+ "Kindly select any row and continue.");
		return row;
	}

	public boolean isServerRunning() {
		boolean running = server.isRunning();
		if (!running)
			JOptionPane.showMessageDialog(this,
					"Server is not running. You cannot continue.");
		return running;
	}

	public void message(String msg) {
		jLabel1.setText(msg);
		UsefulMethods.serverConsole.appendLog(msg);
	}

	public void processingFile(String fileName) {
	}
}
