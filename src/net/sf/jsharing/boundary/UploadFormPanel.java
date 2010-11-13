/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UploadFormPanel.java
 *
 * Created on 4 Nov, 2010, 10:13:41 PM
 */

package net.sf.jsharing.boundary;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jsharing.components.FileTransferHandler;
import net.sf.jsharing.components.SavedIPInfo;
import net.sf.jsharing.components.TransferrableObject;
import net.sf.jsharing.components.UsefulMethods;
import net.sf.jsharing.components.threads.MyThread;
import net.sf.jsharing.components.threads.UninterruptibleThread;
import net.sf.jsharing.network.Client;
import org.apache.log4j.Level;

/**
 *
 * @author Pratik
 */
public class UploadFormPanel extends javax.swing.JPanel implements Runnable {
    private TransferrableObject to;
    private LinkedHashSet<File> serverFiles = new LinkedHashSet<File>();
    private MyThread t;

    /** Creates new form UploadFormPanel */
    public UploadFormPanel(SavedIPInfo sip) {
        initComponents();

        initTable();
        jPanel1.setTransferHandler(new FileTransferHandler(this));
        populateIPAndPort(sip);
        requestToggle(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Client Details:"));

        jLabel7.setText("IP:");

        jTextField1.setText("192.168.1.7");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("...");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Port:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(21212, 1025, 60000, 1));
        jSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner1, "#####"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Upload Files:"));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "File Name", "Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Total Size:");

        jLabel2.setText("0.00 KB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Close");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setString("Sending Request");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String ipAddress = IPAddressForm.showIPAddressForm(MainWindow.mw, jTextField1.getText());

        if(ipAddress != null) {
            jTextField1.setText(ipAddress);
        }
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setMultiSelectionEnabled(true);
        int status = jfc.showOpenDialog(this);

        if(status == JFileChooser.APPROVE_OPTION) {
            addFiles(jfc.getSelectedFiles());
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        UploadDialog.getUD().removePanel(this);
}//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!MainWindow.mw.isServerRunning())
            return;

        requestToggle(true);
        t = new UninterruptibleThread(this, "Sending List to: " + jTextField1.getText() + ", " + (Integer)jSpinner1.getValue());
        t.start();
}//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void addServerFiles(File file) {
        serverFiles.add(file);
        resetTabelData();
    }

    /**
     * resize the table
     */
    private void initTable() {
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getParent().setBackground(Color.WHITE);
        //rezise
        int size = 20;

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(size);
        size = 200;
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(size);
        size = 75;
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(size);
    }

    private Object[] getDetails(File fi) {
        Object[] objarr = new Object[3];
        objarr[0] = true;
        objarr[1] = fi.getName();
        objarr[2] = UsefulMethods.getFileSize(fi.length());

        return objarr;
    }

    public void run() {
        boolean success = true;
        
        to = new TransferrableObject(UsefulMethods.PROCESS_TRANSFERRABLE_OBJECT);
        to.setPortNumber(UsefulMethods.getPortNumber());
        to.setComputerName(UsefulMethods.getComputerName());

        for(File file : serverFiles)
            to.addFile(file);

        Client client = null;

        try{
            client = new Client(jTextField1.getText(), (Integer)jSpinner1.getValue());
        } catch(UnknownHostException e) {
            success = false;
            JOptionPane.showMessageDialog(this, "Unknown Host Exception is thrown.\n"
                    + "The IP or Port number provided are not known in this network.\n"
                    + "The system replied with:\n"
                    + e.getLocalizedMessage(), "Cannot Connect", JOptionPane.ERROR_MESSAGE);
            UsefulMethods.log.log(Level.ERROR, "Unkown host exception is thrown.", e);
        }

        if(client != null) {
            try {
                client.triggerServerTask(to);
            } catch (IOException ex) {
                success = false;
                JOptionPane.showMessageDialog(this, "Cannot connect to the requested IP and port.\n"
                    + "Check whether they are still available.\n"
                    + "The system replied with: "
                    + ex.getLocalizedMessage(), "Cannot Connect", JOptionPane.ERROR_MESSAGE);
                UsefulMethods.log.log(Level.ERROR, "Cannot connect to request IP and port.", ex);
            }
        }
        requestToggle(false);

        if(success)
            UploadDialog.getUD().removePanel(this);
    }

    private void requestToggle(boolean b) {
        jProgressBar1.setVisible(b);
        jButton3.setEnabled(!b);
        jButton7.setEnabled(!b);
    }

    private void populateIPAndPort(SavedIPInfo sip) {
        jTextField1.setText(sip.getIp());
        jSpinner1.setValue(sip.getPort());
    }

    private void addFiles(File[] selectedFiles) {
        for(File file : selectedFiles) {
            addServerFiles(file);
        }
    }

    public void addFiles(List selectedFiles) {
        for(Object obj : selectedFiles) {
            File file = (File)obj;
            addServerFiles(file);
        }
    }

    private void resetTabelData() {
        for(int i = jTable1.getRowCount()-1; i>=0; i--)
            ((DefaultTableModel)jTable1.getModel()).removeRow(i);

        long totalSize = 0;
        for(File file : serverFiles) {
            totalSize += file.length();
            ((DefaultTableModel)jTable1.getModel()).addRow(getDetails(file));
        }
        jLabel2.setText(UsefulMethods.getFileSize(totalSize));
    }
}
