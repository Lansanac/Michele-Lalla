$(document).ready(function() {

	//insert();
 	//updatePrepare(id)
});

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
		        if(data.status==200){
		        	setTimeout(function(){// wait for 5 secs(2)
				         location.reload(); // then reload the page.(3)
				    }, 1000); 
		            alert("La premiazione è stato inserito ");
		        }else{
		        	//window.open("index.jsp","_self");
		            alert("La premiazione not è stato inserito");
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
	    url  : "openUpdate/"+id,
	    type : "GET",
	    data : jsonData,
		success : function(premiazioneUpdate) {
            //alert('SUCCESS:   '+premiazioneUpdate);
            //console.log(premiazioneUpdate);
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
		    success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
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
			success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		});
    }

}

function insertOpera(){
	var descrizione = $('#descrizioneOpera').val();  
	var anno = $('#annoOpera').val();  
	var jsonData = { data : anno, descrizione : descrizione}; //Array 
	 //alert(" Descrizione: "+descrizione+" Anno: "+anno);

 	var contvalue = contolOpera(anno, descrizione);
 	if(contvalue == true){
		$.ajax({
		    url : "http://localhost:8080/MicheleProject/biografia/opera/insert",
		    type : "POST",
		    data : jsonData,
		    success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		    
		});
	}else{
		alert("Tutti i campi sono obbligatori!!!");
	}
	
}

function updatePrepareOpera(id){
	
	var jsonData = {id:id}; //Array 
 	
	$.ajax({
	    url  : "opera/openUpdate/"+id,
	    type : "GET",
	    data : jsonData,
		success : function(operaUpdate) {
            //alert('SUCCESS:   '+operaUpdate);
            console.log(operaUpdate);
            //console.log(operaUpdate.success);
            $('#popUpdateOpera').empty();
            $('#popUpdateOpera').append(operaUpdate);
        }
	});
}

function updateOpera(id){
	var descrizione = $('#descrizioneOpereUp').val();  
	var anno = $('#annoOpereUp').val();  
	var jsonData = {id:id, data : anno, descrizione : descrizione}; //Array 
	
 	if(contolOpera(anno, descrizione)){
 		
		$.ajax({
		    url  : "http://localhost:8080/MicheleProject/biografia/opera/update",
		    type : "POST",
		    data : jsonData,
		    success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		    
		});
	}else{
		alert("Tutti i campi sono obbligatori!!!");
	}
	
}

function deleteOpera(id, titolo){
	var result = window.confirm('Sei sicuro di volere eliminare la poesia: '+titolo);
	 
    if (result == true) {
    	//alert("Tutti !!!  "+result);
        var jsonData = {id:id}; //Array
		$.ajax({
		    url  : "http://localhost:8080/MicheleProject/biografia/opera/delete/"+id,
		    type : "GET",
		    data : jsonData,
			success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		});
    }
}

function contol(titolo, descrizione, citta, anno){
	if(titolo != "" && descrizione != "" && citta!="" && anno != ""){
		return true;
	}
	return false;
}
function contolOpera(data, descrizione){
	if(data != "" && descrizione != ""){
		return true;
	}
	return false;
}

function refresh(){
	setTimeout(function(){// wait for 5 secs(2)
         location.reload(); // then reload the page.(3)
    }, 1000);
}
