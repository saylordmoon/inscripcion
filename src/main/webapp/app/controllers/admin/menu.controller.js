angular.module("main").controller('MenuController', function(Utils,APP){
	
	Utils.Rest.getList(this,APP.URL_API + "usuario/admin").error(function(){window.location = APP.URL_LOGIN;});
	
	this.items = [  
	              
		{ nombre:"Experiencias Inscritas", 	icono:"fa fa-edit", 		url:"#/" },
		{ nombre:"Responder Consultas", 	icono:"fa fa-comment", 		url:"#/respuesta" },
		
	];

 	$("#menu-toggle").click(function(e) {  e.preventDefault();$("#wrapper").toggleClass("toggled"); });
 
});
