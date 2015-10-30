
<div class="row" data-ng-controller="ExperienciaController as expCtrl">
	<div class="col-md-12">

		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="" class="btn btn-info bmd-ripple bmd-floating pull-right" data-ng-click="expCtrl.agregarExperiencia()">
					<i class="fa fa-plus"></i>
					Agregar nueva  experiencia
				</a>
				<h5>Experiencias Inscritas</h5>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="col-md-1">Nº</th>
								<th class="col-md-9">Experiencia</th>
								<th class="col-md-9">Tematica</th>
								<th class="col-md-2"></th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="experiencia in expCtrl.experiencias">
								<td>{{$index+1}}</td>
								<td>{{experiencia.titulo}}</td>
								<td>{{experiencia.tematicaId | tipo: expCtrl.tematicas : "inscripcionTematicaId" : "descripcion" }}</td>
								<td>
									<span data-ng-show="experiencia.registrada" class="btn btn-success bmd-text-green-50 bmd-ripple">
										<i class="fa fa-check"></i>
										Experiencia Registrada
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
						<div class="col-md-12">
							<h3>{{expCtrl.experiencia.titulo}}</h3>
						</div>
					</div>
					
					<hr style="margin-top: 0px" />
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label><i class="glyphicon glyphicon-calendar"></i> Fecha Inicio de la Intervención:</label>
								<input id="dat-fecha-inicio" type="text" data-ng-model="expCtrl.experiencia.fechaInicio" class="form-control" data-provide="datepicker" data-date-format="dd/mm/yyyy" data-date-language="es" placeholder="dd/mm/aaaa" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label><i class="glyphicon glyphicon-calendar"></i> Fecha Fin de la Intervención:</label>
				                <input id="dat-fecha-fin" type="text" data-ng-model="expCtrl.experiencia.fechaFin" class="form-control fecha" data-provide="datepicker" data-date-format="dd/mm/yyyy" data-date-language="es" placeholder="dd/mm/aaaa" />
							</div>
						</div>
					</div>
					<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Sumilla: </label>
							<textarea id="txt-sumilla" data-ng-model="expCtrl.experiencia.sumilla" class="form-control" rows="4" placeholder="en máximo 150 palabras describa lo esencial de la experiencia que postula, que la hace exitosa." required></textarea>
						</div>
						</div>
					</div>
														
					<div class="row">
						<div class="col-md-12">

							<div class="panel panel-default">
								<div class="panel-heading">
									<h5>Ubicacion de la experiencia</h5>
								</div>
								<div id="panel-ubicacion" class="panel-body">
									<div class="row">
										<div class="col-md-3">
											<div class="form-group">
												<label>Departamento:</label>
												<select id="sel-departamento" class="form-control" data-ng-model="expCtrl.ambito.departamento" data-ng-change="expCtrl.departamentoSelected()" data-ng-init="expCtrl.ambito.departamento=''">
													<option data-ng-repeat="departamento in expCtrl.departamentos" data-id="{{departamento.departamentoId}}" value="{{departamento.nombre}}">{{departamento.nombre}}</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>Provincia:</label>
												<select id="sel-provincia" class="form-control" data-ng-model="expCtrl.ambito.provincia" data-ng-change="expCtrl.provinciaSelected()">
													<option data-ng-repeat="provincia in expCtrl.provincias" data-id="{{provincia.provinciaId}}" value="{{provincia.nombre}}">{{provincia.nombre}}</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>Distrito:</label>
												<select id="sel-distrito" class="form-control" data-ng-model="expCtrl.ambito.distrito">
													<option data-ng-repeat="distrito in expCtrl.distritos" data-id="{{distrito.distritoId}}" value="{{distrito.nombre}}">{{distrito.nombre}}</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<br />
											<button class="btn btn-default bmd-ripple" data-ng-click="expCtrl.agregarAmbito()">
												<i class="fa fa-plus"></i>
												Agregar
											</button>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-md-11" style="margin-left: 15px;">
										<div class="table-responsive bmd-ripple">
											<table class="table table-bordered table-condensed">
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
													<tr data-ng-repeat="ambito in expCtrl.ambitos">
														<td>{{$index+1}}</td>
														<td>{{ambito.departamento}}</td>
														<td>{{ambito.provincia}}</td>
														<td>{{ambito.distrito}}</td>
														<td>
															<button class="btn btn-default btn-sm pull-right bmd-ripple" data-ng-click="expCtrl.borrarAmbito(ambito)">
																<i class="glyphicon glyphicon-trash"></i>
															</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">La población que intervino en la experiencia es del ámbito:</label>
								<select id="sel-ambito" data-ng-model="expCtrl.experiencia.ambito" class="form-control">
									<option value="U">Urbano</option>
									<option value="R">Rural</option>
									<option value="A">Urbano / Rural</option>
								</select>
							</div>
							
						</div>
					</div>
								
					<hr style="margin-top: 0px" />

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>1. Descargar y completar el formato: </label>
								<br />
								<a href="../archivos/Formato2.docx" download>
									<i class="fa  fa-file-pdf-o"></i>
									Formato
								</a>
							</div>
						</div>
						<div class="col-md-6" >
							<div class="form-group">
								<a id="formato-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<label class="control-label">2. Subir formato</label>
								<input id="formato" name="uploadFile" type="file" class="file" data-tipo="F" />
      						</div>
						</div>
					</div>

					<hr style="margin-top: 0px" />

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<a id="documento-adicional-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<label class="control-label">Documento con información adicional (No mayor a 5 paginas)</label>
								<input id="documento-adicional" name="uploadFile" type="file" class="file" data-tipo="D" />
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
								<input id="audio-visual" name="uploadFile" type="file" class="file" data-tipo="A" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<a id="video-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i> </a>
								<label class="control-label">
									<i class="fa fa-video-camera"></i>
									Video (Máximo 3 minutos)
								</label>
								<input id="video" name="uploadFile" type="file" class="file" data-tipo="V" />
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
										<input id="imagen1" name="uploadFile" type="file" class="file" data-tipo="I" />

										<a id="imagen2-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen2" name="uploadFile" type="file" class="file" data-tipo="I" />
										
										<a id="imagen3-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen3" name="uploadFile" type="file" class="file" data-tipo="I"  />

										<a id="imagen4-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen4" name="uploadFile" type="file" class="file" data-tipo="I" />

										<a id="imagen5-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen5" name="uploadFile" type="file" class="file" data-tipo="I" />
									</div>
									<div class="col-md-6">
										<a id="imagen6-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"><i class="fa fa-check"></i></a>
										<input id="imagen6" name="uploadFile" type="file" class="file" data-tipo="I" />

										<a id="imagen7-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen7" name="uploadFile" type="file" class="file" data-tipo="I" />

										<a id="imagen8-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen8" name="uploadFile" type="file" class="file" data-tipo="I" />
										
										<a id="imagen9-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen9" name="uploadFile" type="file" class="file" data-tipo="I" />

										<a id="imagen10-ok" href="#" class="btn btn-info btn-xs pull-right bmd-floating bmd-ripple" style="display:none;"> <i class="fa fa-check"></i></a>
										<input id="imagen10" name="uploadFile" type="file" class="file" data-tipo="I" />
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
	
	<!-- Modal  -->
	<div class="modal fade modal-confirmacion-experiencia" role="dialog" >
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header bmd-text-blue-50 bmd-bg-info">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title ">Finalizar Registro de Experiencia</h4>
				</div>
				<div class="modal-body">
					 <p style="font-size: 15px;"> Verifique y valide su información. Una vez finalizado el registro no podrá realizar modificaciones.</p>
				</div>
				<div class="modal-footer">
					<button class="btn btn-info bmd-ripple bmd-floating" data-ng-click="expCtrl.confirmarRegistroExperiencia()"><i class="fa fa-check"></i> Aceptar</button>
					<button class="btn bmd-text-red-50 bmd-bg-red-300 bmd-ripple bmd-floating" data-dismiss="modal" aria-label="Close" ><i class="fa fa-times"></i> Cancelar y continuar con el registro</button>
				</div>
			</div>
		</div>
	</div><!--/ Modal  -->

	<!-- Modal datos de la experiencia que se postula -->
	<div class="modal fade modal-datos-experiencia" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Datos de la experiencia que se postula</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Título de la Experiencia</label>
						<textarea id="txt-titulo-experiencia" data-ng-model="expCtrl.inscripcionexperiencia.titulo" class="form-control" rows="3"></textarea>
					</div>
					<div class="form-group">
						<label>Temática</label>
						<select id="sel-tematica-experiencia" class="form-control" data-ng-model="expCtrl.inscripcionexperiencia.tematicaId" data-ng-init="expCtrl.experiencia.tematicaId='1'">
							<option data-ng-repeat="tematica in expCtrl.tematicas" value="{{tematica.inscripcionTematicaId}}">{{tematica.descripcion}}</option>								
						</select>
					</div>
					<div class="form-group">
						<label>Intervención</label>
						<input data-ng-model="expCtrl.inscripcionexperiencia.intervencion" id="txt-intervencion" class="form-control" data-ng-change="expCtrl.buscarIntervencion()" />
						<ul data-ng-show="expCtrl.autocomplete" class="nav nav-pills nav-stacked bmd-nav-pills-default bmd-floating">
							<li data-ng-repeat="intervencion in expCtrl.intervenciones | filter:expCtrl.experiencia.intervencion"><a href="" data-ng-click="expCtrl.autocompleteSelected(intervencion.nombre)"  class="bmd-ripple">{{intervencion.nombre}}</a></li>
						</ul>
					</div>
					
				</div>
				<div class="modal-footer">
					<button class="btn btn-info bmd-floating bmd-ripple" data-ng-click="expCtrl.guardarNuevaExperiencia()">
						<i class="glyphicon glyphicon-save"></i>
						Guardar
					</button>
				</div>
			</div>
		</div>
	</div><!--/ Modal datos de la experiencia que se postula  -->

</div>



		