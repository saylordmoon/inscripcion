var app = angular.module('main',[])

.constant("APP", 
		{
		    "URL"		: "/experienciasexitosas-ongd/",
		    "URL_API"	: "/experienciasexitosas-ongd/api/v1/",
		    "URL_LOGIN"	: "/experienciasexitosas-ongd/login",
		}
)

.constant("DATE", 
		{
		    "FORMAT"		: "dd/MM/yyyy",
		    "FORMAT_MOMENT"	: "DD/MM/YYYY",    
		}
)