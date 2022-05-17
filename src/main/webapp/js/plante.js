$(function() {
	getPlante();
	$("#bEnvoyer").click(envoyer);
	$("#bEnvoyer").show();
	$("#bmodif").hide();
	$("#bmodif").click(envoyerModif);
});

function getPlante() {
	$.get("http://localhost:8080/56-projetfleur/rs/plante", afficherPlante);
}

function afficherPlante(plante){
	html = "";
	plante.forEach(function(p) {
		html += "<tr>";
		html += "<td>" + p.id + "</td>";
		html += "<td>" + p.name + "</td>";
		html += "<td>" + p.price + "</td>";
		html += "<td>" + p.quantity + "</td>";
		html += "<td class='centre'><button onclick='modifPlante(" + p.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppPlante(" + p.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
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
	}
	
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/56-projetfleur/rs/plante/',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "plante.html";
		}
	})
	.fail(function() {
		$("#errorPlante").css("display", "block");
		$("#errorPlante").html("Une erreur est survenue lors de l'ajout");
	})
	
}

function envoyerModif(){
	var data = {
		name : $('#name').val(),
		price:  $('#price').val(),
		quantity:  $('#quantity').val(),
		img: $('#img').val(),
		info: $('#info').val(),
	}
	
	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/56-projetfleur/rs/plante/' + $('#id').val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "plante.html";
		}
	})
	.fail(function() {
		$("#errorPlante").css("display", "block");
		$("#errorPlante").html("Une erreur est survenue lors de la modification");
	})
}

function modifPlante(id){
	$("#bEnvoyer").hide();
	$("#bmodif").show();
	console.log("test");
	
	$.get("http://localhost:8080/56-projetfleur/rs/plante/"+ id , modifForm)
}

function modifForm(plante) {
	$("#id").val(plante.id);
	
	$("#name").val(plante.name);	
	$("#name").attr('placeholder', plante.name);
	
	$("#price").val(plante.price);	
	$("#price").attr('placeholder', plante.price);
	
	$("#quantity").val(plante.quantity);	
	$("#quantity").attr('placeholder', plante.quantity);
	
	$("#img").val(plante.img);	
	$("#img").attr('placeholder', plante.img);
	
	$("#info").val(plante.info);	
	$("#info").attr('placeholder', plante.info);
}


function suppplante(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/56-projetfleur/rs/plante/' + id,
		success : function(){
			getPlante();
		}
	})
	.fail(function(){
		$("#errorPlante").css("display", "block");
		$("#errorPlante").html("Une erreur est survenue lors de la suppression");
	})
}
