$(document).ready(function() {

	//insert();
	//updatePrepare(id)

	//Calling function after Page Load

});


function insertPublicazione() {
	var titolo = $('#titoloPubb').val();
	var descrizione = $('#descrizionePubb').val();
	var anno = $('#annoPubb').val();
	var myImage = document.getElementById("imagePubbIn");
	// $('#imagePub').val();
	//console.log('=======> ' , image);
	var f;
	var fReader = new FileReader();
	fReader.readAsDataURL(myImage.files[0]);
	fReader.onloadend = function(event) {

		f = event.target.result;
		console.log("IMG ", f);
		console.log("IMG ", myImage);
		var image = f.split(",")[1];

		var jsonData = { titolo: titolo, description: descrizione, dataPubblicazioneM: anno, image: image }; //Array 
		//alert("Titolo: " + titolo + ", Descrizione: " + descrizione + ", Anno: " + anno + ", Image: " + image);
		if (contol(titolo, descrizione, anno)) {
			$.ajax({
				url: "http://localhost:8080/MicheleProject/pubblicazioni/insert",
				type: "POST",
				data: jsonData,
				success: function(resultMessage) {
					console.log(resultMessage);
					$('#myReslte').empty();
					$('#myReslte').append(resultMessage)
				}

			});
		} else {
			alert("Tutti i campi sono obbligatori!!!");
		}

	}
}

function updatePreparePub(id) {
	// alert('CIAO lans   ');
	var jsonData = { id: id }; //Array 

	$.ajax({
		url: "http://localhost:8080/MicheleProject/pubblicazioni/getPubblicazione/" + id,
		type: "GET",
		data: jsonData,
		success: function(pubUpdate) {
			//alert('SUCCESS:   '+pubUpdate);
			console.log(pubUpdate);
			//console.log(data.success);
			$('#popUpdatePubblicazioni').empty();
			$('#popUpdatePubblicazioni').append(pubUpdate)

		}
	});
}

function getDataUrl(img) {
	// Create canvas
	const canvas = document.createElement('canvas');
	const ctx = canvas.getContext('2d');
	// Set width and height
	canvas.width = img.width;
	canvas.height = img.height;
	// Draw the image
	ctx.drawImage(img, 0, 0);
	return canvas.toDataURL('image/jpeg');
}

function dettaglio(id) {
	// alert('CIAO lans   ');
	var jsonData = { id: id }; //Array 

	$.ajax({
		url: "http://localhost:8080/MicheleProject/pubblicazioni/dettaglio/" + id,
		type: "GET",
		data: jsonData,
		success: function(pubDettaglio) {
			//alert('SUCCESS:   '+pubDettaglio);

			//console.log(data.success);
			$('#popDettaglioPub').empty();
			$('#popDettaglioPub').append(pubDettaglio)
			//console.log(pubDettaglio);

		}
	});
}

function updatePub(id) {
	var titolo = $('#titoloPub').val();
	var descrizione = $('#descrizionePub').val();
	var anno = $('#annoPub').val();
	var image = document.getElementById("imagePub");// $('#imagePub').val();
	//console.log('=======> ' , image);
	var f;
	var fReader = new FileReader();
	fReader.readAsDataURL(image.files[0]);
	fReader.onloadend = function(event) {

		f = event.target.result;
		console.log("IMG ", f);
		console.log("IMG ", image);
		var e = f.split(",")[1];
		var jsonData = { id: id, titolo: titolo, description: descrizione, dataPubblicazioneM: anno, image: e }; //Array 

		//alert("Id: " + id + ", Titolo: " + titolo + ", Descrizione: " + descrizione + ", Anno: " + anno + ", Image: " + f);


		if (contol(titolo, descrizione, anno)) {

			$.ajax({
				url: "http://localhost:8080/MicheleProject/pubblicazioni/update",
				type: "POST",
				data: jsonData,
				success: function(resultMessage) {
					console.log(resultMessage);
					$('#myReslte').empty();
					$('#myReslte').append(resultMessage)
				}

			});
		} else {
			alert("Tutti i campi sono obbligatori!!!");
		}

	}

}

function deletePub(id, titolo) {
	var result = window.confirm('Sei sicuro di volere eliminare la pubblicazione: ' + titolo);

	if (result == true) {
		var jsonData = { id: id }; //Array
		$.ajax({
			url: "http://localhost:8080/MicheleProject/pubblicazioni/delet/" + id,
			type: "GET",
			data: jsonData,
			success: function(resultMessage) {
				console.log(resultMessage);
				$('#myReslte').empty();
				$('#myReslte').append(resultMessage)
			}
		});
	}

}

function contol(titolo, descrizione, anno) {
	if (titolo != "" && descrizione != "" && anno != "") {
		return true;
	}
	return false;
}


function refresh() {
	setTimeout(function() {// wait for 5 secs(2)
		location.reload(); // then reload the page.(3)
	}, 1000);
}
