$(function() {
	getFleur();
	getSaison();
	$("#bEnvoyer").click(envoyer);
	$("#bEnvoyer").show();
	$("#bmodif").hide();
	$("#bmodif").click(envoyerModif);
});

function getFleur() {
	$.get("http://localhost:8080/56-projetfleur/rs/fleur", afficherFleur);
}

function afficherFleur(fleur){
	html = "";
	fleur.forEach(function(f) {
		
		if(f.style != 'undefined'){
			html += "<tr>";
			html += "<td>" + f.id + "</td>";
			html += "<td>" + f.name + "</td>";
			html += "<td>" + f.price + "</td>";
			html += "<td>" + f.quantity + "</td>";
			html += "<td>" + f.season.name + "</td>";
			html += "<td class='centre'><button onclick='modifFleur(" + f.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
			html += "<td class='centre'><button onclick='suppFleur(" + f.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
			html += "</tr>";
		}
	})
	$("#tbodyliste").html(html);
}

function envoyer(){
	var data = {
		name : $('#name').val(),
		price:  $('#price').val(),
		quantity:  $('#quantity').val(),
		img: $('#img').val(),
		info: $('#info').val(),
		color: $('#color').val(),
		season :{
			id: $("#saison").val()
		}
	}
	
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/56-projetfleur/rs/fleur/',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "fleur.html";
		}
	})
	.fail(function() {
		$("#errorFleur").css("display", "block");
		$("#errorFleur").html("Une erreur est survenue lors de l'ajout");
	})
}

function envoyerModif(){
	var data = {
		name : $('#name').val(),
		price:  $('#price').val(),
		quantity:  $('#quantity').val(),
		img: $('#img').val(),
		info: $('#info').val(),
		color: $('#color').val(),
		season :{
			id: $("#saison").val()
		}
	}
	
	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/56-projetfleur/rs/fleur/' + $('#id').val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "fleur.html";
		}
	})
	.fail(function() {
		$("#errorFleur").css("display", "block");
		$("#errorFleur").html("Une erreur est survenue lors de la modification");
	})
}

function modifFleur(id){
	$("#bEnvoyer").hide();
	$("#bmodif").show();
	console.log("test");
	
	$.get("http://localhost:8080/56-projetfleur/rs/fleur/"+ id , modifForm)
}

function modifForm(fleur) {
	$("#id").val(fleur.id);
	
	$("#name").val(fleur.name);	
	$("#name").attr('placeholder', fleur.name);
	
	$("#price").val(fleur.price);	
	$("#price").attr('placeholder', fleur.price);
	
	$("#quantity").val(fleur.quantity);	
	$("#quantity").attr('placeholder', fleur.quantity);
	
	$("#img").val(fleur.img);	
	$("#img").attr('placeholder', fleur.img);
	
	$("#info").val(fleur.info);	
	$("#info").attr('placeholder', fleur.info);
	
	$("#color").val(fleur.color);	
	$("#color").attr('placeholder', fleur.color);
	
	$("#saison").val(fleur.season.id);
}

function suppFleur(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/56-projetfleur/rs/fleur/' + id,
		success : function(){
			getFleur();
		}
	})
	.fail(function(){
		$("#errorFleur").css("display", "block");
		$("#errorFleur").html("Une erreur est survenue lors de la suppression");
	})
}

function getSaison() {

	$.get("http://localhost:8080/56-projetfleur/rs/saison/", function(saison){
		var data = "";
		saison.forEach(function(s){
			data += "<option value="+s.id +">" + s.name + "</option>";
		});
		
		$("#saison").html(data);
		});
}
