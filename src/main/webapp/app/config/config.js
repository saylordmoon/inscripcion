angular.module("main").config(['$routeProvider',function($routeProvider){

	$routeProvider.

		when('/', 			{ templateUrl: 'views/inicio.jsp' 	}).

		otherwise({	redirectTo: '/'	});

}]);