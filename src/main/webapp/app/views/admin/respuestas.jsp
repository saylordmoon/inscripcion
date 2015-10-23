<div align="left">
    <h3>Administración de Consultas</h3>
	<hr class="style-two" />
</div>
<div data-ng-controller="RespuestaController as rptaCtrl">
	<div class="row">
		<div class="col-md-12">
			<ul class="list-group">
				<li data-ng-repeat="pregunta in rptaCtrl.preguntas" class="list-group-item" style="border:0px;padding: 3px 15px;">	
					<div class="bs-callout bs-callout-default">
						<span class="pull-right">
							<strong data-ng-hide="pregunta.publicada">No</strong> 
							Publicada
							<a href="" data-ng-click="rptaCtrl.publicar(pregunta)" class="btn btn-default bmd-fab bmd-ripple" >
								<i data-ng-show="pregunta.publicada" class="fa fa-thumbs-o-up fa-2x"></i>
								<i data-ng-hide="pregunta.publicada" class="fa fa-thumbs-o-down fa-2x"></i>
							</a>
						</span>
						<h4>{{pregunta.quienPregunta}}</h4>
						<p>{{pregunta.texto}}</p>
							<div class="bs-callout bs-callout-warning"> 
								<h5>{{pregunta.respuesta}}</h5>
							</div>	
						<button data-ng-click="rptaCtrl.responder(pregunta)" data-ng-hide="pregunta.publicada" class="btn btn-info bmd-ripple bmd-floating">
							<i class="fa fa-comment"></i>
							Responder
						</button>
					</div>
				</li>
			</ul>
		</div>	
	</div>

	<!-- Modal -->
	<div class="modal fade modal-respuesta" tabindex="-1" role="dialog" aria-labelledby="">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Respuesta</h4>
	      </div>
	      <div class="modal-body">
	    	 <div class="form-group">
	    	 	<label>Pregunta:</label>
	    	 	<textarea class="form-control" data-ng-model="rptaCtrl.pregunta.texto" rows="3"></textarea>
	    	 </div>
	    	 <div class="form-group">
	    	 	<label>Respuesta:</label>
	    	 	<textarea class="form-control" data-ng-model="rptaCtrl.pregunta.respuesta" rows="3"></textarea>
	    	 </div>
	    	 <div class="form-group">
	    	 	<input data-ng-model="rptaCtrl.pregunta.publicada" type="checkbox" /> Publicar
	    	 </div>
	      </div>
	      <div class="modal-footer">
	         <button data-ng-click="rptaCtrl.guardarRespuesta()" type="button" class="btn btn-info bmd-ripple bmd-floating">
	         	<i class="fa fa-save"></i>
	         	Responder
	         </button>
	      </div>
	    </div>
	  </div>
	</div>
</div>
<script type="text/javascript">
          $(".acordio").click(function(){
            var icon = $(this).children("span").children("i");
            if (icon.attr('class') == "glyphicon glyphicon-menu-up" )
               icon.attr("class","glyphicon glyphicon-menu-down");
            else
               icon.attr("class","glyphicon glyphicon-menu-up");
            $(this).collapse("toggle");
            console.log("pruebaa");
         }); 
</script> 