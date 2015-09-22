angular.module("main").config(['$routeProvider',function($routeProvider){

	$routeProvider.

		when('/', 			{ templateUrl: 'app/views/inicio.html' 	}).

		otherwise({	redirectTo: '/'	});

}]);