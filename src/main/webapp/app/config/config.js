angular.module("main").config(['$routeProvider',function($routeProvider){

	$routeProvider.

		when('/', 			{ templateUrl: 'views/inicio.jsp' 	}).
		when('/', 			{ templateUrl: 'views/inicio_consulta.jsp' 	}).

		otherwise({	redirectTo: '/'	});

}]);