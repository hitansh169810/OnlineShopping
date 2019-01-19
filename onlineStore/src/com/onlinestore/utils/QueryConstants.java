
package com.onlinestore.utils;

public interface QueryConstants {
    public static final String LOGIN_SQL = "select user_mst.name,user_mst.email,user_mst.contact,user_mst.address,user_mst.imagepath,USER_MST.userid AS USERID, ROLE_MST.name AS ROLE, RIGHT_MST.NAME AS RIGHT  ,RIGHT_MST.SCREEN FROM USER_MST, ROLE_MST,RIGHT_MST,USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE USER_MST.UID=USER_ROLE_MAPPING.UID AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID AND USER_MST.userid=?  AND USER_MST.PASSWORD= ? ";
    public static final String REGISTER_SQL = "insert into user_mst(name, password,userid,email,contact,address,imagepath) values(?,?,?,?,?,?,?)";
    public static final String COMMON_GENERIC_SQL = "SELECT NAME,DESCR,KEY FROM COMMON_GENERIC_PARAMETERS WHERE COMMON_GENERIC_PARAMETERS.KEY=?";
    public static final String INSERT_PRODUCT_SQL = "insert into product_mst(pname,pid,pdescr,pquantity,pcategory,pprice,pimage) values(?,?,?,?,?,?,?) ";
    public static final String GET_ALL_PRODUCT_SQL = "select * from product_mst";
    public static final String GET_UID_QUERY = "select uid from user_mst where user_mst.userid=?";
    public static final String INSERT_INTO_USER_ROLE_MAPPING = "insert into user_role_mapping(uid ,roleid) values(?,2)";
    public static final String CHECK_USERID_EXISTANCE = "select userid from user_mst where user_mst.userid = ?";
}