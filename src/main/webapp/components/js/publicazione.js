$(document).ready(function() {

	//insert();
 	//updatePrepare(id)

	//Calling function after Page Load
	
});


function insertPublicazione(){
	var titolo = $('#titoloPubb').val();  
	var descrizione = $('#descrizionePubb').val();  
	var anno = $('#annoPubb').val();  
	var image = $('#imagePubb').val();
	var jsonData = {titolo:titolo, description:descrizione, dataPubblicazioneM:anno, image:image}; //Array 
 	
 	alert("Titolo: "+titolo +", Descrizione: "+descrizione+", Anno: "+anno +", Image: "+image);
 	
 	if(contol(titolo, descrizione, anno)){
		$.ajax({
		    url : "http://localhost:8080/MicheleProject/pubblicazioni/insert",
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

function updatePreparePub(id){
	// alert('CIAO lans   ');
	var jsonData = {id:id}; //Array 
 	
	$.ajax({
	    url  : "http://localhost:8080/MicheleProject/pubblicazioni/getPubblicazione/"+id,
	    type : "GET",
	    data : jsonData,
		success : function(pubUpdate) {
            //alert('SUCCESS:   '+pubUpdate);
            console.log(pubUpdate);
            //console.log(data.success);
            $('#popUpdatePubblicazioni').empty();
            $('#popUpdatePubblicazioni').append(pubUpdate)
            
        }
	});
}

function dettaglio(id){
	// alert('CIAO lans   ');
	var jsonData = {id:id}; //Array 
 	
	$.ajax({
	    url  : "http://localhost:8080/MicheleProject/pubblicazioni/dettaglio/"+id,
	    type : "GET",
	    data : jsonData,
		success : function(pubDettaglio) {
            //alert('SUCCESS:   '+pubDettaglio);
            
            //console.log(data.success);
            $('#popDettaglioPub').empty();
            $('#popDettaglioPub').append(pubDettaglio)
            //console.log(pubDettaglio);
            
        }
	});
}

function updatePub(id){
	var titolo = $('#titoloPub').val();  
	var descrizione = $('#descrizionePub').val();  
	var anno = $('#annoPub').val();  
	var image = $('#imagePub').val();
	var jsonData = {titolo:titolo, description:descrizione, dataPubblicazioneM:anno, image:image}; //Array 
 	
 	alert("Titolo: "+titolo +", Descrizione: "+descrizione+", Anno: "+anno +", Image: "+image);
 	

 	if(contol(titolo, descrizione, anno)){
 		
		$.ajax({
		    url  : "http://localhost:8080/MicheleProject/pubblicazioni/update",
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

function deletePub(id, titolo){
	var result = window.confirm('Sei sicuro di volere eliminare la pubblicazione: '+titolo);
	 
    if (result == true) {
        var jsonData = {id:id}; //Array
		$.ajax({
		    url  : "http://localhost:8080/MicheleProject/pubblicazioni/delet/"+id,
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

function contol(titolo, descrizione, anno){
	if(titolo != "" && descrizione != "" && anno != ""){
		return true;
	}
	return false;
}


function refresh(){
	setTimeout(function(){// wait for 5 secs(2)
         location.reload(); // then reload the page.(3)
    }, 1000);
}
