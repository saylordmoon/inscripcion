angular.module("main").config(['$routeProvider',function($routeProvider){

	$routeProvider.

		when('/', 	{ templateUrl: 'views/admin/experiencias.jsp' 	}).
		when('/respuesta', 	{ templateUrl: 'views/admin/respuestas.jsp' 	}).

		otherwise({	redirectTo: '/'	});

}]);