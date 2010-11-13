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
import java.io.IOException;
import java.util.Map.Entry;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jsharing.components.SavedIPInfo;
import net.sf.jsharing.components.UsefulMethods;
import net.sf.jsharing.network.Server;
import org.apache.log4j.Level;

/**
 *
 * @author Pratik
 */
public class MainWindow extends javax.swing.JFrame {
    private Server server = new Server();

    public static MainWindow mw;

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();

        tablesInit();
        startServer(true);

        jButton3.requestFocus();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                exitProgram();
            }
        });

        loadSavedIPs();
        this.jTable1.requestFocus();
        UsefulMethods.placeAtRightBottomLocation(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
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
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JSharing");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/send.gif"))); // NOI18N
        jButton3.setToolTipText("Send Files (Ctrl+N)");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/chat.gif"))); // NOI18N
        jButton1.setToolTipText("Initiate Chat (Ctrl+K)");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/startServer.png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jSeparator2, java.awt.BorderLayout.NORTH);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/serverrunning.gif"))); // NOI18N
        jLabel2.setToolTipText("Sever is Running");

        jLabel1.setText("Server Status");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "IP", "Port"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/remove.gif"))); // NOI18N
        jButton5.setToolTipText("Remove Selected Computer.");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/add.gif"))); // NOI18N
        jButton7.setToolTipText("Add New Computer");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Send Files");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Start Chat");

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/edit.gif"))); // NOI18N
        jButton10.setToolTipText("Edit Selected Computer.");
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton9))
                    .addComponent(jButton7)
                    .addComponent(jButton10)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Saved Connections", jPanel3);

        jPanel2.setBackground(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "IP", "Port"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Active Connections (Nil)", jPanel2);

        jMenu1.setText("Tasks");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setMnemonic('S');
        jMenuItem2.setText("Send Files");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setMnemonic('C');
        jMenuItem4.setText("Initiate Chat");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
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

        jMenuItem7.setText("Start Server");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

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

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Help");

        jMenuItem1.setText("About");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jButton3ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        UsefulMethods.log.getLogger().info("Port change request initiated.");
        if(server.isRunning()) {
           JOptionPane.showMessageDialog(this, "The server is running.\n"
                   + "You cannot change the Port Number.\n"
                   + "Kindly Stop the server and then try again.", "Cannot Change.", JOptionPane.INFORMATION_MESSAGE);
        } else
            PortNumber.showPortNumber(this);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        UploadDialog.getUD().addNewUploadForm(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        exitProgram();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(SavedIPInfoDialog.showSavedIPInfoDialog(MainWindow.mw, null))
            loadSavedIPs();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int row = getSavedIPRow();
        if(row != -1) {
            SavedIPInfo sip = UsefulMethods.getSavedIPInfo(jTable1.getValueAt(row, 1).toString());
            UploadDialog.getUD().addNewUploadForm(sip);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int row = getSavedIPRow();
        if(row != -1) {
            SavedIPInfo sip = UsefulMethods.getSavedIPInfo(jTable1.getValueAt(row, 1).toString());
            if(SavedIPInfoDialog.showSavedIPInfoDialog(this, sip))
                loadSavedIPs();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = getSavedIPRow();
        if(row != -1) {
            SavedIPInfo sip = UsefulMethods.getSavedIPInfo(jTable1.getValueAt(row, 1).toString());
            int choice = JOptionPane.showConfirmDialog(this, "You are about to delete: " + sip.getName() + "\n"
                    + "IP: " +sip.getIp() + "\n"
                    + "Do you want to remove the selected IP Info?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

            if(choice == JOptionPane.YES_OPTION) {
                UsefulMethods.savedIPs.remove(sip.getIp());
                loadSavedIPs();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String serverName = JOptionPane.showInputDialog(this, "Computer Name", UsefulMethods.getComputerName());
        if(serverName != null) {
            UsefulMethods.props.setProperty(UsefulMethods.P_SERVER_NAME, serverName);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(server.isRunning())
            shutDownServer(false);
        else
            startServer(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        startServer(false);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        shutDownServer(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private void startServer(boolean byPassException) {
        if(server.isRunning())
            return;

        int portNumber = UsefulMethods.getPortNumber();
        
        String reason = null;
        if(!byPassException)
            reason = JOptionPane.showInputDialog(this, "Reason for Start", "Port Number Change to " + portNumber);
        else
            reason = "Normal startup of Server.";

        if(reason == null)
            return;
        
        server.setPortNumber(portNumber);
        try {
            server.startServer();
            server.setState(Server.RUNNING);
            UsefulMethods.log.getLogger().log(Level.INFO, "Start request of the server. Reason: " + reason + ".");
        } catch(IOException e) {
            if(!byPassException) {
                JOptionPane.showMessageDialog(this, "The server encountered a problem while Startup.\n"
                        + "The system replied with: "
                        + e.getLocalizedMessage(), "Error while Startup", JOptionPane.ERROR_MESSAGE);
            }
            UsefulMethods.log.log(Level.WARN, "Server cannot start.", e);
            server.setState(Server.EXCEPTION_START);
        }
        toggleServerState();
    }

    private void shutDownServer(boolean byPassException) {
        if(server.isStopped())
            return;
        
        String reason = null;
        if(!byPassException)
            reason = JOptionPane.showInputDialog(this, "Reason for Shutdown", "Force Shutdown");
        else
            reason = "Normal termination of program.";

        if(reason == null)
            return;

        try{
            server.shutdownServer();
            server.setState(Server.STOPPED);
            UsefulMethods.log.getLogger().log(Level.INFO, "Shutdown request of the server. Reason: " + reason + ".");
        }catch(Exception e){
            if(!byPassException) {
                JOptionPane.showMessageDialog(this, "The server encountered a problem while shutting down.\n"
                        + "The system replied with: "
                        + e.getLocalizedMessage(), "Error while Shutdown", JOptionPane.ERROR_MESSAGE);
            }
            UsefulMethods.log.log(Level.WARN, "Server cannot stop.", e);
            server.setState(Server.EXCEPTION_STOP);
        }
        toggleServerState();
    }

    private void toggleServerState() {
        String msg;
        if(server.isRunning()) {
            msg = "Server is up and running on Port Number: " + UsefulMethods.getPortNumber();
            jButton6.setIcon(new ImageIcon(getClass().getResource("/net/sf/jsharing/resources/stopServer.png")));
            jButton6.setToolTipText("Shutdown Server");

            jMenuItem7.setEnabled(false);
            jMenuItem8.setEnabled(true);

            jLabel2.setEnabled(true);
        } else {
            msg = "Server is Stopped.";
            jButton6.setIcon(new ImageIcon(getClass().getResource("/net/sf/jsharing/resources/startServer.png")));
            jButton6.setToolTipText("Start Server");

            jMenuItem7.setEnabled(true);
            jMenuItem8.setEnabled(false);

            jLabel2.setEnabled(false);
        }

        if(server.getState() == Server.EXCEPTION_START) {
            msg = "Port busy. Try other port.";
        } else if(server.getState() == Server.EXCEPTION_STOP) {
            msg = "Exception occurred while stopping.";
        }

        jLabel2.setToolTipText(msg);
        jLabel1.setText(msg);
    }

    private void tablesInit() {
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);

        jTable1.getParent().setBackground(Color.WHITE);
        jTable2.getParent().setBackground(Color.WHITE);
    }

    private void exitProgram() {
        shutDownServer(true);
        UsefulMethods.saveProperties();
        System.exit(0);
    }

    public void addConnection(String name, String ip, int portNumber) {
        Object[] data = new Object[3];
        data[0] = name;
        data[1] = ip;
        data[2] = portNumber + "";
        ((DefaultTableModel)jTable2.getModel()).addRow(data);
        calculateActiveConnections();
    }

    public void removeConnection(String ip, int portNumber) {
        for(int i=0; i<jTable2.getRowCount(); i++) {
            if(jTable2.getValueAt(i, 1).equals(ip) && jTable2.getValueAt(i, 2).equals(portNumber + "")) {
                ((DefaultTableModel)jTable2.getModel()).removeRow(i);
                calculateActiveConnections();
                break;
            }
        }
    }

    private void calculateActiveConnections() {
        int size = jTable2.getRowCount();
        String data = size + "";
        if(size == 0)
            data = "Nil";

        jTabbedPane1.setTitleAt(1, "Active Connections (" + data + ")");
    }

    public void loadSavedIPs() {
        for(int i=jTable1.getRowCount()-1; i>=0; i--)
            ((DefaultTableModel)jTable1.getModel()).removeRow(i);

        for(Entry<String, SavedIPInfo> entry : UsefulMethods.savedIPs.entrySet()) {
            Object[] data = new Object[]{entry.getValue().getName(), entry.getValue().getIp(), entry.getValue().getPort()};
            ((DefaultTableModel)jTable1.getModel()).addRow(data);
        }
    }

    private int getSavedIPRow() {
        int row = jTable1.getSelectedRow();
        if(row == -1)
            JOptionPane.showMessageDialog(this, "No row selected.\n"
                    + "Kindly select any row and continue.");
        return row;
    }

    public boolean isServerRunning() {
        boolean running = server.isRunning();
        if(!running)
            JOptionPane.showMessageDialog(this, "Server is not running. You cannot continue.");
        return running;
    }
}