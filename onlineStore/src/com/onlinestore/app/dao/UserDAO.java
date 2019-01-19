
package com.onlinestore.app.dao;

import com.onlinestore.app.dto.RightDTO;
import com.onlinestore.app.dto.UserDTO;
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
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;

public class UserDAO {
    public UserDTO doRegister(String name, String userid, String password, String imagePath, InputStream is, String email, String contact, String address) throws ClassNotFoundException, SQLException, NamingException, IOException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        ResultSet rs = null;
        UserDTO userDTO = null;
        BufferedInputStream bs = new BufferedInputStream(is, 10000);
        FileOutputStream fo = new FileOutputStream(imagePath, true);
        BufferedOutputStream bo = new BufferedOutputStream(fo, 10000);
        ArrayList rights = null;
        System.out.println("inside doRegister before connection creation");
        try {
            connection = CommonUtils.getConnection();
            pstmt = connection.prepareStatement("insert into user_mst(name, password,userid,email,contact,address,imagepath) values(?,?,?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, userid);
            pstmt.setString(4, email);
            pstmt.setString(5, contact);
            pstmt.setString(6, address);
            pstmt.setString(7, imagePath);
            System.out.println("after connection and before bs.read()");
            System.out.println("pstmt is " + pstmt);
            int noOfRecordsUpdated = pstmt.executeUpdate();
            System.out.println("no of records is " + noOfRecordsUpdated);
            if (noOfRecordsUpdated > 0) {
                userDTO = new UserDTO();
                userDTO.setName(name);
                userDTO.setUserid(userid);
                userDTO.setAddress(address);
                userDTO.setContact(contact);
                userDTO.setEmail(email);
                userDTO.setImagelink(imagePath);
                rights = new ArrayList();
                userDTO.setRights(rights);
                System.out.println("hello " + userDTO.getName());
                pstmt2 = connection.prepareStatement("select uid from user_mst where user_mst.userid=?");
                pstmt2.setString(1, userid);
                ResultSet z = pstmt2.executeQuery();
                while (z.next()) {
                    int uid = z.getInt("uid");
                    System.out.println("uid is " + uid);
                    pstmt3 = connection.prepareStatement("insert into user_role_mapping(uid ,roleid) values(?,2)");
                    pstmt3.setInt(1, uid);
                    System.out.println("pstmt3 is " + pstmt3);
                    int c = pstmt3.executeUpdate();
                    if (c <= 0) continue;
                    System.out.println("Successfully Inserted in both the tables ");
                }
            }
            int singleByte = bs.read();
            while (singleByte != -1) {
                bo.write(singleByte);
                singleByte = bs.read();
            }
            bs.close();
            bo.close();
            System.out.println("image stored successfully ");
            UserDTO userDTO2 = userDTO;
            return userDTO2;
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

    public UserDTO doLogin(String userid, String password) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserDTO userDTO = null;
        ArrayList<RightDTO> rights = null;
        try {
            connection = CommonUtils.getConnection();
            System.out.println("inside doLogin before pstmt");
            pstmt = connection.prepareStatement("select user_mst.name,user_mst.email,user_mst.contact,user_mst.address,user_mst.imagepath,USER_MST.userid AS USERID, ROLE_MST.name AS ROLE, RIGHT_MST.NAME AS RIGHT  ,RIGHT_MST.SCREEN FROM USER_MST, ROLE_MST,RIGHT_MST,USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE USER_MST.UID=USER_ROLE_MAPPING.UID AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID AND USER_MST.userid=?  AND USER_MST.PASSWORD= ? ");
            pstmt.setString(1, userid);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            System.out.println("inside doLogin after pstmt is " + pstmt);
            while (rs.next()) {
                if (userDTO == null) {
                    System.out.println("inside rs.next() ");
                    userDTO = new UserDTO();
                    userDTO.setName(rs.getString("name"));
                    userDTO.setAddress(rs.getString("address"));
                    userDTO.setContact(rs.getString("contact"));
                    userDTO.setEmail(rs.getString("email"));
                    userDTO.setImagelink(rs.getString("imagepath"));
                    userDTO.setRoleName(rs.getString("ROLE"));
                    userDTO.setUserid(rs.getString("USERID"));
                    userDTO.setRoleName(rs.getString("ROLE"));
                    rights = new ArrayList<RightDTO>();
                    userDTO.setRights(rights);
                    System.out.println("hello " + userDTO.getUserid());
                }
                RightDTO right = new RightDTO(rs.getString("RIGHT"), rs.getString("screen"));
                rights.add(right);
            }
            UserDTO userDTO2 = userDTO;
            return userDTO2;
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