$(document).ready(function() {

	//insert();
	//updatePrepare(id)
});

function insertPremiazioe() {
	var titolo = $('#titoloPremiazioe').val();
	var citta = $('#cittaPremiazioe').val();
	var descrizione = $('#descrizionePremiazioe').val();
	var anno = $('#annoPremiazioe').val();
	var jsonData = { titolo: titolo, descrizione: descrizione, citta: citta, data: anno }; //Array 

	//alert("Titolo: "+titolo +" Descrizione: "+descrizione+" Anno: "+anno);
	var contvalue = contol(titolo, descrizione, citta, anno)
	if (contvalue == true) {
		$.ajax({
			url: "/MicheleProject/biografia/insert",
			type: "POST",
			data: jsonData,
			success: function(resultMessage) {
				//console.log(resultMessage);
				$('#myReslte').empty();
				$('#myReslte').append(resultMessage)
			}

		});
	} else {
		campiOblig();
		//alert("Tutti i campi sono obbligatori!!!");
	}

}

function updatePrepare(id) {

	var jsonData = { id: id }; //Array 

	$.ajax({
		url: "/MicheleProject/biografia/openUpdate/" + id,
		type: "GET",
		data: jsonData,
		success: function(premiazioneUpdate) {
			//alert('SUCCESS:   '+premiazioneUpdate);
			//console.log(data.success);
			$('#popUpdatePremiazioe').empty();
			$('#popUpdatePremiazioe').append(premiazioneUpdate);
		}
	});
}

function update(id) {
	var titolo = $('#titoloPremiazioeUp').val();
	var citta = $('#cittaPremiazioeUp').val();
	var descrizione = $('#descrizionePremiazioeUp').val();
	var anno = $('#annoPremiazioeUp').val();
	var jsonData = { id: id, titolo: titolo, descrizione: descrizione, citta: citta, data: anno }; //Array 

	if (contol(titolo, descrizione, citta, anno)) {

		$.ajax({
			url: "/MicheleProject/biografia/update",
			type: "POST",
			data: jsonData,
			success: function(resultMessage) {
				//console.log(resultMessage);
				$('#myReslte').empty();
				$('#myReslte').append(resultMessage)
			}

		});
	} else {
		campiOblig();
		//alert("Tutti i campi sono obbligatori!!!");
	}

}


function confermaDeleteP(id, titolo) {
	//alert("Ecco mi LANS!!!");
	var messagio = "";
	messagio += "<div class='modal-body'>";
	messagio += "<h4> Sei sicuro di volere elimina:  <h4><h3>" + titolo + "</h3>";
	messagio += "<div class='modal-footer'>";
	messagio += "	<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>";
	messagio += "   <button type='button' class='button' data-toggle='modal' data-target='#popReslteP' data-gall='portfolioGallery' ";
	messagio += "	   	onclick='deletePremiazione(" +id+ ")'>Conferma</button>";
	messagio += "</div>";
	//console.log(messagio);
	$('#myTiteleP').empty();
	$('#myTiteleP').append(messagio);
}

function deletePremiazione(id) {
	$("#confirmazione").empty();
	var jsonData = { id: id }; //Array
	$.ajax({
		url: "/MicheleProject/biografia/delete/" + id,
		type: "GET",
		data: jsonData,
		success: function(resultMessage) {
			//console.log(resultMessage);
			$('#myReslte').empty();
			$('#myReslte').append(resultMessage);
			//refresh();
		}
	});

}

function insertOpera() {
	var descrizione = $('#descrizioneOpera').val();
	var anno = $('#annoOpera').val();
	var jsonData = { data: anno, descrizione: descrizione }; //Array 
	//alert(" Descrizione: "+descrizione+" Anno: "+anno);

	var contvalue = contolOpera(anno, descrizione);
	if (contvalue == true) {
		$("#popInsertOpera").empty();
		$.ajax({
			url: "/MicheleProject/biografia/opera/insert",
			type: "POST",
			data: jsonData,
			success: function(resultMessage) {
				//console.log(resultMessage);
				$('#myReslte').empty();
				$('#myReslte').append(resultMessage)
			}

		});
	} else {
		campiOblig();
		//alert("Tutti i campi sono obbligatori!!!");
	}

}

function updatePrepareOpera(id) {

	var jsonData = { id: id }; //Array 

	$.ajax({
		url: "/MicheleProject/biografia/opera/openUpdate/" + id,
		type: "GET",
		data: jsonData,
		success: function(operaUpdate) {
			//alert('SUCCESS:   '+operaUpdate);
			//console.log(operaUpdate);
			$('#popUpdateOpera').empty();
			$('#popUpdateOpera').append(operaUpdate);
		}
	});
}

function updateOpera(id) {
	var descrizione = $('#descrizioneOpereUp').val();
	var anno = $('#annoOpereUp').val();
	var jsonData = { id: id, data: anno, descrizione: descrizione }; //Array 

	if (contolOpera(anno, descrizione)) {

		$.ajax({
			url: "/MicheleProject/biografia/opera/update",
			type: "POST",
			data: jsonData,
			success: function(resultMessage) {
				//console.log(resultMessage);
				$('#myReslte').empty();
				$('#myReslte').append(resultMessage)
			}

		});
	} else {
		campiOblig();
		//alert("Tutti i campi sono obbligatori!!!");
	}

}

function confermaDeleteO(id, titolo) {
	//alert("Ecco mi LANS!!!");
	var messagio = "";
	messagio += "<div class='modal-body'>";
	messagio += "<h4> Sei sicuro di volere elimina:  <h4><h3>" + titolo + "</h3>";
	messagio += "<div class='modal-footer'>";
	messagio += "	<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>";
	messagio += "   <button type='button' class='button' data-toggle='modal' data-target='#popReslte' data-gall='portfolioGallery' ";
	messagio += "	   	onclick='deleteOpera(" + id + ")'>Conferma</button>";
	messagio += "</div>";
	//console.log(messagio);
	$('#myTitele').empty();
	$('#myTitele').append(messagio);
}

function deleteOpera(id) {
	//alert("Tutti !!!  "+result);
	$("#confirmazioneO").empty();
	var jsonData = { id: id }; //Array
	$.ajax({
		url: "/MicheleProject/biografia/opera/delete/" + id,
		type: "GET",
		data: jsonData,
		success: function(resultMessage) {
			//console.log(resultMessage);
			$('#myReslte').empty();
			$('#myReslte').append(resultMessage);
			//refresh();
		}
	});
}

function contol(titolo, descrizione, citta, anno) {
	if (titolo != "" && descrizione != "" && citta != "" && anno != "") {
		return true;
	}
	return false;
}
function contolOpera(data, descrizione) {
	if (data != "" && descrizione != "") {
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

