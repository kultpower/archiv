'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['ui.bootstrap', 'myApp.filters', 'myApp.services', 'myApp.directives', 'myApp.controllers']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
    $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
    $routeProvider.when('/games', {templateUrl: 'partials/games.html', controller: 'GamesController'});
    $routeProvider.when('/platforms', {templateUrl: 'partials/platforms.html', controller: 'PlatformsController'});
    $routeProvider.when('/', {templateUrl: 'partials/home.html', controller: 'HomeController'});
    $routeProvider.otherwise({redirectTo: '/'});
  }]);