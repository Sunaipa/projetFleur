$(function() {
	$("#pEnvoyer").click(addPanier)
});

function addPanier(){
	
	var data = {
		produit : {
			id: $('#idUnite').val()
		},
		quantity: $('#quantityChoice').val()
	}
	
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/56-projetfleur/rs/panier/',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			getNombreArticles();
		}
	})
	.fail(function() {
		$("#errorPlante").css("display", "block");
		$("#errorPlante").html("Une erreur est survenue lors de l'ajout");
	})
}