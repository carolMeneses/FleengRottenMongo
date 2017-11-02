/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//mÃƒÂ³dulo provisto (apimock.js)
apiclient = (function () {

    //console.log(nuevosPuntos);

    var request1Response = "";
    var request2Response = "";
    postForumPost = function (objeto,nombreP) {
      // console.log(objeto);
        var postPromise = $.ajax({
            url:"/apple/" + nombreP,
            type: 'POST',
            data:JSON.stringify(objeto),
            
            contentType: "application/json"
        });
        postPromise.then(
                function () {
                    console.info("OK");
                },
                function () {
                    console.info("ERROR POST");
                }

        );
        return postPromise;
    };
    var usersGet = function (usuario) {
        console.log("entro get");
        var promise = $.get("/apple/" +"partida/"+usuario);
        promise.then(
                function (data) {
                    request1Response = data;
                },
                function () {
                    alert("$.get failed!");
                }
        );
        return promise;
    };
     var anotherusersGet = function (tipoPartida,nombreP) {
        console.log("entro get");
        var promise = $.get("/apple/" +tipoPartida+"/" +nombreP);
        promise.then(
                function (data) {
                    request1Response = data;
                },
                function () {
                    alert("$.get failed!");
                }
        );
        return promise;
    };
    var finalAction = function () {
        alert("Collected data:\nAPI#1:" + JSON.stringify(request1Response) + "\n=======\nAPI #2:" + JSON.stringify(request2Response));
    };
//    var anotherUsersGet = function (tipoPartida) {
//        var promise = $.get("/blueprints/" + tipoPartida );
//        promise.then(
//                function (data) {
//                    request2Response = data;
//                },
//                function () {
//                    alert("$.get failed!");
//                }
//        );
//        return promise;
//    };
    
    //Deleite partida
    deleiteForumPost = function (partida, usuario) {
        console.log(JSON.stringify(partida));

        var deleitePromise = $.ajax({
            url: "/apple/" + partida + "/" + usuario ,
            type: 'DELETE',
            data: JSON.stringify(partida),
            contentType: "application/json"
        });
        deleitePromise.then(
                function () {
                    console.info("OK");
                },
                function () {
                    console.info("ERROR");
                }

        );
        return deleitePromise;
    };
  var usersGet = function (usuario) {
        console.log("entro get");
        var promise = $.get("/apple/" +"partida/"+usuario);
        promise.then(
                function (data) {
                    request1Response = data;
                },
                function () {
                    alert("$.get failed!");
                }
        );
        return promise;
    };
    var finalAction = function () {
        alert("Collected data:\nAPI#1:" + JSON.stringify(request1Response) + "\n=======\nAPI #2:" + JSON.stringify(request2Response));
    };
   //public functions

    return {
        getPartidaByjugador: function (jugador, callback) {

            $.get("/apple/" +"/partida/" + jugador, callback);
        },
        getPartidaTipo: function (tipoPartida, callback) {

            $.get("/apple/" + tipoPartida, callback);
        },
        putActualiza: function (partida, jugadores,nombrep) {
            putForumPost(blueprint, autor1, nombre1)
                    .then(usersGet(autor1, nombre1))
                    .then(finalAction);




        },
        //Delite partida
        deleite:function(partida,usuario){
             deleiteForumPost(partida)
                    .then(usersGet(usuario))
                    .then(finalAction);
            
        },
//        nuevoblueprint:function(autor1, nombre1,nuevosPuntos){
//            postForumPost(blueprint, autor1, nombre1)
//                    .then(usersGet(autor1, nombre1))
//                    .then(finalAction);
//            
//        },
        crear: function (objeto, autor1) {
            postForumPost(objeto, autor1)
                    .then(usersGet(autor1))
                    .then(finalAction);
        }
            
    
};
})();

