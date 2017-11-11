/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Location, apimock, apiClient, Stomp*/
this.usuario=null;
stompClient = null;
// var api=apiClient;
function connectarJuego(nombreP) {

    console.info('Connecting to WS... aaaaaaaaaa');
    socket = new SockJS('/stompApple');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
       
        console.log('Connected: ' + frame);
        usuario = window.location.search.substr(1);
        console.log(usuario);
        stompClient.subscribe('/topic/crearCampoJuego/' + nombreP + usuario, function (datos) {
            
            window.location.replace("/tableroJuego.html" + "?" + nombreP + "&" + usuario);
            
        });

    });
}
function desconnectar() {
    if (stompClient !== null) {
        stompClient.desconnectar();
    }
    console.log("Disconnected");

}
function crearJuego() {
    
    var api = apiClient;
    api.getPartidaTotal(callback_Partidas);
    // partida=document.getElementsByName.elegir.nombre.value;
    nombreP = document.getElementsByName("nombreP");
    estado = true;
 

  
    var tipPartida = document.getElementsByName("tipodepartida");
    for (var i = 0; i < tipPartida.length; i++) {
        if (tipPartida[i].checked)
            tipodePartida = tipPartida[i].value;
    }
//        filas=document.elegir.filas.value;
//        columnas=document.elegir.columnas.value;

    // En caso de ser campo privado toca declarar las filas
    var nivelJuego = document.getElementsByName("nivel");

    for (var i = 0; i < nivelJuego.length; i++) {
        if (nivelJuego[i].checked)
            nivelDificultad = nivelJuego[i].value;
    }

    //pendiente por crear un nuevo usuarui
    jugadorNuevo = window.location.search.substr(1);

    if (!estado) {
        console.log(nombreP);
        console.log(nivelDificultad);
        console.log(tipodePartida);
        //  stompClient.send("/app/NuevaPartida",{},JSON.stringfy({partida:partida,tipodePartida:tipodePartida,nivelDificultad:nivelDificultad}));
        stompClient.send("/app/crearJuego", {}, JSON.stringify({nombreP: nombreP, tipoPartida: tipodePartida, nivel: nivelDificultad}));
        window.location.replace("/tableroJuego.html"+"?"+nombreP+"&" + usuario);
        //disconnect();
    }
      
}
function validarNombreJuego(){
   // var api = apimock;
    
   //es necesario implemenmtar esto en filas y colomnas
   
           

}
    


function callback_Partidas(partida){
    
    var validar = false;
    nombreP=document.getElementById("nombreP").value;

    for (i = 0; i < partida.length; i++) {
  
        if (partida[i]===(nombreP)) {
            
            validar = true;
            i = partida.length;
        }
    }
    if(!validar){
        window.location.replace("/tableroJuego.html"+"?"+nombreP);
    }else
        alert("ingresa Usuario");
    
}


$(document).ready(
        function () {
            connectarJuego(nombreP);
        }
);



