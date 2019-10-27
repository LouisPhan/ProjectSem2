/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emloyeetransfermanagement.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MyPC
 */
public class DBConnection {
    Connection conn = null;
    public Connection dbConncetor(){ //Đây là hàm để connect với DB
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DBEmployeeTransferManagement";
            String user = "sa";
            String password = "phanquanglam1002";
            conn = DriverManager.getConnection(url,user,password);
            if(conn != null){
                JOptionPane.showMessageDialog(null, "Opening connection");
            }
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
