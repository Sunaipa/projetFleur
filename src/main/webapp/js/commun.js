$(function() {
	getNombreArticles();
});

function getNombreArticles() {
	$.get("http://localhost:8080/56-projetfleur/rs/panier/nb", afficherNombrePanier);
}

function afficherNombrePanier(nb){
	$("#nombreItem").html(nb);
}