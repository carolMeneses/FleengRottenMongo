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
    postForumPost = function (objeto,autor1) {
      // console.log(objeto);
        var postPromise = $.ajax({
            url:"/blueprints/" + autor1,
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
    var usersGet = function (autor1, nombre1) {
        console.log("entro get");
        var promise = $.get("/blueprints/" + autor1 + "/" + nombre1);
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
    var anotherUsersGet = function () {
        var promise = $.get("/blueprints/" + autor1 + "/" + nombre1);
        promise.then(
                function (data) {
                    request2Response = data;
                },
                function () {
                    alert("$.get failed!");
                }
        );
        return promise;
    };
    //PUT
    putForumPost = function (blueprint, autor1, nombre1) {
        console.log(JSON.stringify(blueprint));

        var putPromise = $.ajax({
            url: "/blueprints/" + blueprint + "/" + autor1 + "/" + nombre1,
            type: 'PUT',
            data: JSON.stringify(blueprint),
            contentType: "application/json"
        });
        putPromise.then(
                function () {
                    console.info("OK");
                },
                function () {
                    console.info("ERROR");
                }

        );
        return putPromise;
    };
    var usersGet = function (autor1, nombre1) {
        var promise = $.get("/blueprints/" + autor1 + "/" + nombre1);
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
    var anotherUsersGet = function () {
        var promise = $.get("/blueprints/" + autor1 + "/" + nombre1);
        promise.then(
                function (data) {
                    request2Response = data;
                },
                function () {
                    alert("$.get failed!");
                }
        );
        return promise;
    };
    //Deleite
    deleiteForumPost = function (blueprint, autor1, nombre1) {
        console.log(JSON.stringify(blueprint));

        var deleitePromise = $.ajax({
            url: "/blueprints/" + blueprint + "/" + autor1 + "/" + nombre1,
            type: 'DELETE',
            data: JSON.stringify(blueprint),
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
    var usersGet = function (autor1, nombre1) {
        var promise = $.get("/blueprints/" + autor1 + "/" + nombre1);
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
    var anotherUsersGet = function () {
        var promise = $.get("/blueprints/" + autor1 + "/" + nombre1);
        promise.then(
                function (data) {
                    request2Response = data;
                },
                function () {
                    alert("$.get failed!");
                }
        );
        return promise;
    };
    //public functions

    return {
        getBlueprintsByAuthor: function (authname, callback) {

            $.get("/blueprints/" + authname, callback);
        },
        getBlueprintsByNameAndAuthor: function (authname, bpname, callback) {

            $.get("/blueprints/" + authname + "/" + bpname, callback);
        },
        putActualiza: function (blueprint, nuevosPuntos, autor1, nombre1) {
            putForumPost(blueprint, autor1, nombre1)
                    .then(usersGet(autor1, nombre1))
                    .then(finalAction);




        },
        deleite:function(blueprint,autor1, nombre1){
             deleiteForumPost(blueprint)
                    .then(usersGet(autor1, nombre1))
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

