
package com.onlinestore.utils;

import com.onlinestore.app.dto.CommonGenericDTO;
import com.onlinestore.app.dto.ProductDTO;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public interface CommonDAO {
    public static ArrayList<CommonGenericDTO> getCommonGenericParameters(String key) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CommonGenericDTO> commonList = new ArrayList<CommonGenericDTO>();
        try {
            con = CommonDAO.getConnection();
            System.out.println("connection created inside commonDAO" + con);
            pstmt = con.prepareStatement("SELECT NAME,DESCR,KEY FROM COMMON_GENERIC_PARAMETERS WHERE COMMON_GENERIC_PARAMETERS.KEY=?");
            System.out.println("pstmt created inside commonDAO" + pstmt);
            pstmt.setString(1, key);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CommonGenericDTO commonGenericDTO = new CommonGenericDTO(rs.getString("name"), rs.getString("descr"));
                commonList.add(commonGenericDTO);
            }
            ArrayList<CommonGenericDTO> arrayList = commonList;
            return arrayList;
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public static ArrayList<ProductDTO> getProducts() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();
        try {
            con = CommonDAO.getConnection();
            System.out.println("connection created inside commonDAO" + con);
            pstmt = con.prepareStatement("select * from product_mst");
            System.out.println("pstmt created inside commonDAO" + pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setPname(rs.getString("pname"));
                productDTO.setPid(rs.getString("pid"));
                productDTO.setPdescr(rs.getString("pdescr"));
                productDTO.setPcategory(rs.getString("pcategory"));
                productDTO.setPprice(rs.getString("pprice"));
                productDTO.setPquantity(rs.getString("pquantity"));
                productDTO.setPimage(String.valueOf(rs.getString("pid")) + ".jpg");
                productList.add(productDTO);
            }
            ArrayList<ProductDTO> arrayList = productList;
            return arrayList;
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
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
}