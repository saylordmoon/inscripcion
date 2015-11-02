var app = angular.module('main',['ngRoute'])

.constant("APP", 
		{
		    "URL"		: "/inscripcion/",
		    "URL_API"	: "/inscripcion/api/v1/",
		    "URL_LOGIN"	: "/inscripcion/admin/index.html",    
		}
)

.constant("DATE", 
		{
		    "FORMAT"		: "dd/MM/yyyy",
		    "FORMAT_MOMENT"	: "DD/MM/YYYY",    
		}
)