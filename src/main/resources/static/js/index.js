/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global apimock */


function ingresar(){

    validacion=validarUsuario();
    if(!validacion){
       
        window.location.replace("/Opcionjuego.html");
    }
}
function validarUsuario(){
    var api = apimock;
    
    var validar=false;
    nombre=document.getElementById("Usuario").value;
    
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
    var nombrej=document.getElementById("nombre").value;
           

    var jugadores=api.getJuego();
     for(i=0;i<jugadores.length -1;i++){
   
               if(jugadores[i]===nombrej){
                   validar=true;
                   i=jugadores.length;
               }
    }
         console.log("ojo debe estar vacio");
        if(validar===true || nombrej==null){
            alert("ingresa un nuevo nombre de juego");
         }
        return validar;
    }

    function crearCampo(){
       
        window.location.replace("/crearCampoJuego.html");
    
        
    }
    
    function crear(){
        validacion=validarPartida();
        if(!validacion){
     
        window.location.replace("/Opcionjuego.html");
    }
   
        
    }
    function regresar(){
        window.location.replace("/Opcionjuego.html");
    }
    function crearJuego() {
        alert("entro");
      // partida=document.getElementsByName.elegir.nombre.value;
      partida=document.getElementsByClassName("nombre");
       alert("entro a nombre");
       estado=true;
       validacion=validarNombreJuego();
       if(!validacion){
           alert("ingresar nombre de partida");
           estado=false;
           alert("entrovalidacion");
       }
       var tipPartida=document.getElementsByClassName("tipodepartida");
       for(i=0;i<tipPartida.length;i++){
           if(tipPartida[i].checked) tipodePartida=tipPartida[i].value;
        }
        // En caso de ser campo privado toca declarar las filas
     var nivelJuego=document.getElementsByClassName("nivel");
       for(i=0;i<tipPartida.length;i++){
           if(tipPartida[i].checked) nivelDificultad=tipPartida[i].value;
        }
        //pendiente por crear un nuevo usuarui
        if(!estado){
         //  stompClient.send("/app/NuevaPartida",{},JSON.stringfy({partida:partida,tipodePartida:tipodePartida,nivelDificultad:nivelDificultad}));
         window.location.replace("/tableroJuego.html");
        }
   }
    
    