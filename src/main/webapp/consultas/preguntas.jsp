<div  data-ng-controller="PreguntaController as preguntaCtrl">    
	<div align="left">
		<h3>Haga su Pregunta</h3>
		<hr />	
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-md-1 control-label">
				Nombres:
			</label>
			<div class="col-md-11">
				<input data-ng-model="preguntaCtrl.pregunta.nombres" type="text" class="form-control" id="txt-nombres" placeholder="Nombres" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-1 control-label">
				Institución:
			</label>
			<div class="col-md-11">
				<input data-ng-model="preguntaCtrl.pregunta.institucion" type="text" class="form-control" id="txt-institucion" placeholder="Institución" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-1 control-label">
				Pregunta:
			</label>
			<div class="col-md-11">
				<textarea data-ng-model="preguntaCtrl.pregunta.texto" class="form-control" rows="5" id="txt-texto" placeholder="Preguntas" ></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-1 col-md-11">
				<button data-ng-click="preguntaCtrl.enviarPregunta()" class="btn btn-apci">
					Enviar <i class="glyphicon glyphicon glyphicon-send"></i>
				</button>
			</div>
		</div>
	</form>
	<br />
	<div align="left">
		<h3>Preguntas Frecuentes</h3>
		<hr class="style-two" />
	</div>
	<div data-ng-repeat="pregunta in preguntaCtrl.preguntas" class="panel panel-default" style="margin-bottom:auto;margin-top:3px;">
		 <div class="panel-heading">		  
		  <a style="text-decoration:none; font-weight: bold; text-align:justify;" data-ng-click="collapsed=!collapsed" data-ng-value="Collapse" >
		  		<span class="pull-right">
                   <i class="glyphicon glyphicon-menu-down"></i>
               </span>               
              {{pregunta.texto}}
		  </a>
		 </div>
		 <div data-ng-show="collapsed" class="panel-body" >
		  	<h5 style="font-weight: bold; text-align:justify;">{{pregunta.respuesta}}</h5>
		 </div>
	</div>	
	
<!-- 	<hr class="style-two"/>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 style="font-weight: bold; margin-top: 5px; margin-bottom: 5px;" class="panel-title">Preguntas Frecuentes</h4>
		</div>	
		<div class="panel-body">
			<div class="row">
				<div class="col-md-12">
					<div data-ng-repeat="pregunta in preguntaCtrl.preguntas" class="panel panel-default" >
						 <div class="panel-heading">		  
						  <a style="text-decoration:none; font-weight: bold; text-align:justify;" data-ng-click="collapsed=!collapsed" data-ng-value="Collapse" >
						  		<span class="pull-right">
				                   <i class="glyphicon glyphicon-menu-down"></i>
				               </span>               
				              {{pregunta.texto}}
						  </a>
						 </div>
						 <div data-ng-show="collapsed" class="panel-body" >
						  	<h5 style="font-weight: bold; text-align:justify;">{{pregunta.respuesta}}</h5>
						 </div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	
	

	
	<!-- 	<div>
		<div data-ng-repeat="pregunta in preguntaCtrl.preguntas">
			<div class="bs-callout bs-callout-info">
				<h4 style="font-weight: bold;">{{ ::pregunta.quienPregunta }}</h4>
				<p style="font-weight: bold;">{{ ::pregunta.texto }}</p>
				<div class="bs-callout bs-callout-warning" id="callout-navbar-breakpoint">				
					<p>{{ ::pregunta.respuesta }}</p>
				</div>
			</div>
		</div>
	</div> -->	
</div>