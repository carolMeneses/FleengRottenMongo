/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//módulo provisto (apimock.js)
apimock=(function(){
   

	var mockdata;
        var nombreJuegoRepetido;
        var nombre;

	mockdata=["Evangeline","Jessy","Carol","Jose","Jhonatan"];
        nombreJuegoRepetido=["Pepitas","Colores","Paul","Dante","Jhonatan"];

	return {
		getUsuarios:function(){
			
				return mockdata;
		
		},
                getJuego:function(){
			
				return nombreJuegoRepetido;
		
		}

		
	};	

})();




