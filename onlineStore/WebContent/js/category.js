window.addEventListener("load",getCacheData);

function getCacheData(){
	fetch("http://localhost:8080/onlineStore/cache",
			{method:"post" ,body: {"key":"categories"}}).then(response=>{
		response.json().then(data=>{
			console.log("Data is ",data);
			printCategories(data);
			printIt(data);
		}).catch(err=>{
			console.log("Invalid json ",err);
		}).catch(err=>{
			console.log("Can't Talk to Server ",err);
		})
	});
}

function printCategories(data){
	var categories = document.querySelector("#categories");
	for(let object of data.data){
		var li = document.createElement("li");
		var a = document.createElement("a");
		
		li.append(a);
		a.innerText = object.descr;
		a.value=object.name;
		a.addEventListener("click",showCategoryProducts);
		console.log("cname",object.name);
		a.setAttribute("cname",object.name);
		categories.append(li);
	
		function showCategoryProducts(){
			var name = object.name ;
			console.log("name is ",name);
			printabc(name);
		}
	}
}

/*
function printIt(data){
	var categories = document.querySelector("#pcategories");
	for(let object of data.data){
		var option = document.createElement("option");
		option.innerText = object.descr;
		option.value=object.name;
		categories.appendChild(option);
	}
}
*/

/*function callProductServlet(){
	fetch("http://localhost:8080/onlineStore/cache",{method:"post" ,body: {}}).then(response=>{
		response.json().then(products=>{
			console.log("products are "+products);
		}).catch(err=>{
			console.log("cannot read json"+err);
		})
	}).catch(err=>{
		console.log("cannot talk to server "+err);
	})	
}*/

