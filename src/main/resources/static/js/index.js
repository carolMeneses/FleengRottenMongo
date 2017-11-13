/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, apiClient*/

//var nombreP=document.getElementById("nombreP").value;
 
function ingresar(){
   
   
 nombre=document.getElementById("Usuario").value;
  
   var api = apiClient;
   alert("APPI");
   //es necesario implemenmtar esto en filas y colomnas
    api.getJugadores(callback_ingresar);
   
}

function callback_ingresar(jugadores){
     alert("iCOOLBACK");
//    
//    var validar = false;
//   nombre = document.getElementById("Usuario").value;
//  console.log("entro1"+nombre);
//    for (i = 0; i < jugadores.length; i++) {
//        if (jugadores[i] === nombre) {
//            validar = true;
//            i = jugadores.length;
//             console.log("entro2");
//        }
//    }
//    if(!validar){
//        window.location.replace("/crearPartida.html"+"?"+nombre);
//         console.log("entro3");
//    }else
//        alert("ingresa Usuario");
//     console.log("entro4");
//    
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


            

    
    