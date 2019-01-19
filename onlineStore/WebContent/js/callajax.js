
function loginForm(){
	fetch("http://localhost:8080/onlineStore/login.jsp").then(response=>{
			response.text().then(data=>{
				console.log("Data is ",data);
				document.querySelector("#maindiv").innerHTML = data;
				document.querySelector("#headerslider").innerHTML = " ";
				
			}).catch(e=>{
				console.log("error is ",e);
			})
	}).catch(err=>{
		alert("Can't Access the Page....");
	})
}

function registerForm(){
	fetch("http://localhost:8080/onlineStore/register.jsp").then(response=>{
			response.text().then(data=>{
				console.log("Data is ",data);
				document.querySelector("#maindiv").innerHTML = data ;
				document.querySelector("#headerslider").innerHTML = " ";
			}).catch(e=>{
				console.log("error is ",e);
			})
	}).catch(err=>{
		alert("Can't Access the Page....");
	})
}
