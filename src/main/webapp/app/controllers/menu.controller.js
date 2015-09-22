angular.module("main").controller('MenuController', function(){
	this.items = [  
		{nombre:"Inicio", 	icono:"glyphicon glyphicon-home", 		url:"#/" },
	];

 	$("#menu-toggle").click(function(e) {  e.preventDefault();$("#wrapper").toggleClass("toggled"); });

});
