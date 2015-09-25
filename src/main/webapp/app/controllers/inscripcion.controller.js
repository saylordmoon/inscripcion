angular.module("main").controller("InscripcionController",function(Utils,APP){
	
	var self = this;
	
	this.inscripcion = {};
	
	
	this.experiencias = [];
	
	//modal
	this.experiencia = {};
	
	this.nueva = false;
	
	this.agregarDatosExperiencia = function(){
		
		console.log("agregar");
		this.nueva =true;
		$(".modal-datosexperiencia").modal("show");
	}
	
	
	this.guardarExperiencia = function() {
		
		console.log("Guardar");
		if (this.nueva) this.experiencias.push(this.experiencia);
		console.log("Experiencias" , this.experiencias);
		this.experiencia = {};
		$(".modal-datosexperiencia").modal("hide");
	}
	
	
	this.borrarExperiencia = function(pExperiencia) {
		
		console.log("borrar",pExperiencia);
		Utils.List.delete(pExperiencia,this.experiencias);
	}
	
	this.editarExperiencia = function(pExperiencia){
		
		console.log("Editar");
		this.nueva = false;
		this.experiencia = pExperiencia;
		$(".modal-datosexperiencia").modal("show");
	}
	
	this.registrarse = function(){
				
		Utils.Validation.init();
		Utils.Validation.required("#txt-ongd","Nombre de la ONGD");
		Utils.Validation.required("#sel-departamento","Departamento");
		Utils.Validation.required("#txt-direccion","Dirección");
		Utils.Validation.required("#txt-numero-registro","Número de Registro APCI");
		Utils.Validation.required("#txt-telefono","Teléfono");
		Utils.Validation.required("#txt-email","E-mail");
		
		Utils.Validation.required("#txt-directivo-nombres","Nombre de Directivo");
		Utils.Validation.required("#txt-directivo-cargo","Cargo de Directivo");
		Utils.Validation.required("#txt-directivo-dni","DNI de Directivo");
		Utils.Validation.required("#txt-directivo-telefono","Teléfono de Directivo");
		Utils.Validation.required("#txt-directivo-celular","Celular de Directivo");
		Utils.Validation.required("#txt-directivo-email","E-mail de Directivo");
		
		Utils.Validation.required("#txt-contacto-nombres","Nombre de Contacto");
		Utils.Validation.required("#txt-contacto-cargo","Cargo de Contacto");
		Utils.Validation.required("#txt-contacto-dni","DNI de Contacto");
		Utils.Validation.required("#txt-contacto-telefono","Teléfono de Contacto");
		Utils.Validation.required("#txt-contacto-celular","Celular de Contacto");
		Utils.Validation.required("#txt-contacto-email","E-mail de Contacto");
		
		Utils.Validation.required("#checkb-1","Declaración Jurada");

		
		
		
		if (Utils.Validation.run()){
			console.log("Registrar");
		}
		
		
	}
	
});