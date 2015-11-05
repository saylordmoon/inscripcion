var app = angular.module('main',['ngRoute'])

.constant("APP", 
		{
		    "URL"		: "/experienciasexitosas-ongd/",
		    "URL_API"	: "/experienciasexitosas-ongd/api/v1/",
		    "URL_LOGIN"	: "/experienciasexitosas-ongd/admin/index.html",    
		}
)

.constant("DATE", 
		{
		    "FORMAT"		: "dd/MM/yyyy",
		    "FORMAT_MOMENT"	: "DD/MM/YYYY",    
		}
)