/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//módulo provisto (apimock.js)
apimock=(function(){

	var mockdata=[];

	mockdata["johnconnor"]=	[{author:"johnconnor","points":[{"x":150,"y":120},{"x":215,"y":115},{"x":105,"y":235}],"name":"house"},
	 {author:"johnconnor","points":[{"x":340,"y":240},{"x":15,"y":215}],"name":"gear"},{author:"johnconnor","points":[{"x":300,"y":241},{"x":10,"y":210}],"name":"carro"}];
	mockdata["maryweyland"]=[{author:"maryweyland","points":[{"x":140,"y":140},{"x":115,"y":115}],"name":"gear2"},{author:"johnconnor","points":[{"x":380,"y":220},{"x":15,"y":210}],"name":"gato"}];


	return {
		getBlueprintsByAuthor:function(authname,callback){
			callback(
				mockdata[authname]
			);
		},

		getBlueprintsByNameAndAuthor:function(authname,bpname,callback){ 

			callback(
				mockdata[authname].find(function(e){return e.name===bpname})
			);
		}
	}	

})();