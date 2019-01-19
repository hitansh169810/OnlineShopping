<%
	if(session.getAttribute("uid")==null){
		response.sendRedirect("index.html");
	}
	%>
	<div id="jsonData">
	<h3>Delete Product</h3>
	<h2>Welcome <%=session.getAttribute("uid") %></h2>
	</div>
