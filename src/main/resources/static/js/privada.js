/* global Stomp, apiClient */
var privada = (function(){

    var api= apiClient;
    var stompClient = null;

//    Variables datos del usuario actual
    var usuario = null;
    var nombreP = null;
    var tipoPartida = null;

    function connect() {

        console.info('Connecting to WS... /tableroJuego');
        var socket = new SockJS('/stompApple');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {

            console.log('Connected ' + frame);
            usuario = window.location.search.substr(1);
            tipoPartida = "privada"; // Corresponde con la llave del hashmap de los datos en memoria.
            stompClient.subscribe('/topic/accesoPrivada.' + usuario , function (data) {
                if(data.body === 'true'){
                    window.location.replace("/tableroJuego.html" + "?" + nombreP + "&" + usuario);
                    disconnect();
                }else{
                    alert("Identificador no válido, por favor ingresar otro.");
                }
            });

        });

    };

    function disconnect() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        console.log("Desconectando...");
    };

    $(document).ready(
        function () {
            connect();
        }
    );

    return {
        validar: function () {
            nombreP = document.getElementById("nombreP").value;
            stompClient.send("/app/unirsePartidaPrivada", {}, JSON.stringify({nombreP: nombreP, tipoPartida: tipoPartida, nivel: null, usuario: usuario}))
        },

        volver: function () {
            disconnect();
            window.location.replace("/index.html");
        }
    };

})();



