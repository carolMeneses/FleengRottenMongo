/* global Stomp, apiClient */
stompClient = null;
var id = null;
function connectarJuego() {
    id = document.getElementById("Usuario").value;
    console.info('Connecting to WS..ppppp');
    var socket = new SockJS('/stompApple');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/code', function (greeting) {
            var j = JSON.parse(greeting.body);
            console.log("ok");
            showCode(j.content, j.server, j.id);
        });
//        interval = setInterval(sendCode, 500);
    });

}
    function sendCode() {
        stompClient.send("/app/message", {}, JSON.stringify({'name': "Andres", 'id': id}));
    }
    
    function showCode (content, server, oid) {
            console.log(content, server, oid);
            if (oid != id) {
                console.log("llega a todos");
            }
        }

                