package com.onlinestore.app.dao;

import com.onlinestore.app.dto.ProductDTO;
import com.onlinestore.utils.CommonUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

public class ProductDAO {
    public ProductDTO insertProduct(String pname, String pid, String pdescr, String pquantity, String pcategory, String pprice, String pImagePath, InputStream is) throws SQLException, IOException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProductDTO productDTO = null;
        BufferedInputStream bs = new BufferedInputStream(is, 10000);
        FileOutputStream fo = new FileOutputStream(pImagePath, true);
        BufferedOutputStream bo = new BufferedOutputStream(fo, 10000);
        System.out.println("inside insertProduct() before connection creation");
        try {
            connection = CommonUtils.getConnection();
            pstmt = connection.prepareStatement("insert into product_mst(pname,pid,pdescr,pquantity,pcategory,pprice,pimage) values(?,?,?,?,?,?,?) ");
            pstmt.setString(1, pname);
            pstmt.setString(2, pid);
            pstmt.setString(3, pdescr);
            pstmt.setString(4, pquantity);
            pstmt.setString(5, pcategory);
            pstmt.setString(6, pprice);
            pstmt.setString(7, pImagePath);
            System.out.println("after connection and before bs.read()");
            System.out.println("pstmt is " + pstmt);
            int noOfRecordsUpdated = pstmt.executeUpdate();
            System.out.println("no of records is " + noOfRecordsUpdated);
            if (noOfRecordsUpdated > 0) {
                productDTO = new ProductDTO();
                productDTO.setPname(pname);
                productDTO.setPid(pid);
                productDTO.setPdescr(pdescr);
                productDTO.setPquantity(pquantity);
                productDTO.setPprice(pprice);
                productDTO.setPimage(pImagePath);
                System.out.println("product is  " + productDTO.getPname());
            }
            int singleByte = bs.read();
            while (singleByte != -1) {
                bo.write(singleByte);
                singleByte = bs.read();
            }
            bs.close();
            bo.close();
            System.out.println("image stored successfully ");
            ProductDTO productDTO2 = productDTO;
            return productDTO2;
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}