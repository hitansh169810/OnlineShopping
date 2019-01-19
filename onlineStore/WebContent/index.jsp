<!DOCTYPE HTML><%@page import="java.util.List"%><%@page import="com.onlinestore.app.dto.ProductDTO"%><%@page import="java.util.ArrayList"%><%@page import="com.onlinestore.app.dao.ProductDAO"%><%@taglib prefix="os" tagdir="/WEB-INF/tags" %><%@page import="com.onlinestore.app.dto.UserDTO"%>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
	<title>Online Store | Home </title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
		<link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript" src="js/startstop-slider.js"></script>
		
		<script src="js/category.js"></script>
		<script src="js/callajax.js"></script>
		<script src="js/doajax.js"></script>
	
		<style>

.add{
	font-size:14px ;
	font-weight:300 ;
	height: 40px;
    background-color: red;
    color: white;
    width: 100px;
    border: 1px solid darkred;

}

.productTitle{
    font-size: 22px;
    margin: 0px auto;
    text-align: center;
    font-style: italic;
    color: #df4a18;
}

#userImage img{
border-radius: 50% ;
}
.loggedIn {
visibility: hidden  ;
}

.grid_1_of_4 img{
height:160px ;
}
.grid_1_of_4{
    margin-left: 0px;
    height: 265px;
}
.grid_1_of_4 h2{

}

</style>

	</head>
	
	<body>
		<div class="wrap">
			<div class="header">
				<div class="headertop_desc">
					<div class="call">
						<p>
							<span>Need help?</span> call us 
							<span class="number">1-22-3456789</span>
						</p>
					</div>
				<div class="account_desc"></div>
				<div class="clear"></div>
			</div>
			<div class="header_top">
				<div class="logo">
					<a href="index-2.html">
						<img src="images/logo.png" alt="" />
					</a>
				</div>
				<div class="cart">
					<p>Welcome to our Online Store! 
						<span>Cart:</span>
						<div id="dd" class="wrapper-dropdown-2"> 0 item(s) - $0.00
			  	   
			  	   	
							<os:userprofileimage></os:userprofileimage>
						</div>
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<div style='margin: 0 auto;text-align: center;margin-top: 5px;'></div>
			<div class="header_bottom">
				<div class="menu">
					<ul>
						<li class="active">
							<a href="index.jsp">Home</a>
						</li>
						<li>
							<a href="#">Contact</a>
						</li>
						<li>
							<a href="#">My Account</a>
						</li><% 		
		  boolean loggedIn = false ;
          String isLoggedIn = "" ;
          if(session.getAttribute("uid") != null){
        	  isLoggedIn = "loggedIn" ;
        	  loggedIn = true ;
          }
		   %>
						<li class="<%=isLoggedIn%>">
							<a onclick="registerForm()" href="#">Register</a>
						</li>
						<li class="<%=isLoggedIn%>">
							<a onclick="loginForm()" href="#">Login</a>
						</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="search_box">
					<form>
						<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
							<input type="submit" value="">
							</form>
						</div>
						<div class="clear"></div>
					</div>
					<div id ="headerslider" class="header_slide">
						<div class="header_bottom_left">
							<div class="categories">
								<h3>Categories</h3>
								<ul id="categories">
								
								<%
								if(loggedIn) {
								UserDTO userDTO = (UserDTO)session.getAttribute("userdata") ;
								%>
								<os:sidemenu userDTO="<%=userDTO%>"></os:sidemenu>
								<%
								} 
								%>
								
								</ul>
							</div>
						</div>
						<div class="header_bottom_right">
							<div class="content_top">
								<div class="heading">
									<h3 id="heading">New Products</h3>
								</div>
								<div class="see">
									<p>
										<a href="#">See all Products</a>
									</p>
								</div>
								<div class="clear"></div>
							</div>
							<div  id="jsonData" class="section group">
								<div class="grid_1_of_4 images_1_of_4">
			
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="main">
					<div style='margin: 0 auto;text-align: center;margin-top: 5px;'></div>
					<div class="content" id="maindiv">
						<div class="content_bottom">
							<div style="margin: 0 auto;text-align: center;margin-top: 5px;"></div>
							<div class="heading">
								<h3>Feature Products</h3>
							</div>
							<div class="see">
								<p>
									<a href="#">See all Products</a>
								</p>
							</div>
							<div class="clear"></div>
						</div>
						<div class="section group">
							<div class="grid_1_of_4 images_1_of_4">
								<a href="preview.html">
									<img src="images/new-pic1.jpg" alt="">
									</a>
									<h2>Lorem Ipsum is simply </h2>
									<div class="price-details">
										<div class="price-number">
											<p>
												<span class="rupees">$849.99</span>
											</p>
										</div>
										<div class="add-cart">
											<h4>
												<a href="preview.html">Add to Cart</a>
											</h4>
										</div>
										<div class="clear"></div>
									</div>
								</div>
								<div class="grid_1_of_4 images_1_of_4">
									<a href="preview.html">
										<img src="images/new-pic2.jpg" alt="">
										</a>
										<h2>Lorem Ipsum is simply </h2>
										<div class="price-details">
											<div class="price-number">
												<p>
													<span class="rupees">$599.99</span>
												</p>
											</div>
											<div class="add-cart">
												<h4>
													<a href="preview.html">Add to Cart</a>
												</h4>
											</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="grid_1_of_4 images_1_of_4">
										<a href="preview.html">
											<img src="images/new-pic4.jpg" alt="">
											</a>
											<h2>Lorem Ipsum is simply </h2>
											<div class="price-details">
												<div class="price-number">
													<p>
														<span class="rupees">$799.99</span>
													</p>
												</div>
												<div class="add-cart">
													<h4>
														<a href="preview.html">Add to Cart</a>
													</h4>
												</div>
												<div class="clear"></div>
											</div>
										</div>
										<div class="grid_1_of_4 images_1_of_4">
											<a href="preview.html">
												<img src="images/new-pic3.jpg" alt="">
												</a>
												<h2>Lorem Ipsum is simply </h2>
												<div class="price-details">
													<div class="price-number">
														<p>
															<span class="rupees">$899.99</span>
														</p>
													</div>
													<div class="add-cart">
														<h4>
															<a href="preview.html">Add to Cart</a>
														</h4>
													</div>
													<div class="clear"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="footer">
								<div class="wrap">
									<div class="section group">
										<div class="col_1_of_4 span_1_of_4">
											<h4>Information</h4>
											<ul>
												<li>
													<a href="about.html">About Us</a>
												</li>
												<li>
													<a href="contact.html">Customer Service</a>
												</li>
												<li>
													<a href="#">Advanced Search</a>
												</li>
												<li>
													<a href="delivery.html">Orders and Returns</a>
												</li>
												<li>
													<a href="contact.html">Contact Us</a>
												</li>
											</ul>
										</div>
										<div class="col_1_of_4 span_1_of_4">
											<h4>Why buy from us</h4>
											<ul>
												<li>
													<a href="about.html">About Us</a>
												</li>
												<li>
													<a href="contact.html">Customer Service</a>
												</li>
												<li>
													<a href="#">Privacy Policy</a>
												</li>
												<li>
													<a href="contact.html">Site Map</a>
												</li>
												<li>
													<a href="#">Search Terms</a>
												</li>
											</ul>
										</div>
										<div class="col_1_of_4 span_1_of_4">
											<h4>My account</h4>
											<ul>
												<li>
													<a href="contact.html">Sign In</a>
												</li>
												<li>
													<a href="index-2.html">View Cart</a>
												</li>
												<li>
													<a href="#">My Wishlist</a>
												</li>
												<li>
													<a href="#">Track My Order</a>
												</li>
												<li>
													<a href="contact.html">Help</a>
												</li>
											</ul>
										</div>
										<div class="col_1_of_4 span_1_of_4">
											<h4>Contact</h4>
											<ul>
												<li>
													<span>+91-123-456789</span>
												</li>
												<li>
													<span>+00-123-000000</span>
												</li>
											</ul>
											<div class="social-icons">
												<h4>Follow Us</h4>
												<ul>
													<li>
														<a href="#" target="_blank">
															<img src="images/facebook.png" alt="" />
														</a>
													</li>
													<li>
														<a href="#" target="_blank">
															<img src="images/twitter.png" alt="" />
														</a>
													</li>
													<li>
														<a href="#" target="_blank">
															<img src="images/skype.png" alt="" />
														</a>
													</li>
													<li>
														<a href="#" target="_blank">
															<img src="images/dribbble.png" alt="" />
														</a>
													</li>
													<li>
														<a href="#" target="_blank">
															<img src="images/linkedin.png" alt="" />
														</a>
													</li>
													<div class="clear"></div>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="copy_right">
									<p>&copy; 2013 online shop. All rights reserved | Design by 
										<a href="#">Lokesh Kumar</a>
									</p>
								</div>
							</div>
							<a href="#" id="toTop">
								<span id="toTopHover"></span>
							</a>
						</body>
					</html>
