/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package giaodien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nvcam
 */
public class frmSachql extends javax.swing.JFrame {

    /**
     * Creates new form frmSachql
     */
    public frmSachql() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dieukhien("Reset");
        hienthi();
        loadCB();
    }
    
    private static String status ="";
    private void Dieukhien(String status){
    if(status.equals("Reset"))
    {
        txtMaS.setEnabled(false);
        txtNhaXB.setEnabled(false);
        txtSoL.setEnabled(false);
        txtTacG.setEnabled(false);
        txtTenS.setEnabled(false);
        cboMatl.setEnabled(false);
        tarTomT.setEnabled(false);
        txtGia.setEnabled(false);
        dtcNamXB.setEnabled(false);
        btnLuu.setEnabled(false);
        btnReset.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(true);
         btnHuy.setEnabled(false);
          txtGia.setText("");
       txtMaS.setText("");
       txtNhaXB.setText("");
       txtSoL.setText("");
       txtTacG.setText("");
       txtTenS.setText("");
       cboMatl.setSelectedItem("");
       tarTomT.setText("");
    }
    else if(status.equals("Them")){
        txtMaS.setEnabled(false);
        txtNhaXB.setEnabled(true);
        txtSoL.setEnabled(true);
        txtTacG.setEnabled(true);
        txtTenS.setEnabled(true);
        cboMatl.setEnabled(true);
        tarTomT.setEnabled(true);
        txtGia.setEnabled(true);
        dtcNamXB.setEnabled(true);
        btnLuu.setEnabled(true);
        btnReset.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(false);
         txtGia.setText("");
       txtMaS.setText("");
       txtNhaXB.setText("");
       txtSoL.setText("");
       txtTacG.setText("");
       txtTenS.setText("");
       cboMatl.setSelectedItem("");
       tarTomT.setText("");
       btnHuy.setEnabled(true);
    }
    else if(status.equals("Sua"))
    {
        txtMaS.setEnabled(false);
        txtNhaXB.setEnabled(true);
        txtSoL.setEnabled(true);
        txtTacG.setEnabled(true);
        txtTenS.setEnabled(true);
        cboMatl.setEnabled(true);
        tarTomT.setEnabled(true);
        txtGia.setEnabled(true);
        dtcNamXB.setEnabled(true);
        btnLuu.setEnabled(true);
        btnReset.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(false);
         btnHuy.setEnabled(true);
        txtMaS.requestFocus();
    }
   
}
public void loadCB() 
    {
        Connection conn = DBconnection.geConnection();
        String sql ="select * from TheLoai";
        try {
            java.sql.PreparedStatement stm= conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
              this.cboMatl.addItem(rs.getString("matl"));
                
            }
        } catch (SQLException ex) {
           // Logger.getLogger(pane2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
private void hienthi(){
        try {
            tblKQ.removeAll();
            String [] arr = {"Mã Sách","Tên Sách","Mã Thể Loại","Tác Giả","Nhà XB","Năm XB","Giá","Số Lượng","Tóm Tắt"};
            DefaultTableModel model;
            model = new DefaultTableModel(arr, 0); //DefaultTableModel lưu trữ dữ liệu cho JTable trong một > Vector > Vectors .
            
            Connection connection = DBconnection.geConnection();
            
            String query = "SELECT * FROM Sach";
            java.sql.Statement statement =  connection.createStatement();
	    ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                Vector vct = new Vector();
		vct.add(rs.getString("mas"));
                vct.add(rs.getString("tensach"));
                vct.add(rs.getString("matl"));
                vct.add(rs.getString("tacgia"));
                vct.add(rs.getString("nhaxb"));
                vct.add(rs.getString("namxb"));
                vct.add(rs.getString("giasach"));
                vct.add(rs.getString("soluong"));
                vct.add(rs.getString("tomtat"));
                model.addRow(vct);
                tblKQ.setModel(model);
	    }   
        } catch (Exception e) {
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

        jPanel18 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblKQ = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        txtMaS = new javax.swing.JTextField();
        txtTenS = new javax.swing.JTextField();
        txtTacG = new javax.swing.JTextField();
        txtNhaXB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dtcNamXB = new com.toedter.calendar.JDateChooser();
        btnThoat = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cboMatl = new javax.swing.JComboBox<>();
        txtSoL = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tarTomT = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1307, 746));

        jPanel18.setPreferredSize(new java.awt.Dimension(1307, 746));
        jPanel18.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel18ComponentShown(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel32.setText("Mã sách:");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel33.setText("Tên sách:");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel34.setText("Tác giả:");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel35.setText("Năm xuất bản:");

        jScrollPane9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane9MouseClicked(evt);
            }
        });

        tblKQ.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKQMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblKQ);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel40.setText("Nhà xuất bản:");

        txtMaS.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtMaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSActionPerformed(evt);
            }
        });

        txtTenS.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtTacG.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtNhaXB.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 112));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÍ SÁCH");

        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/icon_previous.png"))); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel43.setText("Giá:");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel44.setText("Mã thể loại:");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel42.setText("Số lượng:");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel41.setText("Tóm tắt:");

        cboMatl.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cboMatlComponentAdded(evt);
            }
        });
        cboMatl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMatlActionPerformed(evt);
            }
        });

        txtSoL.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSoL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLActionPerformed(evt);
            }
        });

        tarTomT.setColumns(20);
        tarTomT.setRows(5);
        jScrollPane10.setViewportView(tarTomT);

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/them.png"))); // NOI18N
        btnThem.setText(" Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/exchange1.png"))); // NOI18N
        btnSua.setText("  Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/delete.png"))); // NOI18N
        btnXoa.setText("  Xóa  ");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/luu.png"))); // NOI18N
        btnLuu.setText("     Lưu  ");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/remove (1).png"))); // NOI18N
        btnHuy.setText("     Hủy  ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgicon/lammoi.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnLuu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnReset))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                        .addComponent(btnThoat)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtSoL, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel40)
                                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtTacG, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNhaXB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTenS, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                                    .addComponent(txtMaS))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addComponent(jLabel35)
                                                .addGap(18, 18, 18)
                                                .addComponent(dtcNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(237, 237, 237)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboMatl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))))
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(txtNhaXB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTacG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtcNamXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(cboMatl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 1301, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel18ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel18ComponentShown

    }//GEN-LAST:event_jPanel18ComponentShown

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.setVisible(false);
        trangchuthuvien ftv = new trangchuthuvien();
        ftv.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        Dieukhien("Reset");
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtMaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSActionPerformed

    private void jScrollPane9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane9MouseClicked

    }//GEN-LAST:event_jScrollPane9MouseClicked

    private void tblKQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKQMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblKQ.getModel();
        int row = tblKQ.getSelectedRow();
        String mas = model.getValueAt(row,0).toString();

        String  tens = model.getValueAt(row, 1).toString();
        String tacgia = model.getValueAt(row, 3).toString();
        String  matl = model.getValueAt(row, 2).toString();
        String  nhaxb = model.getValueAt(row, 4).toString();

        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //        String date = sdf.format(dtcNamXB.getDate());
        //        date = tblKQ.getValueAt(row, 5).toString();
        Date ngaysinh;
        try {
            ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(row, 5).toString());
            dtcNamXB.setDate(ngaysinh);
        } catch (ParseException ex) {
            //  Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
        }

        String  gias = model.getValueAt(row, 6).toString();
        String  sol = model.getValueAt(row, 7).toString();
        String  tomt = model.getValueAt(row, 8).toString();
        txtMaS.setText(mas);
        txtGia.setText(gias);
        txtNhaXB.setText(nhaxb);

        txtSoL.setText(sol);
        txtTenS.setText(tens);
        txtTacG.setText(tacgia);
        tarTomT.setText(tomt);
        cboMatl.setSelectedItem(matl);
    }//GEN-LAST:event_tblKQMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        Connection conn = DBconnection.geConnection();

        if(status.equals("Them"))
        {
            if(txtGia.getText().equals("")  || txtNhaXB.getText().equals("") || txtSoL.getText().equals("") || txtTacG.getText().equals("") || txtTenS.getText().equals("") || tarTomT.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin! ");
            }else{
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(dtcNamXB.getDate());
                    
                    String sql = "insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'"+txtTenS.getText()+"',N'"+cboMatl.getSelectedItem()+"',N'"+txtTacG.getText()+"',N'"+txtNhaXB.getText()+"','"+date+"','"+txtGia.getText()+"','"+txtSoL.getText()+"',N'"+tarTomT.getText()+"')";
                    java.sql.Statement stm=  conn.createStatement();
                    int i = stm.executeUpdate(sql);
                    if(i>0)
                    {
                        JOptionPane.showMessageDialog(this, "Thêm thành công!  ");
                        System.out.println("Thêm thành công");
                        hienthi();
                        status="Reset";
                        Dieukhien(status);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại!  ");
                        System.out.println("Thêm thất bại");
                    }
                }catch (SQLException ex) {
                    System.err.println("Cannot connect database, " + ex);
                }
                //                   Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
                            }
        }
        else if(status.equals("Sua"))
        {
            if(txtGia.getText().equals("") || txtMaS.getText().equals("") || txtNhaXB.getText().equals("") || txtSoL.getText().equals("") || txtTacG.getText().equals("") || txtTenS.getText().equals("") || tarTomT.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin! ");
            }else
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(dtcNamXB.getDate());
                try {

                    String sql = "update Sach set tensach=N'"+txtTenS.getText()+"',matl='"+cboMatl.getSelectedItem()+"',tacgia=N'"+txtTacG.getText()+"',nhaxb=N'"+txtNhaXB.getText()+"',namxb='"+date+"',giasach='"+txtGia.getText()+"',soluong='"+txtSoL.getText()+"',tomtat=N'"+tarTomT.getText()+"' where mas=N'"+txtMaS.getText()+"'";

                    java.sql.Statement stm=  conn.createStatement();
                    int i = stm.executeUpdate(sql);
                    if(i>0)
                    {
                        JOptionPane.showMessageDialog(this, "Sửa thành công!  ");
                        System.out.println("Sửa thành công");
                        hienthi();
                        status="Reset";
                        Dieukhien(status);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại!  ");
                        System.out.println("Sửa thất bại");
                    }
                } catch (SQLException ex) {
                    System.err.println("Cannot connect database, " + ex);
                }
            }

        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtGia.setText("");
        txtMaS.setText("");
        txtNhaXB.setText("");
        txtSoL.setText("");
        txtTacG.setText("");
        txtTenS.setText("");
        cboMatl.setSelectedItem("");
        tarTomT.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Connection conn= DBconnection.geConnection();
        String sql ="delete from Sach where mas='"+txtMaS.getText()+"'";
        try {
            java.sql.Statement stm = conn.createStatement();
            int i = stm.executeUpdate(sql);
            if(i>0)
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công!  ");
                System.out.println("Xóa thành công");
                hienthi();
            }else
            {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!  ");
                System.out.println("Xóa thất bại");
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        status = "Them";
        Dieukhien(status);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        status = "Sua";
        Dieukhien(status);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSoLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLActionPerformed

    private void cboMatlComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cboMatlComponentAdded
        loadCB();
    }//GEN-LAST:event_cboMatlComponentAdded

    private void cboMatlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMatlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMatlActionPerformed

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
            java.util.logging.Logger.getLogger(frmSachql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSachql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSachql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSachql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSachql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboMatl;
    private com.toedter.calendar.JDateChooser dtcNamXB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea tarTomT;
    private javax.swing.JTable tblKQ;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtNhaXB;
    private javax.swing.JTextField txtSoL;
    private javax.swing.JTextField txtTacG;
    private javax.swing.JTextField txtTenS;
    // End of variables declaration//GEN-END:variables
}
