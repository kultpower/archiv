'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).

    value('version', '0.1')

    .service('gamesService', ['$http',function ($http) {
        return {
            gamesTest: function () {
                return 'games...games...';
            },
            games: function(callback) {
                $http.get('/service/games/init').success(callback);
            }
        }
    }])

;


