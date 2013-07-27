'use strict';

function sleep(delay) {
    var start = new Date().getTime();
    while (new Date().getTime() < start + delay);
}

// Declare app level module which depends on filters, and services
angular.module('myApp', ['ui.bootstrap', 'myApp.filters', 'myApp.services', 'myApp.controllers', 'myApp.directives', 'ajoslin.promise-tracker']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/hefte', {templateUrl: 'partials/hefte.html', controller: 'HefteController'});
    $routeProvider.when('/hefte/:heftname', {templateUrl: 'partials/heft.html', controller: 'heftController'});
    $routeProvider.otherwise({redirectTo: '/hefte'});
  }]);


String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
};
