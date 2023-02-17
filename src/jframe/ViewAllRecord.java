/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewAllRecord extends javax.swing.JFrame {

    DefaultTableModel model;
    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();
    }

    public void setIssueBookDetailsToTable(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            Class.forName("com.mysql.jdbc.Driver");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details1");
            
            while(rs.next()){
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                Object[] obj = {id, bookName, StudentName, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
                    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
            public void clearTable(){
            DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
            model.setRowCount(0);
        }
            
            public void search(){
    Date uFromDate = date_fromDate.getDatoFecha();
    Date uToDate = date_toDate.getDatoFecha();

    long l1 = uFromDate.getTime();
    long l2 = uToDate.getTime();

    java.sql.Date fromDate = new java.sql.Date(l1);
    java.sql.Date toDate = new java.sql.Date(l2);

    try {
        Connection con = DBConnection.getConnection();
        String sql = "select * from issue_book_details1 where issue_date BETWEEN ? and ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDate(1, fromDate);
        pst.setDate(2, toDate);

        ResultSet rs = pst.executeQuery();

        boolean recordsFound = false;
        while (rs.next()) {
            recordsFound = true;
            String id = rs.getString("id");
            String bookName = rs.getString("book_name");
            String StudentName = rs.getString("student_name");
            String issueDate = rs.getString("issue_date");
            String dueDate = rs.getString("due_date");
            String status = rs.getString("status");

            Object[] obj = {id, bookName, StudentName, issueDate, dueDate, status};
            model = (DefaultTableModel) tbl_issueBookDetails.getModel();
            model.addRow(obj);
        }
        
        if (!recordsFound) {
            JOptionPane.showMessageDialog(this, "No record found!");
        }

        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
            }
                


            
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Records");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        date_toDate.setColorBackground(new java.awt.Color(0, 0, 0));
        date_toDate.setPlaceholder("Select Issue date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 280, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Issue date");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Issue date");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        date_fromDate.setColorBackground(new java.awt.Color(0, 0, 0));
        date_fromDate.setPlaceholder("Select Issue date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 280, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(51, 51, 51));
        rSMaterialButtonCircle3.setText("All");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 210, 210, 80));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 51, 51));
        rSMaterialButtonCircle2.setText("Search");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 130, 210, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 320));

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        tbl_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_issueBookDetails);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1480, 540));

        setBounds(0, 0, 1499, 904);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issueBookDetailsMouseClicked
        

    }//GEN-LAST:event_tbl_issueBookDetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null){
                clearTable();
        search();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select the Date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        clearTable();
        setIssueBookDetailsToTable();
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed


    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_table;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
