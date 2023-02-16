/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dias
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }
            else{
                lbl_bookError.setText("invalid book ID");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getStudentDetails(){
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));
            }
            else{
                lbl_studentError.setText("invalid student ID");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1 = uIssueDate.getTime();
        long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details1(book_id, book_name, student_id, student_name, "
                    + "issue_date, due_date, status) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isIssued = true;
            }
            else{
                isIssued = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isIssued;
    }
    
    public void updateBookCount(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Books count is updated now!");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Update failure :(");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select from * issue_book_details1 where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0){
                isAlreadyIssued = true;
            }
            else{
                isAlreadyIssued = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel17 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Book Details");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book ID:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Author:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Name:");

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bookError)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_author, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(lbl_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lbl_author, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(lbl_bookError)
                .addGap(105, 105, 105))
        );

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel8.setText("Student Details");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student ID:");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Major:");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student's Name:");

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(93, 93, 93))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(lbl_studentError))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_course, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(lbl_studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel12))
                                    .addComponent(lbl_studentName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jLabel10))
                            .addComponent(lbl_course, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11)))
                .addGap(92, 92, 92)
                .addComponent(lbl_studentError)
                .addGap(0, 136, Short.MAX_VALUE))
        );

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        jLabel13.setText("Issue book");
        panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 160, 210, 70));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 350, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel14.setText("Student ID");
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, -1, -1));

        txt_bookId.setBackground(new java.awt.Color(204, 204, 204));
        txt_bookId.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookId.setPlaceholder("Enter Book ID");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 302, 260, 50));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel15.setText("Due date");
        panel_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 580, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel16.setText("Book ID");
        panel_main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, -1, -1));

        txt_studentId.setBackground(new java.awt.Color(204, 204, 204));
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setPlaceholder("Enter Student ID");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 382, 260, 50));

        date_dueDate.setColorBackground(new java.awt.Color(0, 0, 0));
        date_dueDate.setPlaceholder("Select due date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 570, 280, -1));

        date_issueDate.setColorBackground(new java.awt.Color(0, 0, 0));
        date_issueDate.setPlaceholder("Select Issue date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, 280, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel17.setText("Issue date");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 51, 51));
        rSMaterialButtonCircle1.setText("Issue Book");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 660, 230, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1400, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
          getBookDetails();  
        }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
       
        if(!txt_studentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
         if(lbl_quantity.getText().equals("0")){
             JOptionPane.showMessageDialog(this, "Book is not available yet!");
         }
         if( isAlreadyIssued() == false){
            
        if(issueBook() == true){
            JOptionPane.showMessageDialog(this, "Book issued succcessfully");
            updateBookCount();
        }
        else{
            JOptionPane.showMessageDialog(this, "Book issue failure");
        }
        }else{
             JOptionPane.showMessageDialog(this, "this sttudent alread has this book!");
         }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
