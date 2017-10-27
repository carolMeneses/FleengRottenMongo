/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Jessica, Johana
 */

cwidth=null;
cheight=null;
cont=0;
nombre=null;
x=null;
y=null;
X= null;
Y=null;

/*variables de STOMP*/
stompClient=null;
Canvas=null;
ctx=null;
canvasHeight=600;
canvasWidth=600;

tamano=null;


function connectarJuego(){
    var socket=new SockJs('/stomApple');
    stompClient=Stomp.over(socket);
    stompClient.connect({},function (frame){
        console.log('Connected'+frame);
        
        /*
         * Crear Jueago
         */
        
        var datos=window.location.search.substr(1);
        var datos1=datos.split("&");
        id=dato1[0];
        nombre=dato1[1];
        
        //
        
        stompClient.subscribe('/topic/crearCampoJuego'+id+nombre, function (datos){
            alert("Usted a ingresado al campo de Juego APPLE BAD, Bienvenido"+nombre);
            var nuevoJuego=JSON.parse(datos.body);
            tipPartida=nuevoJuego.tipPartida;
            document.getElementById("jugador").innerHTML=tipPartida.jugador;
            if (tipPartida=="Publica"){
                document.getElementById("Partido").innerHTML= "Pública";
                
            }
            else{
                document.getElementById("Partido").innerHTML=id;
            }
            
            canvas=document.getElementById("tabla");
            ctx=canvas.getContext('2d');
            tamano=cwidth/nuevoJuego.filas;
            width=~~ (canvas.width/tamano);
            height = ~~ (canvas.height/tamano);
            eventosJuegos();
            dibujarTablero();
            mirarTodasCAsillas();   
            
        });
        
         stompClient.subscribe('/topic/vidasJUgador'+id+nombre,function (datos){
             var nuevoJuego=JSON.parse(datos.body);
             document.getElementById("vidajugador").innerHTML=nuevoJuego.vidasJugador;
         });
         
         stompClient.subscribe('/topic/manzanasPodridas'+id+nombre,function (datos){
             var nuevoJuego=JSON.parse(datos.body);
             document.getElementById("manzanasPodridas").innerHTML=nuevoJuego.vidasJugador;
         });
         
          stompClient.subscribe('/topic/casillaVisitada'+id+nombre,function (datos){
             var casilla=JSON.parse(datos.body);
             var posicionX=casilla.posicionX;
             var posicionY=casilla.posicionY;
             var color=casilla.color;
             var estado = casilla.estado;
             
             nuevasCasillas(posicionX,posicionY,color,estado)
         });
         
          stompClient.subscribe('/topic/finJuegoRetirar'+id+nombre,function (datos){
             var fin=JSON.parse(datos.body);
             if(!fin.estadoJugador){
                 alert("Has perdido");
                 window.location.replace("/index.html");
             }
            
         });
         
         iniciarPartida();
         
              
 });
}


function nuevasCasillas(posicionX,posicionY,color,estado){
    switch (estado){
        case 'true':
            llenar(posicionX,posicionY,color);
            break;
        case 'false':
            llenar(posicionX,posicionY,color);
            break;
        case '1':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'blue', posicionX, posicionY);
            break;
        case '2':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'yellow', posicionX, posicionY);
            break;
       
        case '3':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'green', posicionX, posicionY);
            break;
       case '4':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'red', posicionX, posicionY);
            break;
            
        case '5':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'gray', posicionX, posicionY);
            break;
        case '6':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'blue', posicionX, posicionY);
            break;
        case '7':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'fuchia', posicionX, posicionY);
            break;
         case '8':
            llenar(posicionX,posicionY,color);
            colocarText(estado,'pink', posicionX, posicionY);
            break;   
    }
    
}

function llenar(s,x,y) {
    ctx.fillStyle = s;
    ctx.fillRect(gx * size, gy * size, size, size);
}

function colocarText(numero, color, gx, gy){
    ctx.fillStyle = color;
    ctx.font = 0.5*size+"px Georgia";
    ctx.colocarText(numero, gx*size + size/3, gy*size + 2*size/3);
}

function prconectar(){
    var datos=window.location.search.substr(1);
    var datos1=datos.split ("&");
    id=dato1[0];
    nombre=dato1[1];
}

function desconectar(){
     if (stompClient != null) {
         stompClient.desconectar();
        
     }
     console.log("Desconectar");
}