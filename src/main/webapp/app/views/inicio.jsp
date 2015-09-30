<script type="text/javascript">
            $(document).ready(function () {                
                $('#datePickerinicio')
                .datepicker({
                    format: 'dd/mm/yyyy'
                }); 
               
               $('#datePickerfin')
                .datepicker({
                    format: 'dd/mm/yyyy'
                });
               
            });
            
   </script>

<div class="row" data-ng-controller="ExperienciaController as expCtrl">
	<div class="col-md-12">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h5>Experiencias registradas</h5>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="col-md-1">Nº</th>
								<th class="col-md-9">Experiencia</th>
								<th class="col-md-2"></th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="experiencia in expCtrl.experiencias">
								<td>{{$index+1}}</td>
								<td>{{experiencia.titulo}}</td>
								<td>
									<span data-ng-show="experiencia.registrada" class="btn btn-info bmd-bg-blue-800 bmd-text-blue-50 bmd-ripple">
										<i class="fa fa-check"></i>
										Registrada
									</span>
									<button data-ng-click="expCtrl.registrarExperiencia(experiencia)" data-ng-hide="experiencia.registrada" class="btn btn-info bmd-ripple">
										<i class="fa fa-folder-open"></i>
										Presentar experiencia
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
	<div class="modal modal-info fade modal-registrar-experiencia" role="dialog" >
		<div class="modal-dialog modal-lg bmd-modal-dialog">
			<div class="modal-content">
				<div class="modal-header bmd-bg-info bmd-text-blue-50">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Presentación de la experiencia</h4>
				</div>
				<div id="form-experiencia" class="modal-body">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label>Fecha Inicio de la Experiencia</label>
								<div class="input-group input-append date" id="datePickerinicio">
					                <input type="text" data-ng-model="expCtrl.experiencia.fechaInicio" class="form-control fecha" placeholder="Fecha Inicio"/>
					                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					            </div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label>Fecha Fin de la Experiencia</label>
								<div class="input-group input-append date" id="datePickerfin">
					                <input type="text" class="form-control" data-ng-model="expCtrl.experiencia.fechaFin"  class="form-control fecha" placeholder="Fecha Fin"/>
					                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					            </div>
							</div>
						</div>
					</div>
					<div class="row">
					<div class="col-md-12">
						<div class="form-group" id="txt-sumilla">
							<label>Sumilla: </label>
							<textarea data-ng-model="expCtrl.experiencia.sumilla" class="form-control" rows="4" placeholder="en máximo 150 palabras describa lo esencial de la experiencia que postula, que la hace exitosa." required></textarea>
						</div>
						</div>
					</div>
					<hr style="margin-top: 0px" />

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<button class="btn btn-default bmd-ripple">
									<i class="fa fa-plus-square-o"></i>
									Departamento
								</button>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<button class="btn btn-default bmd-ripple">
									<i class="fa fa-plus-square-o"></i>
									Provincia
								</button>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<button class="btn btn-default bmd-ripple">
									<i class="fa fa-plus-square-o"></i>
									Distrito
								</button>
							</div>
						</div>						
					</div>
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="col-md-1">Nº</th>
										<th class="col-md-4">Departamento</th>
										<th class="col-md-3">Provincia</th>
										<th class="col-md-3">Distrito</th>
										<th class="col-md-1"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>{{$index+1}}</td>
										<td></td>
										<td></td>
										<td></td>
										<td>
											<button class="btn btn-default btn-sm pull-right bmd-ripple">
												<i class="glyphicon glyphicon-trash"></i>
											</button>
											
											<!-- <button class="btn btn-info bmd-ripple">
												<i class="fa fa-folder-open"></i>
												Agregar
											</button> -->
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						
						<!-- <div class="col-md-4">
							<div class="form-group">
								<label>Departamento:</label>
								<select class="form-control">
									<option>Departamento</option>
								</select>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label>Provincia:</label>
								<select class="form-control">
									<option>Provincia</option>
								</select>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label>Distrito:</label>
								<select class="form-control">
									<option>Distrito</option>
								</select>
							</div>
						</div> -->
					
					<div class="row">
						<div class="col-md-12">
							<label>La población que intervino en la experiencia es del ámbito:</label>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="radio">
								<label>
									<input data-ng-model="expCtrl.experiencia.ambito" type="radio" name="opciones" id="opciones_1" value="U" checked>
									Urbano
								</label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="radio">
								<label>
									<input data-ng-model="expCtrl.experiencia.ambito" type="radio" name="opciones" id="opciones_2" value="R">
									Rural
								</label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="radio">
								<label>
									<input data-ng-model="expCtrl.experiencia.ambito" type="radio" name="opciones" id="opciones_3" value="A">
									Ambos
								</label>
							</div>
						</div>
					</div>
					
					<hr style="margin-top: 0px" />

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>1. Descargar y completar el formato: </label>
								<br />
								<a href="archivos/Formato2.doc" download>
									<i class="fa  fa-file-pdf-o"></i>
									Formato
								</a>
							</div>
						</div>
						<div class="col-md-6" >
							<div class="form-group">
								<a id="formato-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<label class="control-label">2. Subir formato</label>
								<input id="formato" name="uploadFile" type="file" class="file" accept=".doc,.docx" aria-describedby="inputSuccess3Status" />
      						</div>
						</div>
					</div>

					<hr style="margin-top: 0px" />

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<a id="documento-adicional-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<label class="control-label">Documento con información adicional (No mayor a 5 paginas)</label>
								<input id="documento-adicional" name="uploadFile" type="file" class="file" accept=".doc,.docx,*.pdf" >
							</div>
						</div>
					</div>

					<hr style="margin-top: 0px" />
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">
									<i class="fa fa-desktop"></i>
									Audiovisual (Máximo 90 segundos)
								</label>
								<a id="audio-visual-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<input id="audio-visual" name="uploadFile" type="file" class="file" accept="audio/mp3,audio/wav">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<a id="video-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<label class="control-label">
									<i class="fa fa-video-camera"></i>
									Video (Máximo 3 minutos)
								</label>
								<input id="video" name="uploadFile" type="file" class="file" accept="video/avi,video/mpg,video/mpeg,video/mp4">
							</div>
						</div>
					</div>

					<hr style="margin-top: 0px" />
					
					<div class="row">	                        
						<div class="col-md-12">
							<div class="form-group">
								<label>
									<i class="fa fa-picture-o"></i>
									Fotografias (Maximo 10)
								</label>
								<div class="row">
									<div class="col-md-6">
										<a id="imagen1-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen1" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg">

										<a id="imagen2-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen2" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg">
										
										<a id="imagen3-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen3" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg">

										<a id="imagen4-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen4" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg">

										<a id="imagen5-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen5" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg">
									</div>
									<div class="col-md-6">
										<a id="imagen6-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"><i class="fa fa-check"></i>/a>
										<input id="imagen6" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg" />

										<a id="imagen7-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen7" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg" />

										<a id="imagen8-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen8" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg" />
										
										<a id="imagen9-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen9" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg" />

										<a id="imagen10-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen10" name="uploadFile" type="file" class="file" accept="image/jpg,image/png,image/jpeg" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

				<div class="modal-footer">
					<button data-ng-click="expCtrl.guardar()" class="btn btn-info bmd-ripple bmd-floating">
						<i class="fa fa-save"></i>
						Registrar
					</button>
				</div>
			</div>
		</div>
	</div><!--/ Modal  -->

</div>

<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">

		