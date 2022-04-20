$(document).ready(function() {
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
	/* alert(" myLogin !!!");
	var data = {"username":username, "password":password};
	var jsonData = jQuery.parseJSON(data); //Array 
	alert(" User: "+username+" -- Password: "+password);*/
 	if(!contol(username, password)){
		alert("Tutti i campi sono obbligatori!!!");
		return false;
	}
	/*if(contol(username, password)){ 		
		$.ajax({
		    url  : "/MicheleProject/login",
			contentType: "application/json",
		    type : "POST",
		    data : jsonData,
	        cache: false,
	        timeout: 60000,
		    complete : function(data) {
				console.log(data.responseText);
		       
		        if(data.status==200){
		        	setTimeout(function(){  // wait for 5 secs(2)
				         location.reload(); // then reload the page.(3)
				    }, 1000); 
		            alert("Login !!!");
		            
		        }else{
		        	//window.open("index.jsp","_self");
		            alert("Username o password sbagliato !!!");
		        }
		    }
		});
	}else{*/
	
	
}

/*
function insertPremiazioe(){
	var titolo = $('#titoloPremiazioe').val();  
	var citta = $('#cittaPremiazioe').val();  
	var descrizione = $('#descrizionePremiazioe').val();  
	var anno = $('#annoPremiazioe').val();  
	var jsonData = {titolo : titolo, descrizione : descrizione, citta:citta, data : anno}; //Array 
 	
 	//alert("Titolo: "+titolo +" Descrizione: "+descrizione+" Anno: "+anno);
 	var contvalue = contol(titolo, descrizione, citta, anno)
 	if(contvalue == true){
		$.ajax({
		    url : "http://localhost:8080/MicheleProject/biografia/insert",
		    type : "POST",
		    data : jsonData,
		    complete : function(data) {
				console.log(data.responseText);
		        //$('#result').append(data.responseText);
		        //alert("RESPOSE: "+ data.responseText);
		        if(data){
		        	setTimeout(function(){// wait for 5 secs(2)
				         location.reload(); // then reload the page.(3)
				    }, 1000); 
		            alert("La premiazioe è stato inserito ");
		        }else{
		        	//window.open("index.jsp","_self");
		            alert("La premiazioe not è stato inserito");
		        }
		    }
		    
		});
	}else{
		alert("Tutti i campi sono obbligatori!!!");
	}
	
}


function updatePrepare(id){
	
	var jsonData = {id:id}; //Array 
 	
	$.ajax({
	    url  : "http://localhost:8080/MicheleProject/biografia/openUpdate/"+id,
	    type : "GET",
	    data : jsonData,
		success : function(premiazioneUpdate) {
            //alert('SUCCESS:   '+poesiaUpdate);
            console.log(premiazioneUpdate);
            //console.log(data.success);
            $('#popUpdatePremiazioe').empty();
            $('#popUpdatePremiazioe').append(premiazioneUpdate);
        }
	});
}

function update(id){
	var titolo = $('#titoloPremiazioeUp').val();  
	var citta = $('#cittaPremiazioeUp').val();  
	var descrizione = $('#descrizionePremiazioeUp').val();  
	var anno = $('#annoPremiazioeUp').val();  
	var jsonData = {id:id, titolo : titolo, descrizione : descrizione, citta:citta, data : anno}; //Array 
	
 	if(contol(titolo, descrizione, citta, anno)){
 		
		$.ajax({
		    url  : "http://localhost:8080/MicheleProject/biografia/update",
		    type : "POST",
		    data : jsonData,
		    complete : function(data) {
				console.log(data.responseText);
		        //$('#result').append(data.responseText);
		        //alert("RESPOSE: "+ data.responseText);
		        if(data){
		        	setTimeout(function(){// wait for 5 secs(2)
				         location.reload(); // then reload the page.(3)
				    }, 1000); 
		            alert("Modificto !!!");
		            
		        }else{
		        	//window.open("index.jsp","_self");
		            alert("Not modificto !!!");
		        }
		    }
		    
		});
	}else{
		alert("Tutti i campi sono obbligatori!!!");
	}
	
}

function deletePremiazione(id, titolo){
	var result = window.confirm('Sei sicuro di volere eliminare la poesia: '+titolo);
	 
    if (result == true) {
        var jsonData = {id:id}; //Array
		$.ajax({
		    url  : "http://localhost:8080/MicheleProject/biografia/delete/"+id,
		    type : "GET",
		    data : jsonData,
			complete : function(data) {
	            //alert('SUCCESS:   '+raccontiUpdate);
		         if(data){   
		            setTimeout(function(){// wait for 5 secs(2)
				         location.reload(); // then reload the page.(3)
				    }, 1000); 
		            alert("Eliminato !!!");
		        }else{
		        	//window.open("index.jsp","_self");
		            alert("Not eliminato !!!");
		        }
		        
		    }
		});
    }

}
*/
function contol(user, password){
	if(user != "" && password != ""){
		return true;
	}
	return false;
}
