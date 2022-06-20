$(document).ready(function($) {
	$('#popLogin').modal({
	  show: false
	});
	$('#myloginForm').dblclick(function () {
	  $('#popLogin').modal('toggle');
	});
	
	//myLogin();
	
	//insert();
 	//updatePrepare(id)
});

function myLogin(){
	var username = $('#username').val();  
	var password = $('#password').val();  
 	if(!contol(username, password)){
		alert("Tutti i campi sono obbligatori!!!");
		return false;
	}
	
}


function contol(user, password){
	if(user != "" && password != ""){
		return true;
	}
	return false;
}
