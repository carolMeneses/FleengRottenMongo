/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, apimock, apiClient*/

//var nombreP=document.getElementById("nombreP").value;
 
function ingresar(){
 nombre=document.getElementById("Usuario").value;
    validacion=validarUsuario();
    if(!validacion){
        window.location.replace("/crearCampoJuego.html"+"?"+nombre);
    }
}


function validarUsuario() {
   var api = apiClient;

    var validar = false;
    nombre = document.getElementById("Usuario").value;
    var jugadores = api.get

    for (i = 0; i < jugadores.length - 1; i++) {
        if (jugadores[i] === nombre) {
            validar = true;
            i = jugadores.length;
        }
    }


    if (validar === true || nombre === "") {
        alert("ingresa Usuario");
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


            

    
    