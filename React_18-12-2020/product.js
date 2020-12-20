var btn = document.getElementById("log");

btn.addEventListener("click", () => {
    var ref = "https://fakestoreapi.com/products/ ";
	handleAjax(ref,  "GET", "Products", "products",getProducts);
})

function handleAjax(url,  method, title, elem, callback){
    var http = new XMLHttpRequest();
    http.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          callback(this.responseText, title, elem);
        }
    };
    http.open(method, url );
    http.send()
}

function getProducts(inp, title, elem){
    var newElem = document.getElementById(elem);
	var output = "<h1 class='Title'>"+ title +"<h1>";

    var newObj = JSON.parse(inp)

	for(product of newObj){
		
		output += "<div class='newproduct'>" +
						"<img class='image' src='"+product.image+"'>"+
						"<h4 class='title'>"+product.title+"</h4>"+
						"<div class='category'>"+product.category+"</div>"+
						"<div class='price'>"+product.price+" Rs </div>" +
			      "</div>";
	}
	output += "<div class='clear'></div>"

	newElem.innerHTML = output;
}
