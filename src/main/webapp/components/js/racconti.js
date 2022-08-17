$(document).ready(function() {

	//insert();
 	//updatePrepare(id)

	//Calling function after Page Load
	 AddReadMore();
	
});


function AddReadMore() {
    //This limit you can set after how much characters you want to show Read More.
    var carLmt = 800;
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
            var strtoadd = firstSet + "<span class='DspInfo'>" + secdHalf + "</span>"+
			"<span class='contentData'  title='Click to Show More'>" + contentDataTxt + "</span>"+
			"<span class='someVeek' title='Click to Show Less'>" + someVeekTxt + "</span>";
            $(this).html(strtoadd);
        }

    });
    //ReadMore and ReadLess Click Event binding
    $(document).on("click", ".contentData,.someVeek", function() {
        $(this).closest(".showContentAll").toggleClass("displayreadallsome readalldatafull");
    });
}

function insertRacconto(){
	var titolo = $('#titoloRacconti').val();  
	var descrizione = $('#descrizioneRacconti').val();  
	var anno = $('#annoPubblicazione').val();  
	var jsonData = {titolo:titolo, descrizione:descrizione, annoPubblicazione :anno}; //Array 
 	
 	//alert("Titolo: "+titolo +" Descrizione: "+descrizione+" Anno: "+anno);
 	
 	if(contol(titolo, descrizione, anno)){
 		$('#popInsert').empty();
		$.ajax({
		    url : "/racconti/insertRacconto",
		    type : "POST",
		    data : jsonData,
		    success : function(resultMessage) {
				//console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage);
		    }
		    
		});
	}else{
		campiOblig();
		//alert("Tutti i campi sono obbligatori!!!");
	}
	
}

function updatePrepare(id){
	var jsonData = {id:id}; //Array 
 	
	$.ajax({
	    url  : "/racconti/getRacconto/"+id,
	    type : "GET",
	    data : jsonData,
		success : function(raccontiUpdate) {
            //alert('SUCCESS:   '+raccontiUpdate);
            //console.log(raccontiUpdate);
            //console.log(data.success);
            $('#popUpdateRacconto').empty();
            $('#popUpdateRacconto').append(raccontiUpdate)
            
        }
	    
	});
}

function update(id){
	var titolo = $('#titoloRaccontiUp').val();  
	var descrizione = $('#descrizioneRaccontiUp').val();  
	var anno = $('#annoPubblicazioneUp').val();  
	var jsonData = {id:id, titolo:titolo, descrizione:descrizione, annoPubblicazione:anno}; //Array 
	
 	if(contol(titolo, descrizione, anno)){
 		
		$.ajax({
		    url  : "/racconti/updateRacconto",
		    type : "POST",
		    data : jsonData,
		    success : function(resultMessage) {
				//console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		    
		});
	}else{
		campiOblig();
		//alert("Tutti i campi sono obbligatori!!!");
	}
	
}

function deleteRacconti(id){
	$("#confirmazione").empty();
    //if (result == true) {
        var jsonData = {id:id}; //Array
		$.ajax({
		    url  : "/racconti/deletRacconto/"+id,
		    type : "GET",
		    data : jsonData,
			success : function(resultMessage) {
				//console.log(resultMessage);
		        $('#myReslte').empty();
            	$('#myReslte').append(resultMessage)
		    }
		});
    //}

}

function confermaDelete(id, titolo){
	//alert("Ecco mi LANS!!!");
	var messagio = "";
	  messagio +="<div class='modal-body'>";
	  messagio +="<h4> Sei sicuro di volere elimina:  <h4><h3>"+titolo+"</h3>";	
	  messagio +="<div class='modal-footer'>";
	  messagio +="	<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>";
	  messagio +="   <button type='button' class='button' data-toggle='modal' data-target='#popReslte' data-gall='portfolioGallery' ";
	  messagio +="	   	onclick='deleteRacconti("+id+")'>Conferma</button>";
	  messagio +="</div>";
	console.log(messagio);
	$('#myTitele').empty();
    $('#myTitele').append(messagio);
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
 *//**
 * 
 */