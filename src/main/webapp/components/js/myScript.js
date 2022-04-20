/*$( document ).ready(function() {
	console.log( "ready!" );
	
	myActive();
	alert("Ciao Mondo")
    console.log( "	End!!!	" );


});*/


	function myActive(){
		$('li.active').removeClass('active');
		$('a[href="' + location.pathname + '"]').closest('li').addClass('active'); 
	    console.log( "Poesei is ready!	");
	    alert("Ecco mi Lans 4!!!"+ind)
	}
