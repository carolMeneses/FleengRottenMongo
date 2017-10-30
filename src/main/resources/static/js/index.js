/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, apimock*/

//var nombreP=document.getElementById("nombreP").value;

function ingresar(){
 nombre=document.getElementById("Usuario").value;
    validacion=validarUsuario();
    if(!validacion){
        window.location.replace("/crearCampoJuego.html"+"?"+nombre);
    }
}


function validarNombreJuego(){
    var api = apimock;
       
    var validar=false;
    nombreP=document.getElementById("nombreP").value;
           

    var jugadores=api.getJuego();
     for(i=0;i<jugadores.length -1;i++){
   
               if(jugadores[i]===nombreP){
                   validar=true;
                   i=jugadores.length;
               }
    }
        if(validar===true || nombreP===null){
            alert("ingresa un nuevo nombre de juego");
         }
        return validar;
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


            

    
    