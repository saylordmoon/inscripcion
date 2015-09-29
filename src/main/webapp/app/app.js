var app = angular.module('main',['ngRoute'])

.constant("APP", 
		{
		    "URL"		: "/inscripcion/",
		    "URL_API"	: "/inscripcion/api/v1/",    
		}
)

.constant("DATE", 
		{
		    "FORMAT"		: "dd/MM/yyyy",
		    "FORMAT_MOMENT"	: "DD/MM/YYYY",    
		}
)
