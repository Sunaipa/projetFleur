$(function() {
	getPlante();
	$("#unite").hide();
});

function getPlante() {
	$.get("http://localhost:8080/56-projetfleur/rs/plante", afficherPlante);
}

function afficherPlante(plante){
	html = "";
	plante.forEach(function(p) {
		html += "<tr>";
		html += "<td>" + p.id + "</td>";
		html += "<td><button onclick='detailPlante(" + p.id + ")' type='text' class=' btn btn-link'> " + p.name + "</button></td>";
		html += "<td>" + p.price + "</td>";
		html += "<td>" + p.quantity + "</td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
}

function detailPlante(id){
	$.get("http://localhost:8080/56-projetfleur/rs/plante/" + id, function(p){
		
		$("#tableList").hide();
		
		$("#nameUnit").html(p.name);
		$("#idUnite").val(id);
		$("#info").html(p.info);
		$("#tarif").html(p.price);
		$("#imgUnite").attr('src', p.img);
		
		$("#unite").show();
		});
}

function retourList(){
	$("#unite").hide();
	$("#tableList").show();
}
