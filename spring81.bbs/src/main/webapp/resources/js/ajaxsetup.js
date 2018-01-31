$(document).ajaxStart(function(){
//beforeSend와 같은 것.	
	$('body').prepend('<img src="/resources/images/loading.gif"/>');
});
$(document).ajaxComplete(function(data,textStatus,xhr){
	//always()메서드와  같은 것.	
	$('body img[src $="loading.gif"]').remove();
});
$(document).ajaxError(function(xhr,textStatus,error){
	//fail()메서드와  같은 것.	
	console.log(error);
});


