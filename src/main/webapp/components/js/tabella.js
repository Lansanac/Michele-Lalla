$(document).ready(function() {
	// tablePrepare();
});

var risorse = [
		
		{"nome":"Marcovalerio","cognome":"Botti","sesso":"Maschio","indirizzo":"Via Roma 12","citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it","sport":[{"nuoto":"Nuoto"}]},
	    {"nome":"Alessia","cognome": "Bottone","sesso":"Femmina","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"calcio":"Calcio"}]},
	    {"nome":"Marco","cognome": "Caliendo","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"tennis":"Tennis"}]},
	    {"nome":"Amelia","cognome": "Celentano","sesso":"Femmina","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"atletica":"Atletica"}]},
	    {"nome":"Daniele","cognome": "D'Andrea","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"ciclismo":"Ciclismo","atletica":"Atletica"}]},
	    {"nome":"Rossella","cognome": "D'€™Aniello","sesso":"Femmina","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"nuoto":"Nuoto"}]},
	    {"nome":"Marianna","cognome": "Di Matteo","sesso":"Femmina","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"pallavolo":"Pallavolo"}]},
	    {"nome":"Roberto","cognome": "Grasso","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"atletica":"Atletica"}]},
	    {"nome":"Marco","cognome": "Marrella","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"tennis":"Tennis"}]},
	    {"nome":"John","cognome": "Mukenge Nkuna","sesso":"Maschio","indirizzo":"Via Roma 12","citta": "Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"pallavolo":"Pallavolo"}]},
	    {"nome":"Francesco","cognome": "Parisi","sesso":"Maschio","indirizzo":"Via Roma 12","citta": "Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"calcio":"Calcio"}]},
	    {"nome":"Caterina","cognome": "Persiani","sesso":"Femmina","indirizzo":"Via Roma 12","citta": "Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"nuoto":"Nuoto"}]},
	    {"nome":"Damiano","cognome": "Petralia","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489", "email":"lansana@yahoo.it", "sport":[{"sci":"Sci"}]},
	    {"nome":"Theodor Mihaita","cognome": "Popescu","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"nuoto":"Nuoto"}]},
	    {"nome":"Paolo","cognome": "Tuberosa","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"tennis":"Tennis"}]},
	    {"nome":"Lansana","cognome": "Camara","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"calcio":"Calcio"}]},
	    {"nome":"Gabriele","cognome": "Caviola","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"ciclismo":"Ciclismo"}]},
	    {"nome":"Tiziano","cognome": "Mina","sesso":"Maschio","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"atletica":"Atletica"}]},
	    {"nome":"Carlotta","cognome": "Noè","sesso":"Femmina","indirizzo":"Via Roma 12", "citta":"Torino", "regione":"Piemonte", "telefono":"5463783489","email": "lansana@yahoo.it", "sport":[{"atletica":"Atletica","basket":"Basket"}]} 
	    		
];


function tablePrepare(nome,cognome,sesso,indirizzo,citta,regione,telefono,email,sport1) {
	
    if (risorse != null) {
    	var html="";
    	html+="<div id='example2_wrapper' class='dataTables_wrapper form-inline dt-bootstrap'><div class='row'><div class='col-sm-6'></div><div class='col-sm-6'></div></div><div class='row'><div class='col-sm-12'><table id='example2' class='table table-bordered table-hover dataTable' role='grid' aria-describedby='example2_info'>";
    	html+="<thead>";
    	html+="<tr role='row'>";
    	html+="<th class='sorting_asc' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-sort='ascending' aria-label='Nome: activate to sort column descending'>Nome</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='Cognome: activate to sort column ascending'>Cognome</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='Sesso: activate to sort column ascending'>Sesso</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='Indirizzo: activate to sort column ascending'>Indirizzo</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='CittÃ : activate to sort column ascending'>Città </th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='Regione: activate to sort column ascending'>Regione</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='Telefono: activate to sort column ascending'>Telefono</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='E-mail: activate to sort column ascending'>E-mail</th>";
    	html+="<th class='sorting' tabindex='0' aria-controls='example2' rowspan='1' colspan='1' aria-label='Sport: activate to sort column ascending'>Sport</th></tr>";
    	html+="</thead>";
    	html+="<tbody>";
    	html+="<tr role='row' class='odd'>";
    	
    	html+="<td class='sorting_1'>"+nome+"</td>";
    	html+="<td>"+ cognome +"</td>";
    	html+="<td>"+ sesso +"</td>";
    	html+="<td>"+ indirizzo +"</td>";
    	html+="<td>"+ citta +"</td>";
    	html+="<td>"+ regione +"</td>";
    	html+="<td>"+ telefono +"</td>";
    	html+="<td>"+ email +"</td>";
    	html+="<td>"+ sport1 +"</td></tr>";  
    	
    	for(var i = 0; i<risorse.length; i++){
            html+="<tr>";
            html+="<td>"+risorse[i].nome+"</td>";
            html+="<td>"+risorse[i].cognome+"</td>";
            html+="<td>"+risorse[i].sesso+"</td>";
            html+="<td>"+risorse[i].indirizzo+"</td>";
            html+="<td>"+risorse[i].citta+"</td>";
            html+="<td>"+risorse[i].regione+"</td>";
            html+="<td>"+risorse[i].telefono+"</td>";
            html+="<td>"+risorse[i].email+"</td>";
            var s = valorizzaSport(risorse,i);
            html+="<td>"+s+"</td>";
            html+="</tr>";
        }
    	
    	html+="</tbody>";
    	html+="<tfoot>";
    	html+="</tfoot>";
    	html+="</table></div></div><div class='row'><div class='col-sm-5'><div class='dataTables_info' id='example2_info' role='status' aria-live='polite'>Showing 1 to 10 of 57 entries</div></div>";
    	html+="<div class='col-sm-7'><div class='dataTables_paginate paging_simple_numbers' id='example2_paginate'><ul class='pagination'><li class='paginate_button previous disabled' id='example2_previous'><a href='#' aria-controls='example2' data-dt-idx='0' tabindex='0'>Previous</a>";
    	html+="</li><li class='paginate_button active'><a href='#' aria-controls='example2' data-dt-idx='1' tabindex='0'>1</a>";
    	html+="</li><li class='paginate_button '><a href='#' aria-controls='example2' data-dt-idx='2' tabindex='0'>2</a>";
    	html+="</li><li class='paginate_button '><a href='#' aria-controls='example2' data-dt-idx='3' tabindex='0'>3</a>";
    	html+="</li><li class='paginate_button '><a href='#' aria-controls='example2' data-dt-idx='4' tabindex='0'>4</a>";
    	html+="</li><li class='paginate_button '><a href='#' aria-controls='example2' data-dt-idx='5' tabindex='0'>5</a>";
    	html+="</li><li class='paginate_button '><a href='#' aria-controls='example2' data-dt-idx='6' tabindex='0'>6</a>";
    	html+="</li><li class='paginate_button next' id='example2_next'><a href='#' aria-controls='example2' data-dt-idx='7' tabindex='0'>Next</a>";
    	html+="</li></ul></div></div></div></div>";

        // html+="</table>";
        // html+="<div  align ='center' ><button  class='btn btn-dark' onclick='addUser()'> ADD USER </button></div> </div> ";
    }
    $("#div_table").append(html);
    $("#div_table").show();
}

function valorizzaSport(risorse,j) {
	var array = [];
	for (var i=0; i<risorse[j].sport.length; i++) {
		if (risorse[j].sport[i].nuoto) {
			array.push(risorse[j].sport[i].nuoto);
		}
		if (risorse[j].sport[i].calcio) {
			array.push(risorse[j].sport[i].calcio);
		}
		if (risorse[j].sport[i].tennis) {
			array.push(risorse[j].sport[i].tennis);
		}
		if (risorse[j].sport[i].pallavolo) {
			array.push(risorse[j].sport[i].pallavolo);
		}
		if (risorse[j].sport[i].basket) {
			array.push(risorse[j].sport[i].basket);
		}
		if (risorse[j].sport[i].sci) {
			array.push(risorse[j].sport[i].sci);
		}
		if (risorse[j].sport[i].ciclismo) {
			array.push(risorse[j].sport[i].ciclismo);
		}
		if (risorse[j].sport[i].atletica) {
			array.push(risorse[j].sport[i].atletica);
		}
		if (risorse[j].sport[i].rugby) {
			array.push(risorse[j].sport[i].rugby);
		}
	}
	var s = "";
	for (var i=0;i<array.length-1;i++) {
		s+=array[i]+", ";
	}
	s+=array[array.length-1];
	return s;
}