/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Location, apiClient, Stomp*/
var stompClient = null;
var api = apiClient;
var usuario = null;
var tipoPartida = null;
var nombreP = null;
var nivel = null;

function connectarJuego() {

    console.info('Connecting to WS... crearPartida');
    socket = new SockJS('/stompApple');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
//        stompClient.subscribe('/topic/crearCampoJuego/' + nombreP + usuario, function (datos) {
//        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");

}

function crearJuego() {
    nivel = document.querySelector('input[name = "nivel"]:checked').value;
    usuario = window.location.search.substr(1);
    console.log(nombreP);
    console.log(nivel);
    console.log(tipoPartida);
    stompClient.send("/app/crearPartida", {}, JSON.stringify({nombreP: nombreP, tipoPartida: tipoPartida, nivel: nivel, usuario: usuario}));
    window.location.replace("/tableroJuego.html"+"?"+nombreP+"&" + usuario);
//    disconnect();

}

function validarPartida(){
    tipoPartida = document.querySelector('input[name = "tipodepartida"]:checked').value;
    api.getPartidaTotal(tipoPartida, callback_Partidas);
}

function callback_Partidas(partida){
    nombreP = document.getElementById("nombreP").value;
    var validar = false;
    for (i = 0; i < partida.length; i++) {
  
        if (partida[i].nombrePartida === nombreP) {
            
            validar = true;
            break;
        }
    }
    if(!validar && !(nombreP === null || nombreP === "")){
        crearJuego(validar);
    }else {
        alert("Nombre de partida no válido, por favor ingrese otro.");
    }
}

$(document).ready(
    function () {
        connectarJuego();
    }
);



