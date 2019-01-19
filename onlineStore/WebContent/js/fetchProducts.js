window.addEventListener("load",doAjaximages);



function doAjaximages(){
    var serverUrl = "http://localhost:8080/onlineStore/cache";
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
    console.log("Data is ",data.product.length);
    var temp = data.product;
    var div = document.querySelector("#jsonData");

    div.innerHTML = "";

    temp.forEach((itemObject)=>{
    var para = document.createElement("a");
   
        para.innerHTML = `<img class='size' src='/onlineStore/productImages/${itemObject.pimage}'> ${itemObject.pid} ${itemObject.pname} ${itemObject.pprice}`;
           var button = document.createElement("button");
           button.innerHTML = "Add to Cart";
           button.setAttribute("itemid",itemObject.pname);
           button.addEventListener("click",addToCart);

         div.appendChild(para);
         div.appendChild(button);
    });

}

function addToCart(){
    console.log('addeed to cart');
}

