angular.module("main").config(['$routeProvider',function($routeProvider){

	$routeProvider.

		when('/', 	{ templateUrl: 'views/registroexperiencia.jsp' 	}).
		
		otherwise({	redirectTo: '/'	});

}]);