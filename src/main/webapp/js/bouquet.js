$(function() {
	getBouquet();
	getSaison();
	getStyle();
	$("#bEnvoyer").click(envoyer);
	$("#bEnvoyer").show();
	$("#bmodif").hide();
	$("#bmodif").click(envoyerModif);
});

function getBouquet() {
	$.get("http://localhost:8080/56-projetfleur/rs/bouquet", afficherBouquet);
}

function afficherBouquet(bouquet){
	html = "";
	bouquet.forEach(function(b) {
		html += "<tr>";
		html += "<td>" + b.id + "</td>";
		html += "<td>" + b.name + "</td>";
		html += "<td>" + b.price + "</td>";
		html += "<td>" + b.quantity + "</td>";
		html += "<td>" + b.season.name + "</td>";
		html += "<td>" + b.style.name + "</td>";
		html += "<td class='centre'><button onclick='modifBouquet(" + b.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppBouquet(" + b.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
		html += "</tr>";
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
		},
		style: {
			id: $("#style").val()
		}
	}
	
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/56-projetfleur/rs/bouquet/',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "bouquet.html";
		}
	})
	.fail(function() {
		$("#errorBouquet").css("display", "block");
		$("#errorBouquet").html("Une erreur est survenue lors de l'ajout");
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
		},
		style: {
			id: $("#style").val()
		}
	}
	
	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/56-projetfleur/rs/bouquet/' + $('#id').val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "bouquet.html";
		}
	})
	.fail(function() {
		$("#errorBouquet").css("display", "block");
		$("#errorBouquet").html("Une erreur est survenue lors de la modification");
	})
}

function modifBouquet(id){
	$("#bEnvoyer").hide();
	$("#bmodif").show();
	console.log("test");
	
	$.get("http://localhost:8080/56-projetfleur/rs/bouquet/"+ id , modifForm)
}

function modifForm(bouquet) {
	$("#id").val(bouquet.id);
	
	$("#name").val(bouquet.name);	
	$("#name").attr('placeholder', bouquet.name);
	
	$("#price").val(bouquet.price);	
	$("#price").attr('placeholder', bouquet.price);
	
	$("#quantity").val(bouquet.quantity);	
	$("#quantity").attr('placeholder', bouquet.quantity);
	
	$("#img").val(bouquet.img);	
	$("#img").attr('placeholder', bouquet.img);
	
	$("#info").val(bouquet.info);	
	$("#info").attr('placeholder', bouquet.info);
	
	$("#color").val(bouquet.color);	
	$("#color").attr('placeholder', bouquet.color);
	
	$("#saison").val(bouquet.season.id);
	
	$("#saison").val(bouquet.style.id);
}


function suppBouquet(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/56-projetfleur/rs/bouquet/' + id,
		success : function(){
			getBouquet();
		}
	})
	.fail(function(){
		$("#errorBouquet").css("display", "block");
		$("#errorBouquet").html("Une erreur est survenue lors de la suppression");
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

function getStyle() {

	$.get("http://localhost:8080/56-projetfleur/rs/style/", function(style){

		var data = "";
		style.forEach(function(s){
			data += "<option value="+s.id +">" + s.name + "</option>";
		});
		
		$("#style").html(data);
		});
}

