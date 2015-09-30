angular.module("main").controller("ExperienciaController" , function(Utils, APP){
	
	this.experiencias = [];
	this.experiencia = {};
	
	var self = this;
	
	Utils.Rest.getList(this, APP.URL_API + "experiencia","experiencias");
	
	this.registrarExperiencia = function(pExperiencia){

		this.experiencia = pExperiencia;
		console.log("Registrar experiencia");
		$(".modal-registrar-experiencia").modal("show");
	}

	this.guardar = function(){

<<<<<<< HEAD
		Utils.Validation.init();
		Utils.Validation.required("#date-fechainicio","Fecha inicio");
		Utils.Validation.required("#date-fechafin","Fecha fin");
		/*Utils.Validation.required("#","Departamento");
		Utils.Validation.required("#opciones_1","Seleccionar Ámbito");
		
		Utils.Validation.required("#formato","Subir Formato");*/
		
		//Utils.Validation.required("#documento-adicional","Documento Adicional");
		
		if (Utils.Validation.run()) {
		
		
		this.experiencia.fechaInicio = moment(this.experiencia.fechaInicio,"DD/MM/YYYY").toDate();
		this.experiencia.fechaFin = moment(this.experiencia.fechaFin,"DD/MM/YYYY").toDate();

		console.log("fecha inicio ",this.experiencia.fechaInicio);
		console.log("fecha fin ",this.experiencia.fechaFin);
		
=======
>>>>>>> 6795b0cddfdf3f7efba4b4150783372f5b5d0d8a
		this.experiencia.registrada = true;
		Utils.Rest.update(APP.URL_API + "experiencia", this.experiencia);
		
		
		this.experiencia.fechaInicio = null;
		this.experiencia.fechaFin = null;
		this.experiencia.sumilla = null;		
		$(".modal-registrar-experiencia").modal("hide");		
		}
		
		
			
	$('input[type="file"]').each(function(index, control)
		{
			if ($(control).attr("ok") === "true") 
			{
				
				control.disabled="disabled"
				var archivoExperiencia = {};
				archivoExperiencia.inscripcionExperienciaId = self.experiencia.inscripcionExperienciaId;
				archivoExperiencia.archivo = control.files[0].name;
				archivoExperiencia.tipoArchivo = S(control.files[0].name).left(1).toUpperCase().s;
				Utils.Rest.save(APP.URL_API + "archivoexperiencia", archivoExperiencia);
			}
		});
		
<<<<<<< HEAD
		//Utils.UI.Control.disableChilds("form-experiencia");
	}
	
		
=======
		Utils.UI.Control.disableChilds("form-experiencia");
		this.experiencia = {};
		$(".modal-registrar-experiencia").modal("hide");
	}
	
>>>>>>> 6795b0cddfdf3f7efba4b4150783372f5b5d0d8a
	$('input[type="file"]').change(function(){
		
		console.log("upload",this);
		var control = this;
		$("#" + control.id + "-ok" ).hide();
		$(control).attr("ok","false");
		var	loaded = Utils.File.upload(control, APP.URL_API + "file/upload/" + self.experiencia.inscripcionExperienciaId );
		if (loaded) 
		{
			loaded.success(function(){
				$(control).attr("ok","true");
				$("#" + control.id + "-ok" ).show();
			});
		}
	});
<<<<<<< HEAD
	
			
	

=======
	
	$(".modal-registrar-experiencia").on('hidden.bs.modal', function (e) {
		
		self.experiencia = {};
		$('input[type="file"]').value('');
		
	})
>>>>>>> 6795b0cddfdf3f7efba4b4150783372f5b5d0d8a
	
});