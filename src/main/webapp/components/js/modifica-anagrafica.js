$(document).ready(function() {
	
	$("#salva-anagrafica").click( function(e)
       {
         alert('Tutti i campi sono obbligatori!!!');
         e.preventDefault();
       }
    );
});

function control(){
	var nome = $("#nome").val();
	var cognome = $("#cognome").val();
	var codiceFisale = $("#codice-fiscale").val();
	var eta = $("#eta").val();
	var provincia = $("#provincia-nascita").val();
	var sesso = $("#sesso").val();
	var categoriaProtetta = $("#categoria-protetta").val();
	var curriculum = $("#curriculum").val();
	if(nome!=""&& cognome!=""&& codiceFisale!=""&& eta!="" && provincia!=""&& sesso!=""&& categoriaProtetta!="" && curriculum!="") {
		return true;
	}else{
		return false;
	}
	
}