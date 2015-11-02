<div class="row" data-ng-controller="ConsultaController as consultaCtrl">
	<div class="col-md-12">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h5>Experiencias registradas</h5>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<!-- <table class="table table-bordered"> -->
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr class="info">
								<th class="col-md-1">Nº</th>
								<th class="col-md-4">Experiencia</th>
								<th class="col-md-4">Institución</th>
								<th class="col-md-4">Temática</th>
								<th class="col-md-2">Registrada</th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="experiencia in consultaCtrl.experiencias">
								<td>{{$index+1}}</td>
								<td>{{experiencia.titulo}}</td>
								<td>{{experiencia.inscripcionId | tipo : consultaCtrl.instituciones : "inscripcionId" : "nombreInstitucion"}}</td>
								<td>{{experiencia.tematicaId | tipo: consultaCtrl.tematicas : "inscripcionTematicaId" : "descripcion" }}</td>
								<td>
									<button data-ng-show="experiencia.registrada" data-ng-click="consultaCtrl.mostrarExperiencia(experiencia)" class="btn btn-info bmd-ripple">
										<i class="fa fa-eye"></i>
										Ver Experiencia
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
				
	</div>

	<!-- Modal  -->
	<div class="modal modal-info fade modal-mostrar-experiencia" role="dialog">
		<div class="modal-dialog modal-tamanolg bmd-modal-dialog">
			<div class="modal-content">
				<div class="modal-header bmd-bg-info bmd-text-blue-50">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Detalle de la experiencia</h4>
				</div>
				<div id="form-experiencia" class="modal-body">
					<div class="panel ">
						<div class="panel-heading">
							<h4>{{consultaCtrl.experiencia.titulo}}</h4>
						</div>
						<div class="panel-body">
							<label>Ubicación de la experiencia:</label>
							<div class="table-responsive bmd-ripple">
								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th class="col-md-1">Nº</th>
											<th class="col-md-4">Departamento</th>
											<th class="col-md-3">Provincia</th>
											<th class="col-md-3">Distrito</th>
										</tr>
									</thead>
									<tbody>
										<tr data-ng-repeat="ubicacion in consultaCtrl.ubigeoexperiencia">
											<td>{{$index+1}}</td>
											<td>{{ubicacion.departamento}}</td>
											<td>{{ubicacion.provincia}}</td>
											<td>{{ubicacion.distrito}}</td>											
										</tr>
									</tbody>
								</table>
							</div>
							
							<div class="table-reponsive">
								<table class="table table-striped table-condensed table-bordered">
									<thead>
										<tr>
											<th>Ámbito</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="col-md-3">{{consultaCtrl.experiencia.ambito}}</td>
										</tr>
									</tbody>	
								</table>
							</div>

							<div class="table-responsive">
								<table class="table table-condensed table-striped table-bordered">
									<thead>
										<tr>
											<th class="col-md-6">Fecha Inicio de la Intervención</th>
											<th class="col-md-6">Fecha Fin de la Intervención</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>{{consultaCtrl.experiencia.fechaInicio}}</td>
											<td>{{consultaCtrl.experiencia.fechaFin}}</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div class="table-responsive">
								<table class="table table-condensed table-striped table-bordered">
									<thead>
										<tr>
											<th class="col-md-6">Formato de la Experiencia</th>
											<th class="col-md-6">Documento Adicional</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td data-ng-init="formatodocumento.tipoArchivo = 'F'">
												<a data-ng-repeat="formato in consultaCtrl.archivosExperiencia | filter : formatodocumento" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{formato.archivo}}" class="btn btn-info bmd-ripple bmd-floating" style="margin-top:0px;">
													<i class="fa fa-eye"></i> Ver Documento
												</a>
											</td>
											<td data-ng-init="formatodocumentoadicional.tipoArchivo = 'D'" >
												<a data-ng-repeat="adicional in consultaCtrl.archivosExperiencia | filter : formatodocumentoadicional" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{adicional.archivo}}" class="btn btn-info bmd-ripple bmd-floating" style="margin-top:0px;">
													<i class="fa fa-eye"></i> Ver Documento
												</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div class="table-responsive">
								<table class="table table-condensed table-striped table-bordered">
									<thead>
										<tr>
											<th class="col-md-6">Video</th>
											<th class="col-md-6">Audio Visual</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td data-ng-init="video.tipoArchivo = 'V'">
												<a data-ng-repeat="formato in consultaCtrl.archivosExperiencia | filter : video" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{formato.archivo}}" class="btn btn-info bmd-ripple bmd-floating" style="margin-top:0px;">
													<i class="fa fa-eye"></i> Ver Video
												</a>
											</td>
											<td data-ng-init="audiovisual.tipoArchivo = 'A'" >
												<a data-ng-repeat="adicional in consultaCtrl.archivosExperiencia | filter : audiovisual" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{adicional.archivo}}" class="btn btn-info bmd-ripple bmd-floating" style="margin-top:0px;">
													<i class="fa fa-eye"></i> Ver Audiovisual
												</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div class="panel panel-default">
				            	<div class="panel-body">
									<h4>Galería de Fotos</h4>
									<hr />
									<div class="gal" data-ng-init="imagenarchivo.tipoArchivo = 'I'" >
										<a data-ng-repeat="imagen in consultaCtrl.archivosExperiencia | filter : imagenarchivo" class="fancybox" rel="group" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{imagen.archivo}}">
											<img data-ng-src="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{imagen.archivo}}" alt="" height="130px" width="200px">
										</a>
						            </div>
				            	</div>
				            </div>

						</div>
					</div>
		            
				</div>
			</div>
		</div>
	</div><!--/ Modal  -->
	

</div>

<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">


  

		