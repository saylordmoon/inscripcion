

<div class="row" data-ng-controller="ConsultaController as consultaCtrl">
	<div class="col-md-12">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h5>Experiencias registradas</h5>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<!-- <table class="table table-bordered"> -->
					<table class="table table-striped table-hover ">
						<thead>
							<tr class="info">
								<th class="col-md-1">Nº</th>
								<th class="col-md-4">Experiencia</th>
								<th class="col-md-4">Institución</th>
								<th class="col-md-2"></th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="experiencia in consultaCtrl.experiencias">
								<td>{{$index+1}}</td>
								<td>{{experiencia.titulo}}</td>
								<!-- <td>{{consultaCtrl.instituciones.nombre}}</td> -->
								<td>{{experiencia.inscripcionId | tipo : consultaCtrl.instituciones : "inscripcionId" : "nombreInstitucion"}}</td>
								<td>
									<button data-ng-click="consultaCtrl.mostrarExperiencia(experiencia)" class="btn btn-info bmd-ripple">
										<i class="fa fa-folder-open"></i>
										Visualizar experiencia
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="panel-footer">
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
					<h4 class="modal-title">Presentación de la experiencia</h4>
				</div>
				<div id="form-experiencia" class="modal-body">					
					<div class="row">
		                <div class="col-md-12">
		                    <div class="form-group">
		                        <label>Título: </label>
		                        <textarea id="txt-titulo" class="form-control" rows="3" data-ng-model="consultaCtrl.experiencia.titulo" readonly></textarea>
		                    </div>
		                </div>
		            </div>
		            <div class="row">
		            	<div class="col-md-12">
			            	<label>Ubicación de la experiencia:</label>
			            	<br/>
		            	</div>
		            	<div class="col-md-1">
		            	</div>
						<div class="col-md-10" style="margin-left: 15px;">
							<div class="table-responsive bmd-ripple">
								<table class="table table-striped table-hover">
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
						</div>
						<div class="col-md-1">
		            	</div>
					</div>
		            <div class="row">
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label>La población que intervino en la experiencia es del ámbito:</label>
		                        <input id="txt-ambito" type="text" class="form-control" data-ng-model="consultaCtrl.experiencia.ambito" readonly/>
		                    </div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label><i class="glyphicon glyphicon-calendar"></i> Fecha Inicio de la Intervención:</label>
		                        <input id="dat-fecha-inicio" type="text" class="form-control" data-ng-model="consultaCtrl.experiencia.fechaInicio" readonly/>
		                    </div>
		                </div>
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label><i class="glyphicon glyphicon-calendar"></i> Fecha Fin de la Intervención:</label>
		                        <input id="dat-fecha-fin" type="text" class="form-control" data-ng-model="consultaCtrl.experiencia.fechaFin" readonly/>
		                    </div>
		                </div>
		            </div>
		            <hr>
		            <div class="row">
			            <div class="col-md-1">
			            </div>
		                <div class="col-md-10">
		                    <div class="rows">
		                        <div class="col-md-12">
		                            <div class="form-horizontal">
		                                <div class="form-group">
		                                    <label class="col-sm-3">Formato:</label>
		                                    <div class="col-sm-3 pull-left" data-ng-init="formatodocumento.tipoArchivo = 'D'">
		                                        <a data-ng-repeat="formato in consultaCtrl.archivosExperiencia | filter : formatodocumento" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{formato.archivo}}" class="btn btn-primary bmd-ripple" style="margin-top:0px;"><i class="fa fa-eye">
		                                        </i>&nbsp;Ver</a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        <div class="col-md-12">
		                            <div class="form-horizontal">
		                                <div class="form-group">
		                                    <label class="col-sm-3">Formato Adicional:</label>
		                                   <!--  <div class="col-sm-6">
		                                        <input id="txt-formato-adicional" type="text" class="form-control" readonly/>
		                                    </div> -->
		                                    <div class="col-sm-3 pull-left" data-ng-init="formatodocumentoadicional.tipoArchivo = 'F'">
		                                        <a data-ng-repeat="adicional in consultaCtrl.archivosExperiencia | filter : formatodocumentoadicional" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{adicional.archivo}}" class="btn btn-primary bmd-ripple" style="margin-top:0px;">
		                                        	<i class="fa fa-eye"></i>&nbsp;Ver
		                                        </a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="col-md-1">                  
                		</div>
                	</div>
		            <hr/>
		            <div class="row">
		            	<div class="col-md-4"> 
			            	<div class="panel panel-default">
	  							<div class="panel-heading">
	    							<h3 class="panel-title">Video</h3>
	  							</div>
		  						<div class="panel-body" data-ng-init="videoarchivo.tipoArchivo = 'V'" >
		  							
		    						<a data-ng-repeat="video in consultaCtrl.archivosExperiencia | filter : videoarchivo" 
		    							href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{video.archivo}}">
						            	<i class="fa fa-eye fa-4"></i>&nbsp;Ver
						            </a> 
						           
		  						</div>
	  						</div>
	  					</div>
  						<div class="col-md-4"> 
			            	<div class="panel panel-default">
	  							<div class="panel-heading">
	    							<h3 class="panel-title">Audiovisual</h3>
	  							</div>
		  						<div class="panel-body" data-ng-init="audiovisualarchivo.tipoArchivo = 'A'">
		    						<a data-ng-repeat="audiovisual in consultaCtrl.archivosExperiencia | filter : audiovisualarchivo" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{audiovisual.archivo}}">
			            				<i class="fa fa-eye fa-4"></i>&nbsp;Ver
			            			</a>
		  						</div>
  							</div>
						</div>
					</div>
		            	
		            	
		            	
		                <!-- <div class="col-md-4">
		                    <div class="panel-fondo panel-default ">
		                        <div class="panel-body bmd-card-image">
		                            <div class="flex-video widescreen" style="margin: 0 auto;text-align:center;" data-ng-init="videoarchivo.tipoArchivo = 'V'">
		                            	<a data-ng-repeat="video in consultaCtrl.archivosExperiencia | filter : videoarchivo" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{video.archivo}}">
				            				<i class="fa fa-eye"></i>&nbsp;Ver
				            			</a> 
				            			<iframe data-ng-repeat="video in consultaCtrl.archivosExperiencia | filter : videoarchivo" src="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{video.archivo}}" frameborder="0">
		                            	</iframe>
		                               
		                            </div>
		                            <figcaption class="bmd-card-caption text-center">
		                                <h3>Video</h3>
		                            </figcaption>
		                        </div>
		                    </div>
		                </div> 
		                <div class="col-md-4">
		                    <div class="panel-fondo panel-default-contorno">
		                        <div class="panel-body bmd-card-image">
		                            <div class="flex-video widescreen" style="margin: 0 auto;text-align:center;" data-ng-init="audiovisualarchivo.tipoArchivo = 'A'">
		                                <a data-ng-repeat="audiovisual in consultaCtrl.archivosExperiencia | filter : audiovisualarchivo" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{audiovisual.archivo}}">
				            				<i class="fa fa-eye"></i>&nbsp;Ver
				            			</a>
		                            </div>
		                            <figcaption class="bmd-card-caption text-center">
		                                <h3>AudioVisual</h3>
		                            </figcaption>
		                        </div>
		                    </div>
		                </div> -->
		            <hr>
		            <div class="row">
		                <div class="col-md-12">
			            	<div class="text-center">
				                <h3>Galería de Fotos</h3><br/>
				            </div>

				            <div class="gal" data-ng-init="imagenarchivo.tipoArchivo = 'I'" >
				            	<a data-ng-repeat="imagen in consultaCtrl.archivosExperiencia | filter : imagenarchivo" class="fancybox" rel="group" href="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{imagen.archivo}}">
				            		<img data-ng-src="../api/v1/file/download/{{consultaCtrl.experiencia.inscripcionId | tipo : consultaCtrl.instituciones : 'inscripcionId' : 'RUC'}}/{{consultaCtrl.experiencia.inscripcionExperienciaId}}/{{imagen.archivo}}" alt="" height="130px" width="200px">
				            	</a>
				            </div>
		            	</div>
		            </div>
		            <hr style="margin-top: 0px" />				

				</div>

			</div>
		</div>
	</div><!--/ Modal  -->
	

</div>

<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">


  

		