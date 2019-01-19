
package com.onlinestore.utils;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CommonUtils {
    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        
        try {

//            InitialContext initialContext = new InitialContext();
//			
//			System.out.println(" Initial context ");
//            Context context = (Context)initialContext.lookup("java:comp/env");
//            System.out.println("context lookup comp.env" + context);
//            DataSource ds = (DataSource)context.lookup("jdbc/onlinestore");
//            System.out.println("Datasource lookup jdbc.onlinestore" + ds);
//            con = ds.getConnection();
//            System.out.println("connection created ");
//            System.out.println("connection get and created " + con);
//            return con;
        	
        	
        	System.out.println("inside getconnection");
            ResourceBundle rb = ResourceBundle.getBundle("config");
            Class.forName(rb.getString("drivername"));
            con = DriverManager.getConnection(rb.getString("dburl"), rb.getString("userid"), rb.getString("password"));
            System.out.println("connection get successfully");
            return con;
        	
        	
        }
        catch (SQLException e) {
            System.out.println("SQL exception" + e);
            e.printStackTrace();
            return con;
        }
    }

    public static String getContextPath() {
        return rb.getString("contextpath");
    }
}