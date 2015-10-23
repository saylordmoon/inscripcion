angular.module("main").controller('MenuController', function(Utils,APP){
	
	Utils.Rest.getList(this,APP.URL_API + "usuario").error(function(){window.location = APP.URL_LOGIN;});
	
	this.items = [  
	              
		{ nombre:"Inicio", 	icono:"glyphicon glyphicon-home", 		url:"#/" },
		
	];

 	$("#menu-toggle").click(function(e) {  e.preventDefault();$("#wrapper").toggleClass("toggled"); });
 
});
