/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, apiClient*/

//var nombreP=document.getElementById("nombreP").value;

var nombre = null;
 
function ingresar(){

    nombre = document.getElementById("Usuario").value;
    var api = apiClient;
    //alert("APPI");
    //es necesario implemenmtar esto en filas y colomnas
    api.getJugadores(callback_ingresar);
   
}

function callback_ingresar(jugadores){

    var validar = false;
    for (i = 0; i < jugadores.length; i++) {
        if (jugadores[i].nombre === nombre) {
            validar = true;
            break;
        }
    }
    if(!validar && !(nombre === null || nombre === "")){
        window.location.replace("/crearPartida.html"+"?"+nombre);
    }else
        alert("Usuario no válido, por favor ingrese otro.");
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


            

    
    