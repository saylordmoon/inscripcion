var app = angular.module('main',[])

.constant("APP", 
		{
		    "URL"		: "/inscripcion/",
		    "URL_API"	: "/inscripcion/api/v1/",
		    "URL_LOGIN"	: "/inscripcion/login",
		}
)

.constant("DATE", 
		{
		    "FORMAT"		: "dd/MM/yyyy",
		    "FORMAT_MOMENT"	: "DD/MM/YYYY",    
		}
)