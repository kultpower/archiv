'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['ui.bootstrap', 'myApp.filters', 'myApp.services', 'myApp.directives', 'myApp.controllers']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/hefte', {templateUrl: 'partials/hefte.html', controller: 'HefteController'});
    $routeProvider.when('/hefte/:heftname', {templateUrl: 'partials/heft.html', controller: 'HeftController'});
    $routeProvider.otherwise({redirectTo: '/hefte'});
  }]);
