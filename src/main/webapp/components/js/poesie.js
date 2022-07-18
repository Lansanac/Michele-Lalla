$(document).ready(function() {
	AddReadMore();

});


function AddReadMore() {
	//This limit you can set after how much characters you want to show Read More.
	var carLmt = 600;
	// Text to show when text is collapsed
	var contentDataTxt = " continua... ";
	// Text to show when text is expanded
	var someVeekTxt = " chiudi";


	//Traverse all selectors with this class and manupulate HTML part to show Read More
	$(".showContentAll").each(function() {
		if ($(this).find(".firstSec").length)
			return;

		var allstr = $(this).text();
		if (allstr.length > carLmt) {
			var firstSet = allstr.substring(0, carLmt);
			var secdHalf = allstr.substring(carLmt, allstr.length);
			var strtoadd = firstSet + "<span class='DspInfo'>" + secdHalf + "</span>" +
				"<span class='contentData'  title='Click to Show More'>" + contentDataTxt + "</span>" +
				"<span class='someVeek' title='Click to Show Less'>" + someVeekTxt + "</span>";
			$(this).html(strtoadd);
		}

	});
	//ReadMore and ReadLess Click Event binding
	$(document).on("click", ".contentData,.someVeek", function() {
		$(this).closest(".showContentAll").toggleClass("displayreadallsome readalldatafull");
	});
}


function insertPoesia() {
	var titolo = $('#titoloPoesia').val();
	var descrizione = $('#descrizionePoesia').val();
	var anno = $('#annoPubblicazioneP').val();
	var jsonData = { titolo: titolo, descrizione: descrizione, dataPubblicazione: anno }; //Array 

	//alert("Titolo: "+titolo +" Descrizione: "+descrizione+" Anno: "+anno);
	var contvalue = contol(titolo, descrizione, anno)
	if (contvalue == true) {
		$.ajax({
			url: "/MicheleProject/poesia/insertPoesia",
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
		url: "/MicheleProject/poesia/openUpdate/" + id,
		type: "GET",
		data: jsonData,
		success: function(poesiaUpdate) {
			//alert('SUCCESS:   '+poesiaUpdate);
			//console.log(poesiaUpdate);
			//console.log(data.success);
			$('#popUpdatePoesia').empty();
			$('#popUpdatePoesia').append(poesiaUpdate);
		}
	});
}

function update(id) {
	var titolo = $('#titoloPoesiaUp').val();
	var descrizione = $('#descrizionePoesiaUp').val();
	var anno = $('#annoPubblicazioneUp').val();
	var jsonData = { id: id, titolo: titolo, descrizione: descrizione, dataPubblicazione: anno }; //Array 

	if (contol(titolo, descrizione, anno)) {

		$.ajax({
			url: "/MicheleProject/poesia/update",
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

function confermaDelete(id, titolo) {
	//alert("Ecco mi LANS!!!");
	var messagio = "";
	messagio += "<div class='modal-body'>";
	messagio += "<h4> Sei sicuro di volere elimina:  <h4><h3>" + titolo + "</h3>";
	messagio += "<div class='modal-footer'>";
	messagio += "	<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>";
	messagio += "   <button type='button' class='button' data-toggle='modal' data-target='#popReslte' data-gall='portfolioGallery' ";
	messagio += "	   	onclick='deletePoesia(" + id + ")'>Conferma</button>";
	messagio += "</div>";
	console.log(messagio);
	$('#myTitele').empty();
	$('#myTitele').append(messagio);
}

function deletePoesia(id) {

	var jsonData = { id: id }; //Array
	$.ajax({
		url: "/MicheleProject/poesia/delete/" + id,
		type: "GET",
		data: jsonData,
		success: function(resultMessage) {
			//console.log(resultMessage);
			$('#myReslte').empty();
			$('#myReslte').append(resultMessage);
		}
	});

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

/**
 * 
 */