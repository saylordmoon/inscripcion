angular.module("main").controller("ExperienciaController" , function(Utils, APP){
	
	var self = this;

	this.experiencias = [];
	this.experiencia = {};
	
	this.departamentos = [];
	this.provincias = [];
	this.distritos = [];
	
	this.ambitos = [];
	this.ambito = {};
	
	Utils.Rest.getList(this, APP.URL_API + "experiencia","experiencias");
	Utils.Rest.getList(this, APP.URL_API + "departamento","departamentos");
	
	this.registrarExperiencia = function(pExperiencia){

		this.experiencia = pExperiencia;
		this.experiencia.fechaInicio = moment(pExperiencia.fechaInicio,"DD/MM/YYYY").toString();
		this.experiencia.fechaFin = moment(pExperiencia.fechaFin,"DD/MM/YYYY").toString();
		console.log("Registrar experiencia");
		$(".modal-registrar-experiencia").modal("show");
	}


	
	this.departamentoSelected = function(){
		
		var departamentoId = Utils.UI.Select.getSelectedAttr("sel-departamento","data-id");
		Utils.Rest.getList(this,APP.URL_API + "departamento/" + departamentoId + "/provincia" ,"provincias");
		this.ambito.provincia = "";
		
	}
	
	this.provinciaSelected = function() {
		
		var provinciaId = Utils.UI.Select.getSelectedAttr("sel-provincia","data-id");
		Utils.Rest.getList(this,APP.URL_API + "provincia/" + provinciaId + "/distrito" ,"distritos");
		this.ambito.distrito = "";
	}
	
	this.borrarAmbito = function(pAmbito) {
		Utils.List.delete(pAmbito,this.ambitos);
	}
	
	this.agregarAmbito = function(){
		
		Utils.Validation.init();
		var dep = Utils.Validation.required("#sel-departamento","Departamento",false);
		Utils.Validation.validate(dep,"Por favor, seleccione un valor","Ubicacion");
		
		
		
		if(Utils.Validation.run())
		{
			this.ambitos.push(this.ambito);
			this.ambito = {};
			this.provincias.length = 0;
			this.distritos.length = 0;
		}
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
	
	this.guardar = function(){

		Utils.Validation.init();
		Utils.Validation.required("#dat-fecha-inicio","Fecha de inicio");
		Utils.Validation.required("#dat-fecha-fin","Fecha de Fin");
		
		Utils.Validation.dateLessThan("#dat-fecha-inicio",this.experiencia.fechaFin,"Fecha de Inicio");
		Utils.Validation.dateGreaterThan("#dat-fecha-fin",this.experiencia.fechaInicio,"Fecha de Fin");
		
		Utils.Validation.required("#txt-sumilla","Sumilla");
		Utils.Validation.required("#formato","Documento de la Experiencia");
		
		Utils.Validation.minLen("#panel-ubicacion", this.ambitos, 1, "Ubicacion" , "panel-danger");
		
		Utils.Validation.required("#sel-ambito","Ambito");
		
		if (Utils.Validation.run()) {
			
			$(".modal-confirmacion-experiencia").modal("show");		
			}
		}
		
		
		this.confirmarRegistroExperiencia = function() {
			
			this.experiencia.fechaInicio = moment(this.experiencia.fechaInicio,"DD/MM/YYYY").toDate();
			this.experiencia.fechaFin = moment(this.experiencia.fechaFin,"DD/MM/YYYY").toDate();
			console.log("Fecha Inicio",this.experiencia.fechaInicio);
			console.log("Fecha Fin",this.experiencia.fechaFin);
			
			this.experiencia.ubigeo = JSON.stringify(this.ambitos);
			this.experiencia.registrada = true;
			delete this.experiencia.$$hashKey;
			
			Utils.Rest.update(APP.URL_API + "experiencia", this.experiencia).success(function(){
				
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
				
				self.experiencia.fechaInicio = null;
				self.experiencia.fechaFin = null;
				self.experiencia.sumilla = null;
				$(".modal-confirmacion-experiencia").modal("hide");
				$(".modal-registrar-experiencia").modal("hide");
			
			});
		}
});