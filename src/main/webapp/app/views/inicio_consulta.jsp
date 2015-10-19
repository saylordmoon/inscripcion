

<div class="row" data-ng-controller="ExperienciaController as expCtrl">
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
								<th class="col-md-9">Experiencia</th>
								<th class="col-md-2"></th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="experiencia in expCtrl.experiencias">
								<td>{{$index+1}}</td>
								<td>{{experiencia.titulo}}</td>
								<td>
									<button data-ng-click="expCtrl.mostrarExperiencia(experiencia)" class="btn btn-info bmd-ripple">
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
		                        <textarea id="txt-titulo" class="form-control" rows="4" readonly>{{expCtrl.experiencia.titulo}}</textarea>
		                    </div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label>Ubicación de la experiencia:</label>
		                        <input id="txt-ubicacion" type="text" class="form-control" value="{{expCtrl.experiencia.ubigeo}}" readonly/>
		                    </div>
		                </div>
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label>La población que intervino en la experiencia es del ámbito:</label>
		                        <input id="txt-ambito" type="text" class="form-control" value="{{expCtrl.experiencia.ambito}}" readonly/>
		                    </div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label><i class="glyphicon glyphicon-calendar"></i> Fecha Inicio de la Intervención:</label>
		                        <input id="dat-fecha-inicio" type="text" class="form-control" value="{{expCtrl.experiencia.fechaInicio}}" readonly/>
		                    </div>
		                </div>
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label><i class="glyphicon glyphicon-calendar"></i> Fecha Fin de la Intervención:</label>
		                        <input id="dat-fecha-fin" type="text" class="form-control fecha" value="{{expCtrl.experiencia.fechaFin}}" readonly/>
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
		                                    <div class="col-sm-6">
		                                        <input id="txt-formato" type="text" class="form-control" value="{{expCtrl.archivoExperiencia.archivo}}" readonly/>
		                                    </div>
		                                    <div class="col-sm-3 pull-left">
		                                        <a href="#" class="btn btn-primary bmd-ripple" style="margin-top:0px;"><i class="fa fa-file"></i>&nbsp;Formato</a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        <div class="col-md-12">
		                            <div class="form-horizontal">
		                                <div class="form-group">
		                                    <label class="col-sm-3">Formato Adicional:</label>
		                                    <div class="col-sm-6">
		                                        <input id="txt-formato-adicional" type="text" class="form-control" value="{{expCtrl.archivoExperiencia.archivo}}" readonly/>
		                                    </div>
		                                    <div class="col-sm-3 pull-left">
		                                        <a href="#" class="btn btn-primary bmd-ripple" style="margin-top:0px;"><i class="fa fa-file"></i>&nbsp;Formato Adicional</a>
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
		                    <div class="panel-fondo panel-default ">
		                        <div class="panel-body bmd-card-image">
		                            <div class="flex-video widescreen" style="margin: 0 auto;text-align:center;">
		                                <iframe allowfullscreen="" src="https://www.youtube.com/embed/6NbAAmDuv_8?feature=player_detailpage%22" frameborder="0"></iframe>
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
		                            <div class="flex-video widescreen" style="margin: 0 auto;text-align:center;">
		                                <iframe allowfullscreen="" src="" frameborder="0"></iframe>
		                            </div>
		                            <figcaption class="bmd-card-caption text-center">
		                                <h3>AudioVisual</h3>
		                            </figcaption>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <hr>
		            <div class="row">
		                <div class="col-md-12">
			            	<div class="text-center">
				                <h3>Galería de Fotos</h3><br/>
				            </div>
				            <div class="gal">  
				                <a class="fancybox" rel="group" href="demo/img1.jpg" title="Imagen 01"><img src="demo/img1s.jpg" alt=""></a>
				            	<a class="fancybox" rel="group" href="demo/img2.jpg" title="Imagen 02"><img src="demo/img2s.jpg" alt=""></a>
				            	<a class="fancybox" rel="group" href="demo/img3.jpg" title="Imagen 03"><img src="demo/img3s.jpg" alt=""></a>
				            	<a class="fancybox" rel="group" href="demo/img4.jpg" title="Imagen 04"><img src="demo/img4s.jpg" alt=""></a><br />
				                <a class="fancybox" rel="group" href="demo/img1.jpg" title="Imagen 05"><img src="demo/img1s.jpg" alt=""></a>
				                <a class="fancybox" rel="group" href="demo/img2.jpg" title="Imagen 06"><img src="demo/img2s.jpg" alt=""></a>
				                <a class="fancybox" rel="group" href="demo/img3.jpg" title="Imagen 07"><img src="demo/img3s.jpg" alt=""></a>
				                <a class="fancybox" rel="group" href="demo/img4.jpg" title="Imagen 08"><img src="demo/img4s.jpg" alt=""></a><br />
				                <a class="fancybox" rel="group" href="demo/img1.jpg" title="Imagen 09"><img src="demo/img1s.jpg" alt=""></a>
				                <a class="fancybox" rel="group" href="demo/img2.jpg" title="Imagen 10"><img src="demo/img2s.jpg" alt=""></a>
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


  

		