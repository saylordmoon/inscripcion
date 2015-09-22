angular.module("main").service("Utils", function($filter,TabService, NotificationService , ValidationService,MaskService, $http){

	this.Mask = MaskService;
	
	this.Validation = ValidationService;

	this.Notification = NotificationService;

	this.List =		{
						'delete' : 			function(item,list)  { 
												var index = list.indexOf(item);
												list.splice(index,1);
											},

						deleteAllWhere: 	function(value,fieldName,list) {
												for (var i = list.length - 1; i >= 0; i--) 
													if (list[i][fieldName] == value)
														list.splice(i,1);
											}
	};

	this.UI = 		{
						Tab: TabService,

						Select :  	{
										getSelectedText : 	function(controlId) {
																var valor = $("#" + controlId + " option:selected").text();
																if (valor) return S($("#" + controlId + " option:selected").text()).trim().s;
																return "";
															},
										getSelectedAttr :   function(controlId, attributo) {
																var valor = $("#" + controlId + " option:selected").attr(attributo);
																if (valor) return S(valor).trim().s;
																return "";
															},
										clearBlank		: 	function(controlId){
																var control = $("#" + controlId);
																control.children("option[value='? string:1 ?']").remove();
																control.children("option[value='']").remove();
																control.change();
															}


									},
						Control	:   {
										getAttr :   function(controlId, attributo) {
																var valor = $("#" + controlId).attr(attributo);
																if (valor) return S(valor).trim().s;
																return "";
															},
										setAttr :   function(controlId, attributo , valor) {
																$("#" + controlId).attr(attributo,valor);
															}
									}
	};

	this.Date = 	{
						difference : 	function(date1,date2) {

											if ( date2 != undefined && date2 != "" && date1 != undefined && date2 != "" ) {
												date1 = moment( $filter('date')(date1, "dd/MM/yyyy") ,'DD/MM/YYYY');
												date2 = moment( $filter('date')(date2, "dd/MM/yyyy") ,'DD/MM/YYYY');
												return  moment.preciseDiff( date1 , date2 );
											}
											return "";
										},
						toDate: 		function(stringDate) {
											return moment($filter('date')(stringDate, "dd/MM/yyyy"),'DD/MM/YYYY').toDate();
										}
	};

	this.Rest = 	{	
						getList  :  function(self, resource, listName) {

										return $http.get(resource).success(function(data){
											self[listName] = data;
										}); 
									},
						getGroupList : 	function(groupData,prefix){
											for (var i = groupData.length - 1; i >= 0; i--) {
												var tipoGeneralId = groupData[i].tipoGeneralId;
												$http.get("/replop/api/v1/tipogeneral/" + groupData[i].tipoGeneralId + "/tipo" ).success( (function(tipoGeneralId){

													return function(optionData) {
														for (var i = optionData.length - 1; i >= 0; i--) {
															$("#"+ prefix + tipoGeneralId ).append("<option value="+ optionData[i].tipoGeneralId +">" + optionData[i].descripcion + "</option>")
														};
													}
												})(tipoGeneralId) );
											};
										},
						save	: 	function(resource,dataPost) {

										return $http.post(resource, JSON.stringify(dataPost)).success(function(data){
											console.log("saved ", data);
										});

									}

	};
	
});