/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global apimock */
/* global apiclient */

var prueba;
var api = apiclient;
//CREAR MODULO
var module = (function () {
// code
    var nombre;
    var nom_pun;
    var listaAutor;
    var nombre_Plano;
    var nuevosPuntos;
    var autorblue;
    var nomb;
    var tamano;
 
    
    
//    var canvas = document.getElementById("canvas");
//    var canvas = document.getElementById("canvas");
//    var ctx = canvas.getContext("2d");
//    canvas.width = canvas.width;
//    ctx.fillStyle = "#0080FF";

    return{
        //function to initialize application
        init: function () {

            console.info('initialized');
            if (window.PointerEvent) {
                canvas.addEventListener("pointerdown",
                        function (event) {
                            var rect = canvas.getBoundingClientRect();
                            
                            alert('pointerdown at ' + event.pageX + ',' + event.pageY);
                            var x1=event.pageX-rect.left;
                            console.log(x1);
                            var x = {"x": event.pageX -rect.left, "y": event.pageY -rect.top};
                            if(nuevosPuntos==null) nuevosPuntos=x;
                            listaAutor.points.push(x);
                            
                            module.setDibujar1(autorblue, nomb);
                        });
            } else {
                canvas.addEventListener("mousedown", function (event) {
                    alert('mousedown at ' + event.clientX + ',' + event.clientY);
                }
                );
            }
        },
        setBlueprintsByName: function (authname) {
            nombre = authname;
        },
        setCrear:function(nomb,autorblue,puntos){
            
        },
        setActualizar: function (autor) {
            module.setBlueprintsByName(autor);
            api.getBlueprintsByAuthor(nombre, function (lista) {
                nom_pun = lista;
            
                if(lista.length==0){
                    alert("Autor no existe");
                    $(".temp").remove();
                
                }else{
                     $(".temp").remove();
                // listado de los planos, y le aplique una funciÃ³n 'map' convertir json
                var lista1 = nom_pun.map(function (blue) {
                    autorblue=blue.name;
                    return{"name": blue.name, "tamano": blue.points.length};
                }
                );
                //otro 'map', que tome cada uno de estos elementos, y a travÃ©s de jQuery agregue un elemento <tr> (con los respectvos <td>)
                var lista2 = lista1.map(function (valor) {
//                   

                    var boton = "<button type='button' onclick=\"module.setDibujar(\'" + nombre + "\',\'" + valor.name + "\')\">open </buttom>"
                    var delet = "<button type='button' onclick=\"module.deleite(\'" + nombre + "\',\'" + valor.name + "\')\">Delete </buttom>"
                    return "<tr  class='temp'><td id=''>" + valor.name + "</td><td>" + valor.tamano + "</td><td>" + boton +"</td><td>" + delet+ "</td></tr>";
                });
                // aplique un 'reduce' que calcule el nÃºmero de puntos. Con este valor, use jQuery para actualizar el campo correspondiente
                var adicion = lista1.reduce(function (valor, value) {
                    return valor + value.tamano;
                }
                );

                $(".temp").remove();
                $("table tbody").append(lista2);
//                $("Total de puntos").text(+ adicion);
            }
        }
            );
        },
        setDibujar: function (autor1, nombre1) {

            api.getBlueprintsByNameAndAuthor(autor1, nombre1, function (lista1) {

//            if (listaAutor == null&& autor1!=autorblue && nombre1!=nomb) {
                listaAutor = lista1;
                //  }
                prueba = lista1;
                autorblue = autor1;
                nomb = nombre1;
                var canvas = document.getElementById("canvas");
                ctx = canvas.getContext("2d");
                canvas.width = canvas.width;
                ctx.fillStyle = "#0080FF";
                for (i = 0; i < listaAutor.points.length - 1; i++) {
                    var x = listaAutor.points[i].x;
                    var y = listaAutor.points[i].y;
                    var x2 = listaAutor.points[i + 1].x;
                    var y2 = listaAutor.points[i + 1].y;
                    console.log(listaAutor.points[i].x);
                    ctx.moveTo(x, y);
                    ctx.lineTo(x2, y2);
                    ctx.stroke();
                }

            });
        },
        setDibujar1: function (autor1, nombre1) {

            // api.getBlueprintsByNameAndAuthor(autor1, nombre1, function (lista1) {
            autorblue = autor1;
            nomb = nombre1;
            var canvas = document.getElementById("canvas");
            ctx = canvas.getContext("2d");
            canvas.width = canvas.width;
            ctx.fillStyle = "#0080FF";
            for (i = 0; i < listaAutor.points.length - 1; i++) {
                var x = listaAutor.points[i].x;
                var y = listaAutor.points[i].y;
                var x2 = listaAutor.points[i + 1].x;
                var y2 = listaAutor.points[i + 1].y;
                console.log(listaAutor.points[i].x);
                ctx.moveTo(x, y);
                ctx.lineTo(x2, y2);
                ctx.stroke();
            }

        },
        save: function () {

            api.putActualiza(listaAutor, listaAutor.points, autorblue, nomb);
            module.setDibujar1(autorblue, nomb);
            module.setActualizar(autorblue);
            
          
      
    },
        deleite:function(){
            api.deleite(listaAutor);
            canvas.width = canvas.width;
            module.setActualizar(autorblue);
           

        },
            nuevoBluprint:function(){
            console.log("Ingresooooooooooooooo");
            canvas.width=canvas.width;
            var valor1 = prompt("Ingrese el nuevo Nombre", "");
            nomb=valor1;
            objeto={author:autorblue,"points":[{}],"name":nomb};
           
            console.log(objeto);
             api.crear(objeto,autorblue);
     
    }


};
})();

