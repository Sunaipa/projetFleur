$(function() {
	includeNavBar();
	includeFooter();
	getNombreArticles();
});


function includeNavBar(){
	var id = $(".include-Nav").attr("name");
	id = "#" + id;
	$(".include-Nav").load("./include/navBar.html", function(){
		setActive(id);
	});
	
}
function setActive(id){
	$(id).attr("class", "active");
}

function includeFooter(){
	$(".include-Footer").load("./include/footer.html")
}


function getNombreArticles() {
	$.get("http://localhost:8080/56-projetfleur/rs/panier/nb", afficherNombrePanier);
}
function afficherNombrePanier(nb){
	$("#nombreItem").html(nb);
}