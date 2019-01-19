<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<script src="js/cache.js"></script>

	<div class="main main-agileits" id = "jsonData">		
		<div class="">
			<div class="signup-wthreetop">
				<h2>Add Products </h2>
				<p>Fill Details of the product </p>
			</div>
			<div class="contact-wthree" >
			
				<form action="product" method="post" enctype="multipart/form-data">
					<h3>Step 1 :</h3>
					<div class="form-w3step1">
						<input type="text" name="pname" placeholder="Product Name" required>
						<input type="text" class="name" name="pid" placeholder="Product ID" required>
						<input type="text" name="pdescr" placeholder="Product Description" required>
					</div>
					<h3>Step 2 :</h3>
					<div class="form-w3step1">
						<input type="text" name="pquantity" placeholder="Product quantity" required>
						
						Choose Category : <select name="pcategory" id="pcategory">
						<option value="M" >MOBILE PHONES</option>
						<option value="A" >ACCESSORIES</option>
						<option value="SF" >SPORTS And FITNESS</option>
						<option value="F" >FOOTWEAR</option>
						<option value="C" >CLOTHING</option>
						<option value="BH" >BEAUTY and HEALTHCARE</option>
						<option value="K" >KITCHEN</option>
						<option value="J" >JEWELLERY</option>
						<option value="T" >TOYS, KIDS and BABIES</option>
						</select>
						
					</div>
					<h3>Step 3 :</h3>
					<div class="form-w3step1 w3ls-formrow">
						<input type="text" name="pprice" placeholder="Product Price" required>
						Product Image : <input type="file" class="" placeholder="Product Image" name="pimage">
					</div>
					
					<input type="submit" onclick="callProductServlet()" value="SUBMIT">
				</form>
			</div>
		</div>
	</div>





