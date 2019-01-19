<%@ tag language="java" pageEncoding="ISO-8859-1"%>

 <%
 if(session.getAttribute("uid") != null)
 {	
	 String path = request.getContextPath()+"/userImages/" ;
	 String uid = session.getAttribute("uid").toString() ;
	 String extention = ".jpg" ;
 %>
 <a href="profile"  id="userImage" ><img height="50px" width="50px" src="<%=path+uid+extention%>" alt="photo"/></a>
 <%
 }
 %>
