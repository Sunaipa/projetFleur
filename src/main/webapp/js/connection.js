$(function() {
	$("#LEnvoyer").click(envoyer);
});

function envoyer(){
	var data = {
		name : $('#login').val(),
		password: $('#password').val()
	}
	$.ajax({
		type: 'get',
		url: 'http://localhost:8080/56-projetfleur/rs/connection/' + $('#name').val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "index.html";
		}
	})
	.fail(function() {
		window.location = "connection.html";
	})
}