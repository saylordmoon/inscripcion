var app = angular.module('main',['ngRoute'])

.constant("APP", 
		{
		    "URL"		: "/experienciasexitosas/",
		    "URL_API"	: "/experienciasexitosas/api/v1/",
		    "URL_LOGIN"	: "/experienciasexitosas/login",
		}
)

.constant("DATE", 
		{
		    "FORMAT"		: "dd/MM/yyyy",
		    "FORMAT_MOMENT"	: "DD/MM/YYYY",    
		}
)