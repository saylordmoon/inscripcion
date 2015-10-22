angular.module("main").filter("ambito",function($filter){
	
	return function(input) {
				
		if (input == 'A' || input == 'a' )
			return "Rural / Urbano";
		else if (input == 'R' || input == 'r')
			return "Rural";
		else if (input == 'U' || input == 'u')
			return "Urbano";
		else
			return "";
	}
});