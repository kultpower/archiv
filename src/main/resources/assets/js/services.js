'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).

    value('version', '0.1')

    .service('hefteService', ['$http',function ($http) {
        return {
            hefte: function(callback) {
                $http.get('/service/hefte').success(callback);
            }
        }
    }])

    .service('heftServiceAlt', ['$http',function ($http) {
        return {
            heft: function(name, callback) {
                $http.get('/service/heft/' + name).success(callback);
            }
        }
    }])

    .service('heftService', ['$http','$q', '$rootScope', 'promiseTracker', function ($http, $q, $rootScope, promiseTracker) {
        var deffered = $q.defer();
        var data = [];
        var heftService = {};

        $rootScope.imageLoader = promiseTracker('imageLoader');

        heftService.heft = function(name) {
            $http.get('/service/heft/' + name, {tracker: 'imageLoader'})
                .success(function (d) {
                    data = d;
                    //console.log(d);
                    deffered.resolve();
                });
            return deffered.promise;
        };
        heftService.data = function() { return data; };

        heftService.preloadImage = function(url) {
            console.log('Loading image: ' + url);
            $http.get(url, {tracker: 'imageLoader'})
                .success(function (d) {
                    console.log('Loaded');
                    deffered.resolve();
                });
            return deffered.promise;
        };

        return heftService;

    }])



;


