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
     
 
        if(validar===true|| nombre===" "){
            alert("ingresa Usuario");
         }
        return validar;
        
    
}
function validarNombreJuego(){
    var api = apimock;
    
    var validar=false;
    nombrej=document.getElementById("nombre").value;
    
    var jugadores=api.getJuego();
  
    for(i=0;i<jugadores.length -1;i++){
               if(jugadores[i]===nombrej){
                   validar=true;
                   i=jugadores.length;
               }
    }
     
 
        if(validar===true|| nombrej===" "){
            alert("ingresa un nuevo nombre de juego");
         }
        return validar;
    }

    function crearCampo(){
        valiJuego=validarNombreJuego();
        if(!validacion){
        window.location.replace("/crearCampoJuego.html");
    }
        
    }
    
    function crear(){
        validacion=validarPartida();
        if(!validacion){
     
        window.location.replace("/crearPartida.html");
    }
        
    }
    function regresar(){
        window.location.replace("/Opcionjuego.html"); 
    }