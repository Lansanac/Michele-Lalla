 $(document).ready(function($) {

	/*
	$( document ).ajaxStart(function() {
	  	showLoader($); 
	});
	$( document ).ajaxStop(function() {
	  	$.loadingBlockHide();  
	});
	*/
	
	$(document).on({
	    ajaxStart: function(){
	        showLoader(); 
	    },
	    ajaxStop: function(){ 
	        $.loadingBlockHide(); 
	    } 
	});
 	/*$('body')
	    //.hide()  // Hide it initially
	    .ajaxStart(function() {
	        showLoader($);
	    })
	    .ajaxStop(function() {
	        $('body').hide();
    });
    
       
    $.loadingBlockShow({
        imgPath: '<c:url value="./application/img/default.svg" />',
		text: 'jQuery Script Loading ...',
        style: {
            position: 'fixed',
            width: '100%',
            height: '100%',
            background: 'rgba(0, 0, 0, .8)',
            left: 0,
            top: 0,
            zIndex: 10000
        }
    });

    setTimeout($.loadingBlockHide, 1000);
    */
    //showLoader($);

});

 // Add remove loading class on body element depending on Ajax request status
/*$(document).on({
    ajaxStart: function(){
        $("body").addClass(".loader16"); 
    },
    ajaxStop: function(){ 
        $("body").removeClass(".loader16"); 
    }    
    
});*/

function showLoader($){
	$.loadingBlockShow({
        imgPath: '<c:url value="./application/img/default.svg" />',
		text: 'jQuery Script Loading ...',
        style: {
            position: 'fixed',
            width: '100%',
            height: '100%',
            background: 'rgba(0, 0, 0, .8)',
            left: 0,
            top: 0,
            zIndex: 10000
        }
    });

   // setTimeout($.loadingBlockHide, 1000);
}

(function ($) {
    $.loadingBlockShow = function(opts) {
        var defaults = {
            imgPath: './application/img/icon.gif',
            imgStyle: {
                width: 'auto',
                textAlign: 'center',
                marginTop: '20%'
            },
            text: 'loading...',
            style: {
                position: 'fixed',
                width: '100%',
                height: '100%',
                background: 'rgba(255, 255, 255, .8)',
                left: 0,
                top: 0,
                zIndex: 10000
            }
        };
        $.extend(defaults, opts);
        $.loadingBlockHide();

        var img = $('<div><img src=<c:url value="' + defaults.imgPath + '" /> ><div>' + defaults.text + '</div></div>');
        var block = $('<div id="loading_block"></div>');

        block.css(defaults.style).appendTo('body');
        img.css(defaults.imgStyle).appendTo(block);
    };

    $.loadingBlockHide = function() {
        $('div#loading_block').remove();
    };
}(jQuery));


