$(document).ready(function() {


});



function sendMessage() {
	var nome = $('#nomeCognome').val();
	var email = $('#email').val();
	var soggetto = $('#soggetto').val();
	var messaggio = $('#messaggio').val();
	var jsonData = {nome:nome, email: email, soggetto: soggetto, messaggio: messaggio }; //Array 

	//alert("Nome Cognome: "+nome +" Email: "+email+" Soggetto: "+soggetto+ " Messaggio: "+messaggio);
	console.log(jsonData);
	if (contol(nomeCognome, email, soggetto, messaggio)) {
		$.ajax({
			url: "MicheleProject/messaggio",
			type: "POST",
			data: jsonData,
			success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		});
	} else {
		alert("Tutti i campi sono obbligatori!!!");
	}

}

/*
function updatePrepare(id) {

	var jsonData = { id: id }; //Array 

	$.ajax({
		url: "MicheleProject/racconti/getRacconto/" + id,
		type: "GET",
		data: jsonData,
		success: function(raccontiUpdate) {
			//alert('SUCCESS:   '+raccontiUpdate);
			console.log(raccontiUpdate);
			//console.log(data.success);
			$('#popUpdateRacconto').empty();
			$('#popUpdateRacconto').append(raccontiUpdate)

		}

	});
}

function update(id) {
	var titolo = $('#titoloRaccontiUp').val();
	var descrizione = $('#descrizioneRaccontiUp').val();
	var anno = $('#annoPubblicazioneUp').val();
	var jsonData = { id: id, titolo: titolo, descrizione: descrizione, annoPubblicazione: anno }; //Array 

	if (contol(titolo, descrizione, anno)) {

		$.ajax({
			url: "MicheleProject/racconti/updateRacconto",
			type: "POST",
			data: jsonData,
			success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }

		});
	} else {
		alert("Tutti i campi sono obbligatori!!!");
	}

}

function deleteRacconti(id, titolo) {
	var result = window.confirm('Sei sicuro di volere eliminare il racconto ' + titolo);

	if (result == true) {
		var jsonData = { id: id }; //Array
		$.ajax({
			url: "MicheleProject/racconti/deletRacconto/" + id,
			type: "GET",
			data: jsonData,
			success : function(resultMessage) {
				console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		});
	}

}
*/
function contol(nomeCognome, email, soggetto, messaggio) {
	if (nomeCognome != "" && email != "" && soggetto != "" && messaggio != "") {
		return true;
	}
	return false;
}

function refresh(){
	setTimeout(function(){// wait for 5 secs(2)
         location.reload(); // then reload the page.(3)
    }, 100);
}