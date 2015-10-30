angular.module("main").controller("RespuestaController",function(Utils,APP){
    
	var self = this;
	this.preguntas = [];
	this.pregunta = {};
	
	this.showForm = "";
	
	refresh();
	
	function refresh() {
		Utils.Rest.getList(self, APP.URL_API + "pregunta","preguntas");
	}
	
	this.publicar = function(pregunta) {
		
		pregunta.publicada = !pregunta.publicada;
		Utils.Rest.update(APP.URL_API +"pregunta",pregunta).success(function(){
			refresh();
		});
		
	} 
	
	this.responder = function(pPregunta) { 
		this.pregunta = pPregunta;
		$(".modal-respuesta").modal("show");	
	} 
	
	this.guardarRespuesta = function(){
		
		this.pregunta.respondida = true;
		Utils.Rest.update(APP.URL_API +"pregunta",this.pregunta);
		this.pregunta = {};
		this.pregunta.categoriaId = 1;
		$(".modal-respuesta").modal("hide");
	}
	
	$('.modal-respuesta').on('hide.bs.modal', function (e) {
		refresh();
	});
	
});

