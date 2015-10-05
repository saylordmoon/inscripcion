angular.module("main").controller("PreguntaController",function    (Utils,APP){
	
	var self = this;
	
	this.rucInvalido = true;
	
	refresh();
	
	this.preguntas=[];
	this.pregunta = {};
	this.pregunta.categoriaId = 3;
	
	this.enviarPregunta = function(){
		
		if (!this.rucInvalido) {
			Utils.Validation.init();
			Utils.Validation.required("#txt-nombres","Nombre");
			//Utils.Validation.required("#txt-institucion","Instituci&oacute;n");
			Utils.Validation.required("#txt-texto","Pregunta");
			
			this.pregunta.quienPregunta = this.pregunta.nombres+' / '+this.pregunta.institucion;
			
					
			Utils.Rest.save(APP.URL_API +"pregunta",this.pregunta).success(function(){
				refresh();
			});
			
			this.pregunta = {};
			this.pregunta.categoriaId = 3;
			
			if(Utils.Validation.run()){
				Utils.Notification.mensaje("Su pregunta ha sido recibida!", "Gracias por su consulta");
			}
		}
	}
	
	function refresh(){
		Utils.Rest.getList(self,APP.URL_API +"pregunta/publicada","preguntas");
	}
	
	this.validacionRuc = function() {
		
		if (this.pregunta.ruc.length == 11)
		{
			Utils.Rest.getList(this, APP.URL_API + "institucion/" + this.pregunta.ruc,"institucion").success(function(data){
				self.rucInvalido = false;
				self.pregunta.institucion = data.nombre;
				self.pregunta.QPInstitucionId = data.institucionId;
				self.pregunta.departamento = data.departamento;

			}).error(function(){
				Utils.Notification.alerta("El RUC ingresado no puede participar en esta fase. Si cree que es un error por favor comuniquese con el correo <strong>experienciasexitosasongd@apci.gob.pe</strong>","Lo sentimos",15000);
				self.rucInvalido = true;
				self.pregunta.institucion = "";
				self.pregunta.QPInstitucionId = "";
			});
		}
		else {
			self.rucInvalido = true;
			self.pregunta.institucion = "";
			self.pregunta.QPinstitucionId = "";
		}
	}
});