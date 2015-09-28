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
	
	
	this.rucInvalido = true; 
	
	this.validacionRuc = function() {
		
		if (this.inscripcion.ruc.length == 11)
		{
			Utils.Rest.getList(this, APP.URL_API + "institucion/" + this.inscripcion.ruc ).success(function(data){
				self.rucInvalido = false;
				self.inscripcion.institucion = data.nombre;
				self.inscripcion.QPInstitucionId = data.institucionId;
				
				
			}).error(function(){
				Utils.Notification.alerta("El RUC ingresado no puede participar en esta fase. Si cree que es un error por favor comuniquese con el correo <strong>experienciasexitosasongd@apci.gob.pe</strong>","Lo sentimos",15000);
				self.rucInvalido = true;
				self.inscripcion.institucion = "";
				self.inscripcion.institucionId = "";
			});
		}
		else {
			self.rucInvalido = true;
			self.inscripcion.institucion = "";
			self.inscripcion.institucionId = "";
		}
	}
	
	
	
	this.registrarse = function(){
				
		Utils.Validation.init();
		//Utils.Validation.required("#txt-ruc","R.U.C.");
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
		
		/*Utils.Validation.required("#checkbox-declaracion-jurada-1","Declaración Jurada");
		Utils.Validation.required("#checkbox-declaracion-jurada-2","Declaración Jurada");
		Utils.Validation.required("#checkbox-declaracion-jurada-3","Declaración Jurada");
		Utils.Validation.required("#checkbox-declaracion-jurada-4","Declaración Jurada");
		Utils.Validation.required("#checkbox-declaracion-jurada-5","Declaración Jurada");*/

		Utils.Validation.required("#txt-contraseña","Contraseña");
		Utils.Validation.required("#txt-confirme-contraseña","Confirme Contraseña");
		
		
		if (Utils.Validation.run()){
			console.log("inscripcion ", this.inscripcion);		
			Utils.Rest.save(APP.URL_API + "inscripcion", this.inscripcion);
			
			
			Utils.Notification.mensaje("","Registro satisfactorio");
			self.inscripcion = {};
			
		}
		
		
	}
	
});