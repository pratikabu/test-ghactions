/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DownloadPopup.java
 *
 * Created on 30 Oct, 2010, 11:42:38 AM
 */

package net.sf.jsharing.boundary;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import net.sf.jsharing.components.FileInfo;
import net.sf.jsharing.components.TransferrableObject;
import net.sf.jsharing.components.UsefulMethods;
import net.sf.jsharing.components.threads.MyThread;
import net.sf.jsharing.components.threads.UninterruptibleThread;
import net.sf.jsharing.network.Client;

/**
 *
 * @author Pratik
 */
public class DownloadPopup extends javax.swing.JFrame implements Runnable {
    private TransferrableObject to;
    private File saveToFile;
    private MyThread t;

    /** Creates new form DownloadPopup */
    private DownloadPopup(TransferrableObject to) {
        this.to = to;
        initComponents();

        resizeTable();
        populateTO();
        populateLastSaveLocation();

        this.setLocationByPlatform(true);
        Toolkit.getDefaultToolkit().beep();
    }

    public static void showDownloadPopup(TransferrableObject to) {
        new DownloadPopup(to).setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Request");

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

        jLabel1.setText("Request From:");

        jLabel2.setText("<IP>");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Save To:");

        jTextField1.setEditable(false);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Download Selected");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Select All");

        jButton5.setText("Deselect All");

        jLabel4.setText("Size:");

        jLabel5.setText("0.0 KB");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsharing/resources/add.gif"))); // NOI18N
        jButton7.setToolTipText("Save this IP to list.");

        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setString("Downloading Files");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        requestToggle(true);
        t = new UninterruptibleThread(this, "Sending List to: " + to.getServerAddress().getHostAddress() + ", " + to.getPortNumber());
        t.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int status = jfc.showOpenDialog(this);

        if(status == JFileChooser.APPROVE_OPTION)
            saveAndLoadSaveLocation(jfc.getSelectedFile());
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void populateTO() {
        if(to != null) {
            String ipAddress = to.getServerAddress().getHostAddress();
            this.jLabel2.setText(ipAddress);

            jButton7.setVisible(!UsefulMethods.isIPSaved(ipAddress));

            for(FileInfo fi : to.getFiles()) {
                ((DefaultTableModel)jTable1.getModel()).addRow(getDetails(fi));
            }
        }
    }

    /**
     * resize the table
     */
    private void resizeTable() {
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

    private Object[] getDetails(FileInfo fi) {
        Object[] objarr = new Object[3];
        objarr[0] = true;
        objarr[1] = fi.getFileName();
        objarr[2] = fi.getSizeFormatted();

        return objarr;
    }

    private void prepareDownloadFiles() {
        int i = 0;
        for(FileInfo fi : to.getFiles()) {
            fi.setDownloadMarked((Boolean)jTable1.getValueAt(i, 0));
        }
    }

    private void downloadFiles() {
        if(to != null && !to.getFiles().isEmpty()) {
            to.setTaskType(UsefulMethods.DOWNLOAD_FILES);
            Client client = new Client(to.getServerAddress(), to.getPortNumber());
            client.setOutputDirectory(saveToFile);
            client.triggerServerTask(to);
        }
    }

    private void populateLastSaveLocation() {
        saveToFile = new File(UsefulMethods.getLastSavedLocation());
        jTextField1.setText(saveToFile.getAbsolutePath());
    }

    private void saveAndLoadSaveLocation(File file) {
        //save to properties
        UsefulMethods.props.setProperty(UsefulMethods.P_LAST_SAVE_LOCATION, file.getAbsolutePath());
        populateLastSaveLocation();
    }

    public void run() {
        prepareDownloadFiles();
        downloadFiles();
        requestToggle(false);
    }

    private void requestToggle(boolean b) {
        jProgressBar1.setVisible(b);
        jButton3.setEnabled(!b);
        jButton1.setEnabled(!b);
    }
}
