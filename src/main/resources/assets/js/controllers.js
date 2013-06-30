'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
    controller('MyCtrl1', [function () {

    }])
    .controller('MyCtrl2', [function () {

    }])
    .controller('GamesController', ['$scope', 'gamesService', function ($scope, gamesService) {
        $scope.test = 'Hola!';
        $scope.gamesTest = gamesService.gamesTest();
        //$scope.games = gamesService.games();
        gamesService.games(function(data) {
            $scope.gamesJson = data;
        });
    }])

    .controller('PlatformsController', ['$scope', function ($scope) {
        $scope.debug = 'platforms';
    }])
    .controller('HomeController', ['$scope', function ($scope) {
        $scope.debug = 'home';
    }])
    .controller('NavController', ['$scope', function ($scope) {
        $scope.debug = 'nav';
        $scope.languages = ['deutsch', 'englisch'];
        $scope.selectedLanguage = 'deutsch';
    }])
;