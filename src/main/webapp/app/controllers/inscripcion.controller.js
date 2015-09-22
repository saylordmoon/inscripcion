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
		
		console.log("Resgistrar");
		Util.Validation.init();
		
		
	}
	
});