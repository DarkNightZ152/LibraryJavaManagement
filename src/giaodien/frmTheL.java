/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package giaodien;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nvcam
 */
public class frmTheL extends javax.swing.JFrame {

    /**
     * Creates new form frmTheL
     */
    public frmTheL() {
        initComponents();
        this.setLocationRelativeTo(null);
        hienthi1();
    }

    private static String status ="";
private void Dieukhien(String status){
    
    if(status.equals("ThemTL"))
    {
         txtMaTL.setText("");
      txtTenTL.setText("");
        txtTim.setEnabled(true);
        txtTenTL.setEnabled(true);
        txtMaTL.setEnabled(true);
        btnLuuTL.setEnabled(true);
        btnResetTL.setEnabled(true);
        btnSuaTL.setEnabled(false);
        btnXoaTL.setEnabled(false);
        btnThemTL.setEnabled(false);
        btnHuy.setEnabled(true);
    }
    else if(status.equals("ResetTL"))
    {
        txtTim.setEnabled(true);
        txtTenTL.setEnabled(false);
        txtMaTL.setEnabled(false);
        btnLuuTL.setEnabled(false);
        btnResetTL.setEnabled(false);
        btnSuaTL.setEnabled(true);
        btnXoaTL.setEnabled(true);
        btnThemTL.setEnabled(true);
        txtMaTL.setText("");
        txtTenTL.setText("");
        btnHuy.setEnabled(false);
    }
    else if(status.equals("SuaTL"))
    {
        txtTim.setEnabled(true);
        txtTenTL.setEnabled(true);
        txtMaTL.setEnabled(true);
        btnLuuTL.setEnabled(true);
        btnResetTL.setEnabled(true);
        btnSuaTL.setEnabled(false);
        btnXoaTL.setEnabled(false);
        btnThemTL.setEnabled(false);
        txtMaTL.requestFocus();
        btnHuy.setEnabled(true);
    }
}
public  void hienthi1()
    {
        tblTheL.removeAll();
        String [] arr = {"Mã Thể Loại","Tên Thể Loại"};
        DefaultTableModel model;
        model = new DefaultTableModel(arr,0);
        java.sql.Connection conn = DBconnection.geConnection();
        String sql = "select * from TheLoai";
        try {
            java.sql.Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
            Vector vct = new Vector();
            vct.add(rs.getString("matl"));
            vct.add(rs.getString("tentl"));
            model.addRow(vct);
            tblTheL.setModel(model);
        }
        } catch (SQLException ex) {
            Logger.getLogger(trangchuthuvien.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel19 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMaTL = new javax.swing.JTextField();
        txtTenTL = new javax.swing.JTextField();
        btnThemTL = new javax.swing.JButton();
        btnXoaTL = new javax.swing.JButton();
        btnResetTL = new javax.swing.JButton();
        btnSuaTL = new javax.swing.JButton();
        btnLuuTL = new javax.swing.JButton();
        btnTimTL = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTheL = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel19.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel19ComponentAdded(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Thông tin thể loại");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Tên thể loai:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Mã thể loại:");

        txtMaTL.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtTenTL.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        btnThemTL.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnThemTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/them.png"))); // NOI18N
        btnThemTL.setText(" Thêm");
        btnThemTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTLActionPerformed(evt);
            }
        });

        btnXoaTL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/delete.png"))); // NOI18N
        btnXoaTL.setText(" Xóa");
        btnXoaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTLActionPerformed(evt);
            }
        });

        btnResetTL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnResetTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/lammoi.png"))); // NOI18N
        btnResetTL.setText("Làm mới");
        btnResetTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTLActionPerformed(evt);
            }
        });

        btnSuaTL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSuaTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/sua.png"))); // NOI18N
        btnSuaTL.setText(" Sửa");
        btnSuaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTLActionPerformed(evt);
            }
        });

        btnLuuTL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLuuTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/luu.png"))); // NOI18N
        btnLuuTL.setText("Lưu");
        btnLuuTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTLActionPerformed(evt);
            }
        });

        btnTimTL.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnTimTL.setText("Tìm Kiếm");

        txtTim.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKeyPressed(evt);
            }
        });

        tblTheL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTheL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTheL);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/searching.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/icon_previous.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/remove (1).png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(217, 217, 217)
                        .addComponent(jLabel14)
                        .addGap(0, 389, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThemTL)
                                    .addComponent(btnLuuTL))
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetTL))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(btnSuaTL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoaTL))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenTL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnTimTL)))
                .addGap(22, 22, 22))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel14))
                    .addComponent(jButton2))
                .addGap(30, 30, 30)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim)
                    .addComponent(btnTimTL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTenTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemTL)
                            .addComponent(btnSuaTL)
                            .addComponent(btnXoaTL))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuuTL)
                            .addComponent(btnResetTL)
                            .addComponent(btnHuy)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTLActionPerformed
        status = "ThemTL";
        Dieukhien(status);
    }//GEN-LAST:event_btnThemTLActionPerformed

    private void btnXoaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTLActionPerformed
        Connection conn = DBconnection.geConnection();
        String sql = "delete from TheLoai where matl='"+txtMaTL.getText()+"'";
        try {
            java.sql.Statement stm = conn.createStatement();
            int i = stm.executeUpdate(sql);
            if(i > 0)
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công!  ");
                System.err.println("Xoa thanh cong");
                hienthi1();
            }
            else{
                JOptionPane.showMessageDialog(this, "Xóa thất bại!  ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(trangchuthuvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaTLActionPerformed

    private void btnResetTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTLActionPerformed
        txtMaTL.setText("");
        txtTenTL.setText("");
    }//GEN-LAST:event_btnResetTLActionPerformed

    private void btnSuaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTLActionPerformed
        status = "SuaTL";
        Dieukhien(status);
    }//GEN-LAST:event_btnSuaTLActionPerformed

    private void btnLuuTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTLActionPerformed
        Connection conn = DBconnection.geConnection();

        if(status.equals("ThemTL"))
        {
            if( txtTenTL.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin! ");
            }else{
                String sqlloi = "select * from TheLoai where matl ='"+txtMaTL.getText()+"'";
                try {
                    java.sql.PreparedStatement stm = conn.prepareStatement(sqlloi);
                    ResultSet rs = stm.executeQuery();
                    if (rs.next()){
                        JOptionPane.showMessageDialog(this, "Không thể trùng mã thể loại!");
                    }else{
                        String sql ="insert into TheLoai values ('"+txtMaTL.getText()+"',N'"+txtTenTL.getText()+"')";
                        try {
                            java.sql.Statement stm1 = conn.createStatement();
                            int i = stm1.executeUpdate(sql);
                            if(i > 0)
                            {
                                JOptionPane.showMessageDialog(this, "Thêm thành công!  ");
                                System.out.println("Them thanh cong");
                                Dieukhien("ResetTL");
                                hienthi1();
                            }else{
                                JOptionPane.showMessageDialog(this, "Thêm thất bại!  ");
                                System.err.println("That bai");
                            }
                        } catch (SQLException ex) {
                            System.err.println("Lỗi! "+ex);
                            //Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(trangchuthuvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(status.equals("SuaTL"))
        {
            if(txtMaTL.getText().equals("") || txtTenTL.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin! ");
            }else{
                String sql = "update TheLoai set tentl=N'"+txtTenTL.getText()+"' where matl ='"+txtMaTL.getText()+"'";
                try {
                    java.sql.Statement stm = conn.createStatement();
                    int i = stm.executeUpdate(sql);
                    if ( i > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Sửa thành công!  ");
                        System.err.println("Sua thanh cong");
                        Dieukhien("ResetTL");
                        hienthi1();
                    }else
                    {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại!  ");
                        System.err.println("Sua that bai");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(trangchuthuvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnLuuTLActionPerformed

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed
        //        DefaultTableModel model = (DefaultTableModel)tblTheL.getModel();
        //        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        //        tblTheL.setRowSorter(tr);
        //        tr.setRowFilter(RowFilter.regexFilter(txtTim.getText().trim()));
    }//GEN-LAST:event_txtTimKeyPressed

    private void tblTheLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblTheL.getModel();
        int row = tblTheL.getSelectedRow();
        String matl1 = model.getValueAt(row, 0).toString();
        String tentl1 = model.getValueAt(row, 1).toString();
        txtMaTL.setText(matl1);
        txtTenTL.setText(tentl1);
    }//GEN-LAST:event_tblTheLMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = DBconnection.geConnection();
        if(txtTim.getText().equals(""))
        {

            tblTheL.removeAll();
            String [] arr = {"Ma TL","Ten TL"};
            DefaultTableModel model;
            model = new DefaultTableModel(arr,0);

            String sql = "select * from TheLoai";
            try {
                java.sql.Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    Vector vct = new Vector();
                    vct.add(rs.getString("matl"));
                    vct.add(rs.getString("tentl"));
                    model.addRow(vct);
                    tblTheL.setModel(model);
                }
            } catch (SQLException ex) {
                Logger.getLogger(trangchuthuvien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{

            String sqltim = "select * from TheLoai where matl=N'"+txtTim.getText()+"'";
            try {
                tblTheL.removeAll();
                String [] arr = {"Ma TL","Ten TL"};
                DefaultTableModel model;
                model = new DefaultTableModel(arr,0);

                java.sql.PreparedStatement pt = conn.prepareStatement(sqltim);
                ResultSet rs = pt.executeQuery();
                if(rs.next())
                {
                    Vector vct = new Vector();
                    vct.add(rs.getString("matl"));
                    vct.add(rs.getString("tentl"));
                    model.addRow(vct);
                    tblTheL.setModel(model);

                }

            } catch (SQLException ex) {
                //Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("lỗi "+ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        trangchuthuvien ftv = new trangchuthuvien();
        ftv.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        Dieukhien("ResetTL");
    }//GEN-LAST:event_btnHuyActionPerformed

    private void jPanel19ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel19ComponentAdded
        Dieukhien("ResetTL");
    }//GEN-LAST:event_jPanel19ComponentAdded

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
            java.util.logging.Logger.getLogger(frmTheL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTheL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTheL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTheL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTheL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuuTL;
    private javax.swing.JButton btnResetTL;
    private javax.swing.JButton btnSuaTL;
    private javax.swing.JButton btnThemTL;
    private javax.swing.JLabel btnTimTL;
    private javax.swing.JButton btnXoaTL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTheL;
    private javax.swing.JTextField txtMaTL;
    private javax.swing.JTextField txtTenTL;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}