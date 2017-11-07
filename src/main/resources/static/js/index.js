/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, apimock, apiClient*/

//var nombreP=document.getElementById("nombreP").value;
 
function ingresar(){
 nombre=document.getElementById("Usuario").value;
   var api = apiClient;
   //es necesario implemenmtar esto en filas y colomnas
    api.getUsuarios(callback_ingresar);
}

function callback_ingresar(jugadores){
    var validar = false;
    nombre = document.getElementById("Usuario").value;
    console.log(jugadores +"entro "); 
console.log(jugadores.length +"entro ");
    for (i = 0; i < jugadores.length; i++) {
        if (jugadores[i] === nombre) {
            validar = true;
            i = jugadores.length;
        }
    }
    if(!validar){
        window.location.replace("/crearCampoJuego.html"+"?"+nombre);
    }else
        alert("ingresa Usuario");
    
}

function regresar(){
    window.location.replace("/index.html");
}


//$(document).ready(
//        function () {
//            nombreP = Math.floor((Math.random() * 9534) + 1000);
//            connectarJuego(nombreP);
//        }
//);


            

    
    