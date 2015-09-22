angular.module("main").service("MaskService",function(){

	this.init = function(){
		
		$(".fecha").inputmask("99/99/9999",{placeholder: "dd/mm/aaaa"});
		$(".moneda").inputmask("decimal", { digits: 2, autoGroup: true, groupSize: 3, groupSeparator: ",",autoUnmask:true  });
		$(".numero").inputmask("integer", { autoUnmask:true });
		
		$(".sel-multiple").select2();
	}
	
});