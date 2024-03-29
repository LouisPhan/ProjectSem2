/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emloyeetransfermanagement.frame;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author MyPC
 */
public final class AddProject_table extends javax.swing.JFrame {
    Connection conn = null;
    DBConnection connection = new DBConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    public String status;
    /**
     * Creates new form AddProject_table
     */
    public AddProject_table() {
        initComponents();
        conn = connection.dbConncetor();
        FillCombox();
        Recuper();
        
    }
    

    public boolean checkDate(){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            
            String startDate  = dateFormat.format(calendarSD.getDate());
            String endDate = dateFormat.format(calendarED.getDate());
            
            LocalDate date1 = LocalDate.parse(startDate);
            LocalDate date2 = LocalDate.parse(endDate);
        
     return date1.isBefore(date2);
    }
    
    
    public void hideButton(){
        ProjectManagement mark = new ProjectManagement();
        String marked = mark.mark();
        
        if(marked == "update"){
            buttonUpdate.setVisible(true);
        }else{
            buttonUpdate.setVisible(false);
        }
        
        if(marked == "add"){
            buttonSaveProject.setVisible(true);
        }else{
            buttonSaveProject.setVisible(false);
        }
    }
    
    public void autoID(){
        try {
            String query = "select TOP 1 ProjectID from Project order by ProjectID desc";
            
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            if(rs.next()){
                int t1 = rs.getInt("ProjectID");
                int id = t1 + 1;
                txtProjectID.setText(String.valueOf(id));
            }
                    
            } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(AddProject_table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void FillCombox(){
        try {
            String query = "select * from ProjectType";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String projectTypeID = rs.getString("ProjectTypeID");
                projectTypeCombox.addItem(projectTypeID);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in combox");
        }
        
    }
    
    
    public void Recuper(){
        ProjectManagement modify = new ProjectManagement();
       
        try {
            String test2 = modify.getTableResult();
            String query = "select ProjectID, ProjectName, StartDate, EndDate, RoomName, Coefficient, Status, ProjectTypeID from Project where ProjectID = '"+test2+"'" ;
            
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectID");
                txtProjectID.setText(t1);
                String t2 = rs.getString("ProjectName");
                txtProjectName.setText(t2);
                Date t3 = rs.getDate("StartDate");
                calendarSD.setDate(t3);
                Date t4 = rs.getDate("EndDate");
                calendarED.setDate(t4);
                String t5 = rs.getString("RoomName");
                roomName.setSelectedItem(t5);
                String t6 = rs.getString("Coefficient");
                txtCoeffection.setText(t6);
                String t7 = rs.getString("Status");
                String vbn = t7;
                
                if(vbn.equals("finished")){
                    rbFinished.setSelected(true);
                    status = "finished";
                }
                else if(vbn.equals("unfinished")){
                    rbUnfinished.setSelected(true);
                    status = "unfinished";
                }
                
              String t8 = rs.getNString("ProjectTypeID");
              projectTypeCombox.setSelectedItem(t8);
                
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        } 
    }
    
    public void cleardata(){
       // txtProjectID.setText("");
        txtProjectName.setText("");
        calendarSD.setCalendar(Calendar.getInstance(Locale.getDefault()));
        calendarED.setDate(null);
        roomName.setSelectedIndex(0);
        txtCoeffection.setText("");
        projectTypeCombox.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StatusGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProjectID = new javax.swing.JTextField();
        txtProjectName = new javax.swing.JTextField();
        txtCoeffection = new javax.swing.JTextField();
        roomName = new javax.swing.JComboBox<>();
        projectTypeCombox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rbFinished = new javax.swing.JRadioButton();
        rbUnfinished = new javax.swing.JRadioButton();
        buttonSaveProject = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        calendarSD = new com.toedter.calendar.JDateChooser();
        calendarED = new com.toedter.calendar.JDateChooser();
        buttonUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add information of project");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Projec ID:");

        jLabel2.setText("Project Name:");

        jLabel3.setText("Start Date:");

        jLabel4.setText("End Date:");

        jLabel5.setText("Room Name:");

        jLabel6.setText("Coeffection:");

        jLabel7.setText("Type of Project:");

        txtProjectID.setEnabled(false);
        txtProjectID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectIDActionPerformed(evt);
            }
        });

        txtCoeffection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoeffectionKeyTyped(evt);
            }
        });

        roomName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "101", "102", "103", "104", "105" }));
        roomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNameActionPerformed(evt);
            }
        });

        projectTypeCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        projectTypeCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectTypeComboxActionPerformed(evt);
            }
        });

        jLabel8.setText("Status:");

        StatusGroup.add(rbFinished);
        rbFinished.setText("Finished");
        rbFinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFinishedActionPerformed(evt);
            }
        });

        StatusGroup.add(rbUnfinished);
        rbUnfinished.setText("Unfinished");
        rbUnfinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUnfinishedActionPerformed(evt);
            }
        });

        buttonSaveProject.setText("Save");
        buttonSaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveProjectActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Information of project");

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(roomName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(calendarSD, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarED, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbFinished)
                                .addGap(44, 44, 44)
                                .addComponent(rbUnfinished))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonUpdate)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonSaveProject, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtCoeffection, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(projectTypeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarED, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarSD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCoeffection, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rbFinished)
                    .addComponent(rbUnfinished))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(projectTypeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSaveProject, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameActionPerformed

    private void projectTypeComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectTypeComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectTypeComboxActionPerformed

    private void buttonSaveProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveProjectActionPerformed
        // TODO add your handling code here
        
        ProjectManagement show = new ProjectManagement();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        
        try {
            if(txtProjectName.getText().equalsIgnoreCase("") || txtCoeffection.getText().equalsIgnoreCase("") || StatusGroup.isSelected(null) || roomName.getSelectedItem().equals("Select") || projectTypeCombox.getSelectedItem().equals("Select")){
                JOptionPane.showMessageDialog(null, "Some fields are empty or not selcted");
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
        String query = "insert into Project(ProjectID, ProjectName, StartDate, EndDate, RoomName, Status, Coefficient, ProjectTypeID) values (?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(query);
        
        pst.setString(1, txtProjectID.getText());
        pst.setString(2, txtProjectName.getText());
        pst.setString(3, dateFormat.format(calendarSD.getDate()));
        pst.setString(4, dateFormat.format(calendarED.getDate()));
        
            if(!checkDate()){
                JOptionPane.showMessageDialog(null, "Error in the date, please check again");
                return;
            }
        
        pst.setString(5, (String) roomName.getSelectedItem());
        pst.setString(6, status);        
        pst.setString(7, txtCoeffection.getText());
        pst.setString(8, (String) projectTypeCombox.getSelectedItem());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Saved");

        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally{
            try {
                pst.close();
                //rs.close();     
                dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
       
        
        
      show.showRecord();
      
      
    }//GEN-LAST:event_buttonSaveProjectActionPerformed

    private void rbFinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFinishedActionPerformed
        status = "finished";
    }//GEN-LAST:event_rbFinishedActionPerformed

    private void rbUnfinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUnfinishedActionPerformed
        status = "unfinished";
    }//GEN-LAST:event_rbUnfinishedActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String t1 = txtProjectID.getText();
        String t2 = txtProjectName.getText();
        String t3 = dateFormat.format(calendarSD.getDate());
        String t4 = dateFormat.format(calendarED.getDate());
        
        if(!checkDate()){
            JOptionPane.showMessageDialog(null, "Error in date, please check again!");
            return;
        }
        
        String t5 = (String) roomName.getSelectedItem();
        String t6 = txtCoeffection.getText();
        String t8 = (String) projectTypeCombox.getSelectedItem();
        
        String query = "update Project set ProjectName = '"+t2+"', StartDate = '"+t3+"', EndDate = '"+t4+"', RoomName = '"+t5+"', Status = '"+status+"', Coefficient = '"+t6+"', ProjectTypeID = '"+t8+"' where ProjectID = '"+t1+"' ";
        try {
        pst = conn.prepareStatement(query);
        pst.execute();    
        JOptionPane.showMessageDialog(null, "Updated");
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }finally{
            try {
                pst.close();
                dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    ProjectManagement show = new ProjectManagement();
    show.showRecord();
        
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        hideButton();
    }//GEN-LAST:event_formWindowOpened

    private void txtProjectIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjectIDActionPerformed
        autoID();
    }//GEN-LAST:event_txtProjectIDActionPerformed

    private void txtCoeffectionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoeffectionKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c) && !evt.isAltDown()){
            evt.consume();
        }
        
    }//GEN-LAST:event_txtCoeffectionKeyTyped

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
            java.util.logging.Logger.getLogger(AddProject_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProject_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProject_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProject_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProject_table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup StatusGroup;
    private javax.swing.JButton buttonSaveProject;
    private javax.swing.JButton buttonUpdate;
    private com.toedter.calendar.JDateChooser calendarED;
    private com.toedter.calendar.JDateChooser calendarSD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> projectTypeCombox;
    private javax.swing.JRadioButton rbFinished;
    private javax.swing.JRadioButton rbUnfinished;
    private javax.swing.JComboBox<String> roomName;
    private javax.swing.JTextField txtCoeffection;
    private javax.swing.JTextField txtProjectID;
    private javax.swing.JTextField txtProjectName;
    // End of variables declaration//GEN-END:variables
}
