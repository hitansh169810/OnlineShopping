<%@tag import="com.onlinestore.utils.CommonUtils"%>
<%@tag import="com.onlinestore.app.dto.RightDTO"%>
<%@ attribute name="userDTO" type="com.onlinestore.app.dto.UserDTO" required="true" %>


 <ul class="nav nav-sidebar">
          <% 
          boolean isActive = true;
          if(userDTO!=null && userDTO.getRights()!=null && userDTO.getRights().size()>0){
          for(RightDTO rightDTO : userDTO.getRights()) { %>
          <li class="<%=isActive?"active":"" %>"><a onclick="sideMenu('<%=CommonUtils.getContextPath()%>','<%=rightDTO.getScreenName()%>')" href="#"><%=rightDTO.getName() %></a></li>
          <%
          }
          }
          %>
          
          </ul>