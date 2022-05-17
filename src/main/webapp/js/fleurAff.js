$(function() {
	getFleur();
	getSaison();
});

function getFleur() {
	$.get("http://localhost:8080/56-projetfleur/rs/fleur", afficherFleur);
}

function afficherFleur(fleur){
	html = "";
	fleur.forEach(function(f) {
		html += "<tr>";
		html += "<td>" + f.id + "</td>";
		html += "<td>" + f.name + "</td>";
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

