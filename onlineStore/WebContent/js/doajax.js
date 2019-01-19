window.addEventListener("load",doAjax);

function sideMenu(url,uri){
	console.log("url is ",url);
	console.log("uri is ",uri);

	console.log("url+uri is ",url+uri);
	
	
	fetch(url+uri).then(response=>{
		
		response.text().then(data=>{
		
				console.log("Data is ",data);
				
				document.querySelector(".header_bottom_right").innerHTML = data ;
				
			}).catch(e=>{
				console.log("error is ",e);
			})
	}).catch(err=>{
		alert("Can't Access the Page....");
	})
}

function doAjax(){
    var serverUrl = "http://localhost:8080/onlineStore/products";
    fetch(serverUrl).then(done).catch(fail);
}

function done(response){
    response.json().then(printData);
}

function fail(error){
    console.log("Error is ",error);
}

function printData(data){
	
	console.log("data is ",data);
    var temp = data.product;
    var div = document.querySelector("#jsonData");

    div.innerHTML = "";

    var heading = document.getElementById("heading");
    
    temp.forEach((itemObject)=>{
    	
    var a_image = document.createElement("a");
    var product_div = document.createElement("div");
    var h2 = document.createElement("h2");
    var addCartDiv = document.createElement("div");
    var p = document.createElement("p");    
    var a2 = document.createElement("a");
    var h3 = document.createElement("h4");
    var a_addToCart = document.createElement("a");
    
    	   a_image.innerHTML = `<img class='' src='/onlineStore/productImages/${itemObject.pimage}'>  `;
           
    	   h2.innerHTML = `${itemObject.pname}`+" ( "+`${itemObject.pquantity}`+" ) " ;
           
           var button = document.createElement("button");
          
           $(product_div).addClass('grid_1_of_4 images_1_of_4');
           
           $(p).addClass('price-number');
           
           $(addCartDiv).addClass('add-cart');
           
           h3.append(a_addToCart);
           
           a_addToCart.setAttribute("pid",itemObject.pid);
           
           
           a_addToCart.addEventListener("click",addToCart);
           
           a_addToCart.innerHTML = `ADD TO CART`;
           
           addCartDiv.append(h3);
           
           p.innerHTML = `<span class="rupees">`+"$"+`${itemObject.pprice}</span>`;
           
           div.appendChild(product_div);
           product_div.appendChild(a_image);
           product_div.appendChild(h2);
           product_div.appendChild(addCartDiv);
           product_div.appendChild(p);
           
    });
    function addToCart(){
    	/*console.log("pid is ",this.getAttribute("pid")) ;*/
    	var pid = this.getAttribute("pid") ;
    	cartInfo(pid);
    }
    function cartInfo(pid){
    	/*console.log("temp is ",temp);*/

    	var div = document.querySelector("#jsonData");
        div.innerHTML = "";

    	temp.forEach((product)=>{
    		/*console.log("pname is ",product.pname);*/
    		
    		if(product.pid == pid){
    			if(product.pid == pid){
//               		console.log("pid is ",product.pid) ;
//               		console.log("pid clicked  is ",pid) ;
           			
               		var title = document.createElement("h2");
               		$(title).addClass('productTitle');
               		title.innerHTML = `${product.pname}`;
               		var imageDiv = document.createElement("div");
               		var productDescr = document.createElement("p");
               		imageDiv.innerHTML = `<img class='' src='/onlineStore/productImages/${product.pimage}'>  `;
               		productDescr.innerHTML = `${product.pdescr}`; 
               		div.append(title);
               		div.append(imageDiv);
               		div.append(productDescr);
               		
               		var addToCartbtn = document.createElement("button");
               		addToCartbtn.innerText = "Add To Cart" ;
               		$(addToCartbtn).addClass('add');
               		div.append(addToCartbtn);
               		
               		addToCartbtn.addEventListener(onclick,addItToCart(pid)) ;
           		}
    		}
     	});
    }
}

function addItToCart(pid){
	console.log("pid is ",pid);
}

function printabc(cname){
	/*console.log("cname is ",cname);*/
    var serverUrl = "http://localhost:8080/onlineStore/products";
    fetch(serverUrl).then(success).catch(prblm);
	
    function success(response){
        response.json().then(doMagic);
    }

    function prblm(error){
        console.log("Error is ",error);
    }

    function doMagic(data){
    	
        var products = data.product;
        var div = document.querySelector("#jsonData");
        div.innerHTML = " ";
    	console.log("doMagic data is ",data);
	    
        	products.forEach((product)=>{
        		if(cname === product.pcategory){
	            	console.log("doMagic cname is ",cname);
	            	console.log("doMagic product.category name is ",product.pcategory);

	            	
	                var div = document.querySelector("#jsonData");
	                
	                
	                var a_image = document.createElement("a");
	                var product_div = document.createElement("div");
	                var h2 = document.createElement("h2");
	                var addCartDiv = document.createElement("div");
	                var p = document.createElement("p");    
	                var a2 = document.createElement("a");
	                var h3 = document.createElement("h4");
	                var a_addToCart = document.createElement("a");
	                
	                	   a_image.innerHTML = `<img class='' src='/onlineStore/productImages/${product.pimage}'>  `;
	                       
	                	   h2.innerHTML = `${product.pname}`+" ( "+`${product.pquantity}`+" ) " ;
	                       
	                       var button = document.createElement("button");
	                      
	                       $(product_div).addClass('grid_1_of_4 images_1_of_4');
	                       
	                       $(p).addClass('price-number');
	                       
	                       $(addCartDiv).addClass('add-cart');
	                       
	                       h3.append(a_addToCart);
	                       
	                       a_addToCart.setAttribute("pid",product.pid);
	                       
	                       
	                       
	                       a_addToCart.addEventListener("click",addToCart);
	                       
	                       a_addToCart.innerHTML = `ADD TO CART`;
	                       
	                       addCartDiv.append(h3);
	                       
	                       p.innerHTML = `<span class="rupees">`+"$"+`${product.pprice}</span>`;
	                       
	                       div.appendChild(product_div);
	                       product_div.appendChild(a_image);
	                       product_div.appendChild(h2);
	                       product_div.appendChild(addCartDiv);
	                       product_div.appendChild(p);
	               
	                

	                       function addToCart(){
	                       	/*console.log("pid is ",this.getAttribute("pid")) ;*/
	                       	var pid = this.getAttribute("pid") ;
	                       	cartInfo(pid);
	                       }
	                       function cartInfo(pid){
	                       	/*console.log("temp is ",temp);*/

	                       	var div = document.querySelector("#jsonData");
	                           div.innerHTML = "";
	                       
	                           $(div).addClass('productStyle');
		                       
	                           products.forEach((product)=>{
	                       		/*console.log("pname is ",product.pname);*/
	                       		
	                       		if(product.pid == pid){
//	                           		console.log("pid is ",product.pid) ;
//	                           		console.log("pid clicked  is ",pid) ;
	                       			
	                           		var title = document.createElement("h2");
	                           		$(title).addClass('productTitle');
	                           		title.innerHTML = `${product.pname}`;
	                           		var imageDiv = document.createElement("div");
	                           		var productDescr = document.createElement("p");
	                           		var addToCart = document.createElement("button");
	                           		addToCart.innerText = "Add To Cart" ;
	                           		addToCart.id = "add" ;
	                           		imageDiv.innerHTML = `<img class='' src='/onlineStore/productImages/${product.pimage}'>  `;
	                           		p.innerHTML = `${product.pdescr}`; 
	                           		div.append(title);
	                           		div.append(imageDiv);
	                           		div.append(p);
	                                
	                           		
	                           		$(addToCart).addClass('add');
	                           		div.append(addToCart);
	                       		}
	                        	});
	                       }
        		}	
	        });
        	
     }
    
}


