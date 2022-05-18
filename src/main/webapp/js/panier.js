$(function() {
	getArticles();
});

function getArticles() {
	$.get("http://localhost:8080/56-projetfleur/rs/panier", afficherPanier);
}


function afficherPanier(p) {
	html = "";
	total = 0.0;
	
	for(var i = 0; i < p.length; i++){
		console.log(p[i]);
		html += "<tr>";
		html += "<td>" + p[i].produit.name + "</td>";
		html += "<td>" + p[i].produit.price + "</td>";
		html += "<td>" + p[i].quantity + "</td>";
		html += "</tr>";
		total += (p[i].produit.price * p[i].quantity);
	}
	$("#totalPrice").html(total)
	$("#tbodyliste").html(html);
}



