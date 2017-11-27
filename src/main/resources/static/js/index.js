/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, apiClient*/

var nombre = null;
var recurso = null;
 
function validar(){
    nombre = document.getElementById("Usuario").value;
    sessionStorage.setItem("nombreuser",nombre);
    var api = apiClient;
    api.getJugadores(callback_validar);
}

function callback_validar(jugadores){

    var validar = false;
    for (i = 0; i < jugadores.length; i++) {
        if (jugadores[i].nombre === nombre) {
            validar = true;
            break;
        }
    }
    if(!validar && !(nombre === null || nombre === "")){
        window.location.replace(recurso + "?" + nombre);
    }else
        alert("Usuario no válido, por favor ingrese otro.");
}

function regresar(){
    window.location.replace("/index.html");
}

function crearPartida(){
    recurso = "/crearPartida.html/";
    validar();
}

function campoPrivado(){
    recurso = "/partidaPrivada.html/";
    validar();
}

function campoPublico(){
//    recurso = "/partidaPublica.html/";
//    validar();
    alert("En construcción...");
}

$(document).ready(
    function () {
    }
);


            

    
    