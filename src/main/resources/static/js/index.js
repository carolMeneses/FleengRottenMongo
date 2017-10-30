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


function validarUsuario() {
    var api = apimock;

    var validar = false;
    nombre = document.getElementById("Usuario").value;
    var jugadores = api.getUsuarios();

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


            

    
    