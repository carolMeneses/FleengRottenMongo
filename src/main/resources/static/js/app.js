/* global Stomp, apiClient */

var module = (function(){

    var api= apiClient;
    var stompClient = null;

//    Variables del canvas

    var canvasWidth = 600;
    var canvasHeight = 600;
    var canvas = null;
    var ctx = null;
    var tamano = null;
    var cwidth = null;
    var cheight = null;
    var cont = 0;
    var x = null;
    var y = null;
    var X = null;
    var Y = null;

//    Variables para los eventos del mouse

    var mx = null;
    var my = null;

//    Variables datos del usuario actual
    var usuario = null;
    var nombreP = null;

    function connectarJuego() {

        console.info('Connecting to WS... /tableroJuego');
        var socket = new SockJS('/stompApple');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {

            console.log('Connected' + frame);
            var parametros = window.location.search.substr(1);
            var parametros1 = parametros.split("&");
            nombreP = parametros1[0];
            usuario = parametros1[1];
            alert("Bienvenido " + usuario + " ha ingresado al campo de juego: " + nombreP);

            canvas = document.getElementById("canvas");
            ctx = canvas.getContext('2d');
            var img = new Image();
//            img.src = "/images/logo1.jpg";
//            img.onload = function () {
//                ctx.drawImage(img, 0, 0);
//            };
            tamano = canvas.width / 10;
//            console.log(tamano);
            cwidth = ~~(canvas.width / tamano);
            cheight = ~~(canvas.height / tamano);
            EventosMouse();
            dibujarPantalla();
        //  mirarTodasCasillas();

            stompClient.subscribe('/topic/partidaNueva' , function (datos) {

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
                alert("era con punto y coma");
                var nuevoJuego = JSON.parse(datos.body);
                document.getElementById("vidajugador").innerHTML = nuevoJuego.vidasJugador;
            }));

            stompClient.subscribe('/topic/manzanasPodridas' , function (datos) {
                var nuevoJuego = JSON.parse(datos.body);
                document.getElementById("manzanasPodridas").innerHTML = nuevoJuego.manzanasPodridas;
            }),

//            stompClient.subscribe('/topic/casillaVisitada'+nombreP+usuario , function (datos) {
            stompClient.subscribe('/topic/casillaVisitada.' + nombreP , function (datos) {
                var casilla = JSON.parse(datos.body);
                var posicionX = casilla.x;
                var posicionY = casilla.y;
                var color = casilla.color;
                llenar(posicionX, posicionY, color);


             // nuevasCasillas(posicionX, posicionY, color, estado);
                //var color = casilla.color;
                //var estado = casilla.estado;
            });

            stompClient.subscribe('/topic/retirarJugador.' + nombreP + "." + usuario , function(data){
                alert("Lo siento, te has quedado sin vidas.");
                desconectar();
            });

            stompClient.subscribe('/topic/finJuego.' + nombreP , function (datos) {
                alert("Ha muerto el último jugador en pie. \n Fin de la partida");
            });

            establecerPartida();
        });

    }



    function nuevasCasillas(posicionX, posicionY, color, estado) {
       llenar(posicionX, posicionY, 'red');
    //    switch (true) {
    //        case true:
    //            llenar(posicionX, posicionY, 'red');
    //            break;
    //        case 'false':
    //            llenar(posicionX, posicionY, 'verde');
    //            break;
    //        case '1':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'blue', posicionX, posicionY);
    //            break;
    //        case '2':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'yellow', posicionX, posicionY);
    //            break;
    //
    //        case '3':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'green', posicionX, posicionY);
    //            break;
    //        case '4':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'red', posicionX, posicionY);
    //            break;
    //
    //        case '5':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'gray', posicionX, posicionY);
    //            break;
    //        case '6':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'blue', posicionX, posicionY);
    //            break;
    //        case '7':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'fuchia', posicionX, posicionY);
    //            break;
    //        case '8':
    //            llenar(posicionX, posicionY, color);
    //            colocarText(estado, 'pink', posicionX, posicionY);
    //            break;
    //    }

    }

    function salirDelJuego() {
        stompClient.send("/app/abandona", {}, JSON.stringify({usuario: usuario}));
        alert("Saliendo de la partida...");
        desconectar();
        //  window.location.replace("/index.html");
    }

//    x: Coordenada X
//    y: Coordenada Y
//    s: Color
    function llenar(x, y, s) {
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
            stompClient.disconnect();
        }
        console.log("Desconectando");
    }


    function establecerPartida() {

        stompClient.send("/app/establecePartida", {}, JSON.stringify({partida: nombreP, jugador: usuario}));
    }

//    Evalúa el contenido de la casilla seleccionada.
    function mirarCasilla(X, Y) {
        stompClient.send("/app/destaparCasilla", {}, JSON.stringify({nombreP: nombreP, jugador: usuario, posicionX: X, posicionY: Y}));
    }

    function mirarTodasCasillas() {
        console.log("ENTRO A LAS CASILLAS");
        stompClient.send("/app/cubrirCasilla", {}, JSON.stringify({partida: nombreP, posicionX: 10, posicionY: 10}));

    }

//    Manejo de eventos en el Mouse;
    function EventosMouse() {
        $('#canvas').mousedown(function (evento) {
            mx = evento.offsetX;
            my = evento.offsetY;

            X = ~~(mx / tamano);
            Y = ~~(my / tamano);

            switch (evento.which) {
                case 1:
                    mirarCasilla(X, Y);

                  //  llenar("green", X, Y);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default :
                    alert('No corresponde');
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



