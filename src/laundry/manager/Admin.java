/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Baskoro Adi
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Pelanggan
     */
    public DefaultTableModel model;
    private Connection conn = Koneksi.getConnection();
//    ListSelectionModel listselectionmodel;
    
    public Admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Data Admin");
        labelAdmin.setText(String.valueOf(adm.nameAdm));
        model = new DefaultTableModel();
        TableData.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama Admin");
        model.addColumn("Username");
        model.addColumn("Password");
        model.setRowCount(0);
        tampil();
        String id_all = String.valueOf(adm.idAdmin);
        if (id_all.equals("1")) {
            btnDelete.setEnabled(true);
            btnAdd.setEnabled(true);
        }else{
            btnDelete.setEnabled(false);
            btnAdd.setEnabled(false);
        }
    }
    
    public void tampil(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM admin";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Object [] obj = new Object[5];
                obj[0] = rs.getInt("id_admin");
                obj[1] = rs.getString("nama_admin");
                obj[2] = rs.getString("username");
                obj[3] = rs.getString("password");
                model.addRow(obj);
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelAdmin = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Data Admin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 11, -1, -1));

        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, 600, 169));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 234, -1, -1));

        jLabel2.setText("Login as :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 274, -1, -1));
        getContentPane().add(labelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 274, -1, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laundry/manager/logo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        TambahAdmin ta = new TambahAdmin();
        ta.pack();
        ta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DeleteAdmin da = new DeleteAdmin();
        da.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void TableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDataMouseClicked
        // TODO add your handling code here:
        UpdateAdmin ua = new UpdateAdmin();
        ua.pack();
        ua.setVisible(true);
        this.dispose();
        String id = model.getValueAt(TableData.getSelectedRow(),0).toString();
        String nama = model.getValueAt(TableData.getSelectedRow(),1).toString();
        String username = model.getValueAt(TableData.getSelectedRow(),2).toString();
        String password = model.getValueAt(TableData.getSelectedRow(),3).toString();
        
        ua.txtID.setText(id);
        ua.txtAdmin.setText(nama);
        ua.txtUsername.setText(username);
        ua.txtPass.setText(password);
    }//GEN-LAST:event_TableDataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TableData;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdmin;
    // End of variables declaration//GEN-END:variables
}
