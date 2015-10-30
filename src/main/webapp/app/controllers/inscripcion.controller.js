angular.module("main").controller("InscripcionController",function(Utils,APP,$location){
	
	var self = this;
	
	this.tematicas = [];
	
	this.departamentos = [];
	
	this.inscripcion = {};	
	this.experiencias = [];
	//modal
	this.experiencia = {};
	
	this.nueva = false;
	this.autocomplete=false;
	
	this.institucion = {};
	this.intervenciones = [];
	
	this.rucInvalido = true;
	
	Utils.Rest.getList(this,APP.URL_API + "tematica", "tematicas" );
	
	
	
	this.validacionRuc = function() {
		
		if (this.inscripcion.ruc.length == 11)
		{
			Utils.Rest.getList(this,APP.URL_API + "inscripcion/" + this.inscripcion.ruc + "/validar").success(function(){
				Utils.Rest.getList(self, APP.URL_API + "institucion/" + self.inscripcion.ruc,"institucion").success(function(data){
					self.rucInvalido = false;
					self.inscripcion.nombreInstitucion = data.nombre;
					self.inscripcion.institucionId = data.institucionId;
					self.inscripcion.emailInstitucion = data.email;
					self.inscripcion.numeroRegistroAPCI = data.codigo;
					self.inscripcion.direccionInstitucion = data.domicilio;
					self.inscripcion.telefonoInstitucion = data.telefono;
					self.inscripcion.departamento = data.departamento;
					self.inscripcion.provincia = data.provincia;
					self.inscripcion.distrito = data.distrito;
					self.inscripcion.usuario = data.ruc;
					self.inscripcion.directivoNombre = data.representante;
					
					if (data.representante) { 
						self.inscripcion.directivoCargo = "Representante Legal";
					}
					
					Utils.Rest.getList(self, APP.URL_API + "intervencion/" + data.institucionId, "intervenciones");
									
				}).error(function(){
					Utils.Notification.alerta("El RUC ingresado no puede participar en esta fase. Si cree que es un error por favor comuniquese con el correo <strong>experienciasexitosasongd@apci.gob.pe</strong>","Lo sentimos",15000);
					self.rucInvalido = true;
					self.inscripcion.institucion = "";
					self.inscripcion.institucionId = "";
				});

			}).error(function(){
				Utils.Notification.info("El RUC ingresado ya se encuentra inscrito","");
			});
		}
		else {
			self.rucInvalido = true;
			self.inscripcion.institucion = "";
			self.inscripcion.institucionId = "";
		}
	}
	
	this.agregarDatosExperiencia = function(){
		
		if (!this.rucInvalido) {
			this.nueva =true;
			$(".modal-datosexperiencia").modal("show");
		}
	}
	
	this.guardarExperiencia = function() {
		
		console.log("Guardar");
		
		Utils.Validation.init();
		Utils.Validation.required("#txt-titulo-experiencia","Titulo de la Experiencia");
		Utils.Validation.required("#sel-tematica-experiencia","Tematica");
		Utils.Validation.required("#txt-intervencion","Intervención");
		
		if (Utils.Validation.run()){
			
			this.experiencia.tematica = Utils.UI.Select.getSelectedText("sel-tematica-experiencia");
			if (this.nueva) this.experiencias.push(this.experiencia);
			console.log("Experiencias" , this.experiencias);
			this.experiencia = {};
			$(".modal-datosexperiencia").modal("hide");
		}
	}
	
	this.borrarExperiencia = function(pExperiencia) {
		
		console.log("borrar",pExperiencia);
		Utils.List.delete(pExperiencia,this.experiencias);
	}
	
	this.editarExperiencia = function(pExperiencia){
		
		this.nueva = false;
		this.experiencia = pExperiencia;
		$(".modal-datosexperiencia").modal("show");
	}
	
	this.rucInvalido = true;
	
	
	
	this.registrarse = function(){
				
		Utils.Validation.init();
		
		var ongdNombre = Utils.Validation.required("#txt-ongd","Nombre de la ONGD",false);
		var ongdDir = Utils.Validation.required("#txt-direccion","Dirección",false);
		var ongdTel = Utils.Validation.required("#txt-telefono","Teléfono",false);
		var ongdEmail = Utils.Validation.required("#txt-email","E-mail de la ONGD",false);
		
		var datosOngd = ongdNombre && ongdDir && ongdTel && ongdEmail;

		Utils.Validation.validate(datosOngd,"Por favor complete los datos de la ONGD","Datos de la ONGD");
		Utils.Validation.email("#txt-email","E-mail");
		
		Utils.Validation.minLen("#panel-experiencia", this.experiencias, 1, "Experiencia" , "panel-danger");

		var dirNom = Utils.Validation.required("#txt-directivo-nombres","Nombre de Directivo",false);
		var dirCar = Utils.Validation.required("#txt-directivo-cargo","Cargo de Directivo",false);
		var dirDNI = Utils.Validation.required("#txt-directivo-dni","DNI de Directivo",false);

		var dirTel = Utils.Validation.required("#txt-directivo-telefono","Teléfono de Directivo",false);
		var dirCel = Utils.Validation.required("#txt-directivo-celular","Celular de Directivo",false);
		var dirEmail = Utils.Validation.required("#txt-directivo-email","E-mail de Directivo",false);

		var directivo = dirNom && dirCar && dirDNI && dirTel && dirCel && dirEmail;
		Utils.Validation.validate(directivo,"Por favor complete los datos del Directivo","Datos del Directivo");
		Utils.Validation.email("#txt-directivo-email","E-mail del Directivo");
		if (dirDNI) Utils.Validation.len("#txt-directivo-dni", "DNI Directivo",8);
	
		var conNom = Utils.Validation.required("#txt-contacto-nombres","Nombre de Contacto",false);
		var conCar = Utils.Validation.required("#txt-contacto-cargo","Cargo de Contacto",false);
		var conDNI = Utils.Validation.required("#txt-contacto-dni","DNI de Contacto",false);
		var conTel = Utils.Validation.required("#txt-contacto-telefono","Teléfono de Contacto",false);
		var conCel = Utils.Validation.required("#txt-contacto-celular","Celular de Contacto",false);
		var conEmail = Utils.Validation.required("#txt-contacto-email","E-mail de Contacto",false);
		
		var contacto = conNom && conCar && conDNI && conTel && conCel && conEmail;
		Utils.Validation.validate(contacto,"Por favor complete los datos del Contacto","Datos del Contacto");
		Utils.Validation.email("#txt-directivo-email","E-mail de Contacto");
		if (conDNI) Utils.Validation.len("#txt-contacto-dni", "DNI Contacto",8);

		var declaracionJurada = $("#chk-declaracion-jurada-1").is(':checked') && $("#chk-declaracion-jurada-2").is(':checked') && $("#chk-declaracion-jurada-3").is(':checked') &&  $("#chk-declaracion-jurada-4").is(':checked') &&  $("#chk-declaracion-jurada-5").is(':checked'); 
		Utils.Validation.isTrueVar(declaracionJurada, "Declaracion Jurada", ".checkbox" )
		
		if (Utils.Validation.required("#txt-password", "Contraseña") && Utils.Validation.required("#txt-password-confirmacion", "Confirme su contraseña")) {
			Utils.Validation.equalsVar($("#txt-password").val(), $("#txt-password-confirmacion").val(),"Contraseña","Las contraseñas ingresadas no son iguales",".password");
		}
		
		if (Utils.Validation.run()){

			$(".modal-confirmacion").modal("show");
		}		
	}

	this.confirmarRegistro = function() {

		console.log("inscripcion ", this.inscripcion);		
		Utils.Rest.save(APP.URL_API + "inscripcion", this.inscripcion).success(function(finscripcion){
				
			Utils.Rest.save(APP.URL_API + "experiencia/" + finscripcion.inscripcionId + "/list",self.experiencias).success(function(){
				var usuario = {};
				usuario.usuario = self.inscripcion.usuario;
				usuario.hash = self.inscripcion.hash;
				usuario.institucionId = self.inscripcion.institucionId;
				Utils.Rest.save(APP.URL_API + "usuario/login",usuario);
				window.location = APP.URL + "login";
				window.open(APP.URL + "login","_blank");
			});
		});
	}
	
	this.buscarIntervencion = function(){
		
		if (S(this.experiencia.intervencion).length > 0 ) {
			this.autocomplete = true;
		}
		else {
			this.autocomplete = false;
		}
	}
	
	this.autocompleteSelected = function(pValue) {
		
		this.experiencia.intervencion = pValue;
		this.autocomplete=false;
	}
	
});