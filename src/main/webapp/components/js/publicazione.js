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
	if (myImage.files[0] != null && contol(titolo, descrizione, anno)) {

		console.log("IMG ", myImage);

		var f;
		var fReader = new FileReader();
		fReader.readAsDataURL(myImage.files[0]);

		fReader.onloadend = function(event) {

			f = event.target.result;

			var image = f.split(",")[1];

			var jsonData = { titolo: titolo, description: descrizione, dataPubblicazioneM: anno, image: image }; //Array 
			//alert("Titolo: " + titolo + ", Descrizione: " + descrizione + ", Anno: " + anno + ", Image: " + image);
			$("#popInsert").empty();
			$.ajax({
				url: "/MicheleProject/pubblicazioni/insert",
				type: "POST",
				data: jsonData,
				success: function(resultMessage) {
					console.log(resultMessage);
					$('#myReslte').empty();
					$('#myReslte').append(resultMessage)
				}

			});
		}
	} else {
		//alert("Tutti i campi sono obbligatori!!!");
		campiOblig();
	}

}

function updatePreparePub(id) {
	// alert('CIAO lans   ');
	var jsonData = { id: id }; //Array 
	//

	$.ajax({
		url: "/MicheleProject/pubblicazioni/getPubblicazione/" + id,
		type: "GET",
		data: jsonData,
		success: function(pubUpdate) {
			//alert('SUCCESS:   '+pubUpdate);
			//console.log(pubUpdate);
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
		url: "/MicheleProject/pubblicazioni/dettaglio/" + id,
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


	if (image.files[0] != null && contol(titolo, descrizione, anno)) {
		console.log('=======> ', image);

		var f;
		var fReader = new FileReader();
		fReader.readAsDataURL(image.files[0]);
		fReader.onloadend = function(event) {

			f = event.target.result;
			//console.log("IMG ", f);
			//console.log("IMG ", image);
			var e = f.split(",")[1];
			var jsonData = { id: id, titolo: titolo, description: descrizione, dataPubblicazioneM: anno, image: e }; //Array 

			//alert("Id: " + id + ", Titolo: " + titolo + ", Descrizione: " + descrizione + ", Anno: " + anno + ", Image: " + f);


			$("#popDettaglioPub").empty();
			$.ajax({
				url: "/MicheleProject/pubblicazioni/update",
				type: "POST",
				data: jsonData,
				success: function(resultMessage) {
					//console.log(resultMessage);
					$('#myReslte').empty();
					$('#myReslte').append(resultMessage)
				}

			});
		}
	} else {
		//alert("Tutti i campi sono obbligatori!!!");
		campiOblig();
	}
}


function confermaDelete(id, titolo) {
	//alert("Ecco mi LANS!!!");
	var messagio = "";
	messagio += "<div class='modal-body'>";
	messagio += "<h4> Sei sicuro di volere elimina:  <h4><h3>" + titolo + "</h3>";
	messagio += "<div class='modal-footer'>";
	messagio += "	<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>";
	messagio += "   <button type='button' class='button' data-toggle='modal' data-target='#popReslte' data-gall='portfolioGallery' ";
	messagio += "	   	onclick='deletePub(" + id + ")'>Conferma</button>";
	messagio += "</div>";
	console.log(messagio);
	$('#myTitele').empty();
	$('#myTitele').append(messagio);
}

function deletePub(id) {
	//var result = window.confirm('Sei sicuro di volere eliminare la pubblicazione: ' + titolo);
	$("#confirmazione").empty();
	//if (result == true) {
	var jsonData = { id: id }; //Array
	$.ajax({
		url: "/MicheleProject/pubblicazioni/delet/" + id,
		type: "GET",
		data: jsonData,
		success: function(resultMessage) {
			//console.log(resultMessage);
			$('#myReslte').empty();
			$('#myReslte').append(resultMessage)
		}
	});
	//}

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
	}, 100);
}

function campiOblig() {

	var myhtml = "";

	myhtml += "<div class='container'>";
	myhtml += "<div class='modal-header'>";
	myhtml += "	<div class='section-title'>";
	myhtml += "		<h2>Error message</h2>";
	myhtml += "	</div>";

	myhtml += "	<button type='button' class='close' aria-label='Close'";
	myhtml += "		data-dismiss='modal' >";
	myhtml += "		<span aria-hidden='true'>&times;</span>";
	myhtml += "	</button>";

	myhtml += "</div>";
	myhtml += "<div class='modal-body'>";
	myhtml += "		 <span><h1 style='color:red;'>Tutti i campi sono obbligatori!</h1> </span>";

	myhtml += "</div>";
	myhtml += "<div class='modal-footer'>";
	myhtml += "	<div class='social-links mt-3 text-center'>";
	myhtml += "		<a class='btn btn-default' data-dismiss='modal' > Close </a>";
	myhtml += "	</div>";
	myhtml += "</div>";
	myhtml += "</div>";

	console.log("HTML: ", myhtml);
	$('#myReslte').empty();
	$('#myReslte').append(myhtml);

}

