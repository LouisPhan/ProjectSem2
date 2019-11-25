/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emloyeetransfermanagement.frame;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MyPC
 */
public class ProjectTypeManagement extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProjectTypeManagement
     */
Connection conn = null;
DBConnection connection = new DBConnection();
PreparedStatement pst = null;
ResultSet rs = null;        
static String test;
static String mark;
    public ProjectTypeManagement() {
        conn = connection.dbConncetor();
        initComponents();
        remove_title_bar();
        showRecord();
    }
void remove_title_bar(){
        putClientProperty("ProjectTypeManagement.isPalette",Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }

public String mark(){
    return mark;
}


public void showRecord(){
        String query = "select * from ProjectType";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
           projectTypeTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTypeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public void deplace(){
        try {
            int row = projectTypeTable.getSelectedRow();
            ProjectTypeManagement.test =(projectTypeTable.getModel().getValueAt(row, 0).toString());
            
            String query = "select * from ProjectType where ProjectTypeID ='"+test+"'";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t1);
                String t2 = rs.getString("ProjectTypeName");
                txtProjectTypeName.setText(t2);
                String t3 = rs.getString("Description");
                txtDescription.setText(t3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTypeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public String getTableResult(){
        return test;
    }

public void clearInfor(){
    txtProjectTypeName.setText("");
    txtProjectTypeID.setText("");
    txtDescription.setText("");
}

public void search(){
            try {
            String query = "select * from ProjectType where ProjectTypeID LIKE ? ";
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + txtProjectTypeSearch.getText() + "%");
            rs = pst.executeQuery();
            
            projectTypeTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }
        
        try {
            String query1 = "select * from ProjectType where ProjectTypeName LIKE ? ";
            pst = conn.prepareStatement(query1);
            pst.setString(1,"%" + txtProjectTypeSearch.getText() + "%");
            rs = pst.executeQuery();
            
            projectTypeTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }
        
        try {
            String query2 = "select * from ProjectType where ProjectTypeID like ?";
            pst = conn.prepareStatement(query2);
            pst.setString(1,"%" + txtProjectTypeSearch.getText()+ "%");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t1);
                String t2 = rs.getString("ProjectTypeName");
                txtProjectTypeName.setText(t2);
                String t3 = rs.getString("Description");
                txtDescription.setText(t3);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }
        
        try {
            String query3 = "select * from ProjectType where ProjectTypeName like ?";
            pst = conn.prepareStatement(query3);
            pst.setString(1,"%" + txtProjectTypeSearch.getText() + "%");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t1);
                String t2 = rs.getString("ProjectTypeName");
                txtProjectTypeName.setText(t2);
                String t3 = rs.getString("Description");
                txtDescription.setText(t3);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
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

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectTypeTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProjectTypeName = new javax.swing.JLabel();
        txtProjectTypeID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        deleteProjectType = new javax.swing.JButton();
        modifyProjectType = new javax.swing.JButton();
        addProjectType = new javax.swing.JButton();
        txtProjectTypeSearch = new javax.swing.JTextField();
        searchProjectType = new javax.swing.JButton();
        resetProjectType = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setTitle("Project type management");
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
        jLabel2.setText("Project type Option");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(995, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        projectTypeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        projectTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectTypeTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                projectTypeTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(projectTypeTable);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Type's Information"));

        jLabel3.setText("Project Type ID:");

        jLabel4.setText("Project Type Name:");

        txtProjectTypeName.setForeground(new java.awt.Color(0, 153, 204));

        txtProjectTypeID.setForeground(new java.awt.Color(0, 153, 204));

        jLabel1.setText("Description: ");

        jScrollPane2.setBorder(null);

        txtDescription.setEditable(false);
        txtDescription.setBorder(null);
        txtDescription.setForeground(new java.awt.Color(0, 153, 204));
        txtDescription.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(txtDescription);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProjectTypeName, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)
                        .addComponent(txtProjectTypeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtProjectTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtProjectTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        deleteProjectType.setText("Delete");
        deleteProjectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProjectTypeActionPerformed(evt);
            }
        });

        modifyProjectType.setText("Modify");
        modifyProjectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyProjectTypeActionPerformed(evt);
            }
        });

        addProjectType.setText("Add");
        addProjectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProjectTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(deleteProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtProjectTypeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectTypeSearchActionPerformed(evt);
            }
        });
        txtProjectTypeSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProjectTypeSearchKeyReleased(evt);
            }
        });

        searchProjectType.setText("Search");
        searchProjectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProjectTypeActionPerformed(evt);
            }
        });

        resetProjectType.setText("Reset");
        resetProjectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetProjectTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(searchProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtProjectTypeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProjectTypeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchProjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(resetProjectType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProjectTypeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjectTypeSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProjectTypeSearchActionPerformed

    private void projectTypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTypeTableMouseClicked
        // TODO add your handling code here:
        deplace();
    }//GEN-LAST:event_projectTypeTableMouseClicked

    private void addProjectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProjectTypeActionPerformed

        this.mark = "add";
        addProjectType add = new addProjectType();
        add.setVisible(true);
        add.clear();
        add.autoID();
    }//GEN-LAST:event_addProjectTypeActionPerformed

    private void deleteProjectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProjectTypeActionPerformed
      
        if(JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete this project type out of system ?","",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
        if(txtProjectTypeID.getText().length() != 0){
        try {
            String query = "delete from ProjectType where ProjectTypeID = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, txtProjectTypeID.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Deleted");
                
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "This type of project is esxiting on records in Project Management");
        }
        }else{
            JOptionPane.showMessageDialog(null, "Deleting has been failed");
        }
        }
        clearInfor();
        showRecord();
        
        deleteProjectType.setEnabled(false);
    }//GEN-LAST:event_deleteProjectTypeActionPerformed

    private void projectTypeTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTypeTableMouseReleased
        // TODO add your handling code here:
        deleteProjectType.setEnabled(true);
        modifyProjectType.setEnabled(true);
    }//GEN-LAST:event_projectTypeTableMouseReleased

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        deleteProjectType.setEnabled(false);
        modifyProjectType.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void modifyProjectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyProjectTypeActionPerformed
        this.mark = "modify";
        addProjectType modify = new addProjectType();
        modify.setVisible(true);
        modifyProjectType.setEnabled(false);
    }//GEN-LAST:event_modifyProjectTypeActionPerformed

    private void resetProjectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetProjectTypeActionPerformed
        showRecord();
        clearInfor();
        txtProjectTypeSearch.setText("");
    }//GEN-LAST:event_resetProjectTypeActionPerformed

    private void searchProjectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProjectTypeActionPerformed
        try {
            String query = "select * from ProjectType where ProjectTypeID LIKE ? ";
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + txtProjectTypeSearch.getText() + "%");
            rs = pst.executeQuery();
            
            projectTypeTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }
        
        try {
            String query1 = "select * from ProjectType where ProjectTypeName LIKE ? ";
            pst = conn.prepareStatement(query1);
            pst.setString(1,"%" + txtProjectTypeSearch.getText() + "%");
            rs = pst.executeQuery();
            
            projectTypeTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }
        
        try {
            String query2 = "select * from ProjectType where ProjectTypeID like ?";
            pst = conn.prepareStatement(query2);
            pst.setString(1,"%" + txtProjectTypeSearch.getText()+ "%");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t1);
                String t2 = rs.getString("ProjectTypeName");
                txtProjectTypeName.setText(t2);
                String t3 = rs.getString("Description");
                txtDescription.setText(t3);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }
        
        try {
            String query3 = "select * from ProjectType where ProjectTypeName like ?";
            pst = conn.prepareStatement(query3);
            pst.setString(1,"%" + txtProjectTypeSearch.getText() + "%");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("ProjectTypeID");
                txtProjectTypeID.setText(t1);
                String t2 = rs.getString("ProjectTypeName");
                txtProjectTypeName.setText(t2);
                String t3 = rs.getString("Description");
                txtDescription.setText(t3);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in search");
        }

    }//GEN-LAST:event_searchProjectTypeActionPerformed

    private void txtProjectTypeSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProjectTypeSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)projectTypeTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        projectTypeTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtProjectTypeSearch.getText().trim()));
    }//GEN-LAST:event_txtProjectTypeSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProjectType;
    private javax.swing.JButton deleteProjectType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton modifyProjectType;
    private javax.swing.JTable projectTypeTable;
    private javax.swing.JButton resetProjectType;
    private javax.swing.JButton searchProjectType;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JLabel txtProjectTypeID;
    private javax.swing.JLabel txtProjectTypeName;
    private javax.swing.JTextField txtProjectTypeSearch;
    // End of variables declaration//GEN-END:variables

    void showRecored() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
