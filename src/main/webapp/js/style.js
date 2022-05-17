$(function() {
	getSaisons();
	$("#bEnvoyer").click(envoyer);
	$("#bEnvoyer").show();
	$("#bmodif").hide();
	$("#bmodif").click(envoyerModif);
});

function getSaisons() {
	$.get("http://localhost:8080/56-projetfleur/rs/style", afficherStyle);
}

function afficherStyle(style){
	html = "";
	style.forEach(function(s) {
		html += "<tr>";
		html += "<td>" + s.id + "</td>";
		html += "<td>" + s.name + "</td>";
		html += "<td class='centre'><button onclick='modifStyle(" + s.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppStyle(" + s.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
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
		url: 'http://localhost:8080/56-projetfleur/rs/style/',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "style.html";
		}
	})
	.fail(function() {
		$("#errorStyle").css("display", "block");
		$("#errorStyle").html("Une erreur est survenue lors de l'ajout");
	})
	
}

function envoyerModif(){
	var data = {
		name : $('#name').val()
	}
	
	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/56-projetfleur/rs/style/' + $('#id').val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "style.html";
		}
	})
	.fail(function() {
		$("#errorStyle").css("display", "block");
		$("#errorStyle").html("Une erreur est survenue lors de la modification");
	})
}

function modifStyle(id){
	$("#bEnvoyer").hide();
	$("#bmodif").show();
	console.log("test");
	
	$.get("http://localhost:8080/56-projetfleur/rs/style/"+ id , modifForm)
}

function modifForm(style) {
	console.log(style.name);
	$("#id").val(style.id);
	$("#name").val(style.name);	
	$("#name").attr('placeholder', style.name);
}


function suppStyle(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/56-projetfleur/rs/style/' + id,
		success : function(){
			getSaisons();
		}
	})
	.fail(function(){
		$("#errorStyle").css("display", "block");
		$("#errorStyle").html("Une erreur est survenue lors de la suppression");
	})
}
