$(function() {
	getPlante();
});

function getPlante() {
	$.get("http://localhost:8080/56-projetfleur/rs/plante", afficherPlante);
}

function afficherPlante(plante){
	html = "";
	plante.forEach(function(s) {
		html += "<tr>";
		html += "<td>" + s.id + "</td>";
		html += "<td>" + s.name + "</td>";
		html += "<td>" + s.price + "</td>";
		html += "<td>" + s.quantity + "</td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
}
