$(function() {
	getBouquet();
	getSaison();
	getStyle();
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

function getStyle() {

	$.get("http://localhost:8080/56-projetfleur/rs/style/", function(style){
		var data = "";
		style.forEach(function(s){
			data += "<option value="+s.id +">" + s.name + "</option>";
		});
		$("#style").html(data);
		});
}

