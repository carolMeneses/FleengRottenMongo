/* global Stomp, apiClient */
var api= apiClient;
var module=(function(){
    

stompClient = null;
canvasWidth = 600;
canvasHeight = 600;
canvas = null;
ctx = null;
tamano = null;
cwidth = null;
cheight = null;
cont = 0;
usuario = null;
x = null;
y = null;
X = null;
Y = null;
/*
 * 
 *Variables para los eventos del mouse
 */
mx = null;
my = null;

//var api = apiClient;
function connectarJuego() {

    console.info('Connecting to WS...bbbbbbbb');
    var socket = new SockJS('/stompApple');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        console.log('Connected' + frame);
       
        nombreP = window.location.search.substr(1);
        var parametros = window.location.search.substr(1);
        var parametros1 = parametros.split("&");

        alert(parametros);
        
        nombreP = parametros1[0];
        usuario = parametros1[1];
         alert("Usted a ingresado al campo de Juego APPLE BAD, Bienvenido" +" "+usuario);
       // console.log("hola paso");
        
        canvas = document.getElementById("canvas");
        ctx = canvas.getContext('2d');
        var img = new Image();
//        img.src = "/images/logo1.jpg";
//        img.onload = function () {
//            ctx.drawImage(img, 0, 0);
//        };
        tamano = canvas.width / 10;
        console.log(tamano);
        cwidth = ~~(canvas.width / tamano);
        cheight = ~~(canvas.height / tamano);
        EventosMouse();
       dibujarPantalla();
      mirarTodasCasillas();

        stompClient.subscribe('/topic/partidaNueva' , function (datos) {
           
           // alert("Usted a ingresado al campo de Juego APPLE BAD, Bienvenido" + usuario);
             
            var nuevoJuego = JSON.parse(datos.body);
            tipPartida = nuevoJuego.tipoPartida;
            document.getElementById("Usuario").innerHTML = tipPartida.jugador;

            if (tipPartida === "Publica") {
                document.getElementById("Partida").innerHTML = "Publica";

            }
//            else{
//                document.getElementById("Partido").innerHTML=id;
//            }

       

        } ),

        stompClient.subscribe('/topic/vidasJugador' , (function (datos) {
            alert("era con punto y coma")
            var nuevoJuego = JSON.parse(datos.body);
            document.getElementById("vidajugador").innerHTML = nuevoJuego.vidasJugador;
        })            );

        stompClient.subscribe('/topic/manzanasPodridas' , function (datos) {
            var nuevoJuego = JSON.parse(datos.body);
            document.getElementById("manzanasPodridas").innerHTML = nuevoJuego.manzanasPodridas;
        }),

        stompClient.subscribe('/topic/casillaVisitada' , function (datos) {
            var casilla = JSON.parse(datos.body);
            var posicionX = casilla.x;
            var posicionY = casilla.y;
            var color= casilla.color;
            llenar(color, posicionX, posicionY);
            //var color = casilla.color;
            //var estado = casilla.estado;

          //  nuevasCasillas(posicionX, posicionY, color, estado);
        });

        stompClient.subscribe('/topic/finJuegoRetirar' , function (datos) {
            var fin = JSON.parse(datos.body);
            if (!fin.estadoJugador) {
                alert("Has perdido");
                // window.location.replace("/index.html");
            }


        });

        establecerPartida();
    });

}



function nuevasCasillas(posicionX, posicionY, color, estado) {
    switch (estado) {
        case 'true':
            llenar(posicionX, posicionY, 'red');
            break;
        case 'false':
            llenar(posicionX, posicionY, color);
            break;
        case '1':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'blue', posicionX, posicionY);
            break;
        case '2':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'yellow', posicionX, posicionY);
            break;

        case '3':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'green', posicionX, posicionY);
            break;
        case '4':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'red', posicionX, posicionY);
            break;

        case '5':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'gray', posicionX, posicionY);
            break;
        case '6':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'blue', posicionX, posicionY);
            break;
        case '7':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'fuchia', posicionX, posicionY);
            break;
        case '8':
            llenar(posicionX, posicionY, color);
            colocarText(estado, 'pink', posicionX, posicionY);
            break;
    }

}
function salirDelJuego() {
    desconectar();
    //  window.location.replace("/index.html");
}

function llenar(s, x, y) {
    ctx.fillStyle = s;
    ctx.fillRect(x * tamano, y * tamano, tamano, tamano);
}

function colocarText(numero, color, gx, gy) {
    ctx.fillStyle = color;
    ctx.font = 0.5 * tamano + "px Georgia";

    ctx.colocarText(numero, gx * tamano + tamano / 3, gy * tamano + 2 * tamano / 3);
}


function desconectar() {
    if (stompClient !== null) {
        stompClient.desconectar();

    }
    console.log("Desconectar");
}


function establecerPartida() {
    stompClient.send("/app/establecePartida", {}, JSON.stringify({partida: nombreP, jugador: usuario}));
}

function mirarCasilla(X, Y) {
    stompClient.send("/app/destaparCasilla", {}, JSON.stringify({nombreP: nombreP, jugador: usuario ,posicionX: X, posicionY: Y}));

}
function mirarTodasCasillas() {
    console.log("ENTRO A LAS CASILLAS");
    stompClient.send("/app/cubrirCasilla", {}, JSON.stringify({partida: nombreP, posicionX: 10, posicionY: 10}));

}
/*
 * Manejo de eventos en el Mouse;
 */
function EventosMouse() {
    console.log("entro a mouse");
    $('#canvas').mousedown(function (evento) {
        mx = event.offsetX;
        my = event.offsetY;

        X = ~~(mx / tamano);
        Y = ~~(my / tamano);

        switch (evento.which) {
            case 1:
                mirarCasilla(X, Y);
                 llenar("green", X, Y);
                break;
            case 2:
                break;
            case 3:
                break;
            default :
                alert('no correspond');
        }
    });
}


/*
 * Dibujar filas y columnas en el CANVAS
 */

function dibujarPantalla() {
   
    
              
    
    for (var x = 0; x <= canvasWidth; x += tamano) {
        ctx.moveTo(x, 0);
	ctx.lineTo(x, canvasWidth);
    }

    for (var x = 0; x <= canvasHeight; x += tamano) {
        ctx.moveTo(0, x);
	ctx.lineTo(canvasHeight, x);
    }
    ctx.strokeStyle = "white";
    ctx.stroke();
}

$(document).ready(
        function () {
            connectarJuego();
        }
);

})();



