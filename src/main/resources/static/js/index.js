/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Location, Stomp, apimock */
stompClient=null;
var nombreP=document.getElementById("nombreP").value;

function ingresar(){
 nombre=document.getElementById("Usuario").value;
    validacion=validarUsuario();
    if(!validacion){
       alert();
        window.location.replace("/crearCampoJuego.html"+"?"+nombre);
    }
}
function connectarJuego(nombreP) {

    console.info('Connecting to WS...');
    socket = new SockJS('/stompApple');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected' + frame);
        usuario = window.location.search.substr(1);
        stompClient.subscribe('/topic/crearCampoJuego/' + nombreP + usuario, function (datos) {
          //  window.location.href("/tableroJuego.html" + "?" + nombreP + "&" + usuario);
        });
    });
}
function desconnectar(){
    if(stompClient!==null){
        stompClient.desconnectar();
    }
    console.log("Disconnected");
    
}
function validarUsuario(){
    var api = apimock;
    
    var validar=false;
    nombre=document.getElementById("Usuario").value;
    console.log(nombre);
    var jugadores=api.getUsuarios();
  
    for(i=0;i<jugadores.length -1;i++){
               if(jugadores[i]===nombre){
                   validar=true;
                   i=jugadores.length;
               }
    }
     
 
        if(validar===true|| nombre===""){
            alert("ingresa Usuario");
         }
        return validar;
        
    
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

    function crearCampo(){
          
        window.location.replace("/crearCampoJuego.html");
              
    }
    
    function crear() {
        validacion = validarPartida();
        if (!validacion) {

            window.location.replace("/Opcionjuego.html");
        }


    }
    function regresar(){
        window.location.replace("/Opcionjuego.html");
    }
    function crearJuego() {
       
      // partida=document.getElementsByName.elegir.nombre.value;
     nombreP=document.elegir.nombreP.value;
      estado=true;
       validacion=validarNombreJuego();
       if(!validacion){
           estado=false;
           
       }
       var tipPartida=document.getElementsByName("tipodepartida");
       for(var i=0;i<tipPartida.length;i++){
           if(tipPartida[i].checked) tipodePartida=tipPartida[i].value;
        }
        filas=document.elegir.filas.value;
        columnas=document.elegir.columnas.value;
        
        // En caso de ser campo privado toca declarar las filas
     var nivelJuego=document.getElementsByName("nivel");
     
       for(var i=0;i<nivelJuego.length;i++){
           if(nivelJuego[i].checked) nivelDificultad=nivelJuego[i].value;
        }
        
        //pendiente por crear un nuevo usuarui
        jugadorNuevo=window.location.search.substr(1);
        
        if(!estado){
            console.log(nombreP);
            console.log(nivelDificultad);
            console.log(tipodePartida);
         //  stompClient.send("/app/NuevaPartida",{},JSON.stringfy({partida:partida,tipodePartida:tipodePartida,nivelDificultad:nivelDificultad}));
         stompClient.send("/app/crearJuego", {}, JSON.stringify({nombreP:nombreP,tipoPartida:tipodePartida,nivel:nivelDificultad,filas:filas,columnas:columnas}));
        //disconnect();
        }
   }

   $(document).ready(
        connectarJuego(nombreP)
    );
               
           
            

    
    