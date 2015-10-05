angular.module("main").controller("PreguntaController",function    (Utils,APP){
	
	var self = this;
	this.preguntas=[];
	
	refresh();
	
	this.pregunta = {};
	this.pregunta.categoriaId = 1;
	
	this.enviarPregunta = function(){
		
		Utils.Validation.init();
		Utils.Validation.required("#txt-nombres","Nombre");
		//Utils.Validation.required("#txt-institucion","Instituci&oacute;n");
		Utils.Validation.required("#txt-texto","Pregunta");
		
		this.pregunta.quienPregunta = this.pregunta.nombres+' / '+this.pregunta.institucion;
		
				
		Utils.Rest.save(APP.API_URL +"pregunta",this.pregunta).success(function(){
			refresh();
		});
		
		this.pregunta = {};
		this.pregunta.categoriaId = 1;
		
		if(Utils.Validation.run()){
			Utils.Notification.mensaje("Su pregunta se envi\u00F3", "Gracias");
		}		
	}
	
	function refresh(){
		Utils.Rest.getList(self,APP.URL_API +"pregunta/publicada","preguntas");
	}
	
});