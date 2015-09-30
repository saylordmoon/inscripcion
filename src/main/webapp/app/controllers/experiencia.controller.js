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

		this.experiencia.registrada = true;
		Utils.Rest.update(APP.URL_API + "experiencia", this.experiencia);
			
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
		
		Utils.UI.Control.disableChilds("form-experiencia");
		this.experiencia = {};
		$(".modal-registrar-experiencia").modal("hide");
	}
	
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
	
	$(".modal-registrar-experiencia").on('hidden.bs.modal', function (e) {
		
		self.experiencia = {};
		$('input[type="file"]').value('');
		
	})
	
});