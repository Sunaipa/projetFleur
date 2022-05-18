$(function() {
	getFleur();
	getSaison();
	$("#unite").hide();
});

function getFleur() {
	$.get("http://localhost:8080/56-projetfleur/rs/fleur", afficherFleur);
}

function afficherFleur(fleur){
	html = "";
	fleur.forEach(function(f) {
		html += "<tr>";
		html += "<td>" + f.id + "</td>";
		html += "<td><button onclick='detailFleur(" + f.id + ")' type='text' class=' btn btn-link'> " + f.name + "</button></td>";
		html += "<td>" + f.price + "</td>";
		html += "<td>" + f.quantity + "</td>";
		html += "<td>" + f.season.name + "</td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
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


function detailFleur(id){
	$.get("http://localhost:8080/56-projetfleur/rs/fleur/" + id, function(f){
		
		$("#tableList").hide();
		
		$("#nameUnit").html(f.name);
		$("#idUnite").val(id);
		$("#info").html(f.info);
		$("#tarif").html(f.price);
		$("#couleur").html(f.color);
		$("#saison").html(f.season.name);
		$("#imgUnite").attr('src', f.img);
		
		$("#unite").show();
		});
}

function retourList(){
	$("#unite").hide();
	$("#tableList").show();
}

