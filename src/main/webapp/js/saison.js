$(function() {
	getSaisons();
	$("#bEnvoyer").click(envoyer);
	$("#bEnvoyer").show();
	$("#bmodif").hide();
	$("#bmodif").click(envoyerModif);
});

function getSaisons() {
	$.get("http://localhost:8080/56-projetfleur/rs/saison", afficherSaisons);
}

function afficherSaisons(saison){
	html = "";
	saison.forEach(function(s) {
		html += "<tr>";
		html += "<td>" + s.id + "</td>";
		html += "<td>" + s.name + "</td>";
		html += "<td class='centre'><button onclick='modifSaison(" + s.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppSaison(" + s.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
}

function envoyer(){	
	var data = {
		name : $('#name').val()
	}
	
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/56-projetfleur/rs/saison/',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "saison.html";
		}
	})
	.fail(function() {
		$("#errorSaison").css("display", "block");
		$("#errorSaison").html("Une erreur est survenue lors de l'ajout");
	})
	
}

function envoyerModif(){
	var data = {
		name : $('#name').val()
	}
	
	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/56-projetfleur/rs/saison/' + $('#id').val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "saison.html";
		}
	})
	.fail(function() {
		$("#errorSaison").css("display", "block");
		$("#errorSaison").html("Une erreur est survenue lors de la modification");
	})
}

function modifSaison(id){
	$("#bEnvoyer").hide();
	$("#bmodif").show();
	console.log("test");
	
	$.get("http://localhost:8080/56-projetfleur/rs/saison/"+ id , modifForm)
}

function modifForm(saison) {
	console.log(saison.name);
	$("#id").val(saison.id);
	$("#name").val(saison.name);	
	$("#name").attr('placeholder', saison.name);
}


function suppSaison(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/56-projetfleur/rs/saison/' + id,
		success : function(){
			getSaisons();
		}
	})
	.fail(function(){
		$("#errorSaison").css("display", "block");
		$("#errorSaison").html("Une erreur est survenue lors de la suppression");
	})
}
