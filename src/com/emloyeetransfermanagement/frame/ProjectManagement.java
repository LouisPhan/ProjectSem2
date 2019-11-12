/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emloyeetransfermanagement.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MyPC
 */
public class ProjectManagement extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProjectManagement
     */
    Connection conn = null;
    DBConnection connection = new DBConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    static String test;
    static String mark;
    
    public ProjectManagement() {
        conn = connection.dbConncetor();
        initComponents();
        remove_title_bar();
        showRecord();
    }

    void remove_title_bar(){
        putClientProperty("ProjectManagement.isPalette",Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    
    public String mark(){
        return mark;
    }
    
    public void showRecord(){
        String query = "select * from project";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            tableProject.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clear(){
        txtProjectID.setText("");
        txtProjectName.setText("");
        txtStartDate.setText("");
        txtEndDate.setText("");
        txtRoomName.setText("");
        txtStatus.setText("");
        txtProjectTypeID.setText("");
        txtCoefficient.setText("");  
    }
    
    
    
    public void deplace(){
        try {
            int row = tableProject.getSelectedRow();
            ProjectManagement.test =(tableProject.getModel().getValueAt(row, 0).toString());
            
            String query = "select * from Project where ProjectID ='"+test+"'";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectID");
                txtProjectID.setText(t1);
                String t2 = rs.getString("ProjectName");
                txtProjectName.setText(t2);
                String t3 = rs.getString("StartDate");
                txtStartDate.setText(t3);
                String t4 = rs.getString("EndDate");
                txtEndDate.setText(t4);
                String t5 = rs.getString("RoomName");
                txtRoomName.setText(t5);
                String t6 = rs.getString("Status");
                txtStatus.setText(t6);
                String t7 = rs.getString("Coefficient");
                txtCoefficient.setText(t7);
                String t8 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t8);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTableResult(){
        return test;
    }
    
    public void search(){
        try {
            String query = "select * from Project where ProjectName LIKE ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1,"%" + txtSearch.getText() + "%");
            
            rs = pst.executeQuery();
            tableProject.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        try {
            String query = "select * from Project where ProjectName LIKE ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + txtSearch.getText() + "%");
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectID");
                txtProjectID.setText(t1);
                String t2 = rs.getString("ProjectName");
                txtProjectName.setText(t2);
                String t3 = rs.getString("StartDate");
                txtStartDate.setText(t3);
                String t4 = rs.getString("EndDate");
                txtEndDate.setText(t4);
                String t5 = rs.getString("RoomName");
                txtRoomName.setText(t5);
                String t6 = rs.getString("Status");
                txtStatus.setText(t6);
                String t7 = rs.getString("Coefficient");
                txtCoefficient.setText(t7);
                String t8 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t8);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        try {
            String query = "select * from Project where ProjectID = ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1, txtSearch.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectID");
                txtProjectID.setText(t1);
                String t2 = rs.getString("ProjectName");
                txtProjectName.setText(t2);
                String t3 = rs.getString("StartDate");
                txtStartDate.setText(t3);
                String t4 = rs.getString("EndDate");
                txtEndDate.setText(t4);
                String t5 = rs.getString("RoomName");
                txtRoomName.setText(t5);
                String t6 = rs.getString("Status");
                txtStatus.setText(t6);
                String t7 = rs.getString("Coefficient");
                txtCoefficient.setText(t7);
                String t8 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t8);
            }
        }catch (SQLException e) {
            System.out.println(e);
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

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProject = new javax.swing.JTable(){
            public boolean isCellEditTable(int d, int c){
                return false;
            }
        };
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProjectID = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JLabel();
        txtRoomName = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        txtCoefficient = new javax.swing.JLabel();
        txtProjectTypeID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonModify = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setTitle("Project Management");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Project Option");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableProject.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProjectMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableProjectMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableProject);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Project's information"));
        jPanel2.setForeground(new java.awt.Color(0, 102, 204));

        jLabel1.setText("Project ID:");

        jLabel3.setText("Project Name:");

        jLabel10.setText("Project Type ID: ");

        jLabel8.setText("Status:");

        jLabel4.setText("Start Date:");

        jLabel5.setText("End Date:");

        jLabel9.setText("Coefficient:");

        jLabel7.setText("Room Name:");

        txtProjectID.setForeground(new java.awt.Color(0, 102, 204));

        txtProjectName.setForeground(new java.awt.Color(0, 102, 204));
        txtProjectName.setMaximumSize(new java.awt.Dimension(7, 16));
        txtProjectName.setMinimumSize(new java.awt.Dimension(7, 16));

        txtStartDate.setForeground(new java.awt.Color(0, 102, 204));
        txtStartDate.setMaximumSize(new java.awt.Dimension(7, 16));
        txtStartDate.setMinimumSize(new java.awt.Dimension(7, 16));

        txtEndDate.setForeground(new java.awt.Color(0, 102, 204));

        txtRoomName.setForeground(new java.awt.Color(0, 102, 204));
        txtRoomName.setMaximumSize(new java.awt.Dimension(7, 16));
        txtRoomName.setMinimumSize(new java.awt.Dimension(7, 16));

        txtStatus.setForeground(new java.awt.Color(0, 102, 204));

        txtCoefficient.setForeground(new java.awt.Color(0, 102, 204));

        txtProjectTypeID.setForeground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtProjectTypeID, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addComponent(txtCoefficient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRoomName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProjectID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCoefficient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProjectTypeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonModify.setText("Modify");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModify, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonModify, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(53, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(buttonSearch)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(buttonReset, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.mark = "add";
        AddProject_table addTable = new AddProject_table();
        addTable.setVisible(true);
        addTable.cleardata();
        addTable.autoID();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProjectMouseClicked
        deplace();
    }//GEN-LAST:event_tableProjectMouseClicked

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            if(txtStatus.getText().equalsIgnoreCase("Unfinished")){ 
                JOptionPane.showMessageDialog(null, "This project is still working, you can't delete it!");
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete this, it can not be recovered?","",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
        if(txtProjectID.getText().length() != 0){
        
        try {
            String query = "delete from project where ProjectID = ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1, txtProjectID.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Deleted");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Delete failed");
            
        }
       }
    
        
        showRecord();
        clear();
        buttonDelete.setEnabled(false);
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void tableProjectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProjectMouseReleased
        buttonDelete.setEnabled(true);
        buttonModify.setEnabled(true);
    }//GEN-LAST:event_tableProjectMouseReleased

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        buttonDelete.setEnabled(false);
        buttonModify.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        this.mark = "update";
        AddProject_table modifyTable = new AddProject_table();
        modifyTable.setVisible(true);
        buttonModify.setEnabled(false);
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        try {
            String query = "select * from Project where ProjectName = ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1, txtSearch.getText());
            
            rs = pst.executeQuery();
            tableProject.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        try {
            String query = "select * from Project where ProjectName = ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1, txtSearch.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectID");
                txtProjectID.setText(t1);
                String t2 = rs.getString("ProjectName");
                txtProjectName.setText(t2);
                String t3 = rs.getString("StartDate");
                txtStartDate.setText(t3);
                String t4 = rs.getString("EndDate");
                txtEndDate.setText(t4);
                String t5 = rs.getString("RoomName");
                txtRoomName.setText(t5);
                String t6 = rs.getString("Status");
                txtStatus.setText(t6);
                String t7 = rs.getString("Coefficient");
                txtCoefficient.setText(t7);
                String t8 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t8);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        try {
            String query = "select * from Project where ProjectID = ?";
            
            pst = conn.prepareStatement(query);
            pst.setString(1, txtSearch.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectID");
                txtProjectID.setText(t1);
                String t2 = rs.getString("ProjectName");
                txtProjectName.setText(t2);
                String t3 = rs.getString("StartDate");
                txtStartDate.setText(t3);
                String t4 = rs.getString("EndDate");
                txtEndDate.setText(t4);
                String t5 = rs.getString("RoomName");
                txtRoomName.setText(t5);
                String t6 = rs.getString("Status");
                txtStatus.setText(t6);
                String t7 = rs.getString("Coefficient");
                txtCoefficient.setText(t7);
                String t8 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t8);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        showRecord();
        txtSearch.setText("");
        clear();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonModify;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSearch;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProject;
    private javax.swing.JLabel txtCoefficient;
    private javax.swing.JLabel txtEndDate;
    private javax.swing.JLabel txtProjectID;
    private javax.swing.JLabel txtProjectName;
    private javax.swing.JLabel txtProjectTypeID;
    private javax.swing.JLabel txtRoomName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtStartDate;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
}
