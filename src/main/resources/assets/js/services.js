'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).

    value('version', '0.1')

    .service('hefteService', ['$http',function ($http) {
        return {
            hefteTest: function () {
                return 'games...games...';
            },
            hefte: function(callback) {
                $http.get('/service/hefte').success(callback);
            }
        }
    }])

    .service('heftService', ['$http',function ($http) {
        return {
            heft: function(name, callback) {
                $http.get('/service/heft/' + name).success(callback);
            }
        }
    }])

;


