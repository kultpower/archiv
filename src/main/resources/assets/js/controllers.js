'use strict';

/* Controllers */

angular.module('myApp.controllers', [])

    .controller('HefteController', ['$scope', 'hefteService', function ($scope, hefteService) {
        $scope.debug = 'hefte!!';

        $scope.hefteTest = hefteService.hefteTest();

        hefteService.hefte(function(data) {
            $scope.hefte = data;
        });
    }])

    .controller('HeftController', ['$scope', 'heftService', '$routeParams', function ($scope, heftService, $routeParams) {
        $scope.debug = 'einzelnes Heft: ' + $routeParams.heftname;

        //$scope.heft = heftService.heft($routeParams.heftname);

        heftService.heft($routeParams.heftname, function(data) {
            $scope.heft = data;
        });
        $scope.path=$routeParams.heftname;
        $scope.currentPage = "";
        $scope.bigPage = null;
        $scope.pageNumberInput = 1;
        //$scope.gotoPage($scope.pageNumberInput);
        $scope.bigPageImgUrl=null;
        $scope.clickImage=function(urlPrefix, path, page) {
          $scope.bigPage=page.dateiname;
          $scope.bigPageImgUrl=urlPrefix + path + '/big/' + page.dateiname;
          $scope.pageNumberInput = $scope.heft.pages.indexOf(page)
        };
        $scope.gotoPage = function(number) {
            $scope.currentPage = $scope.heft.pages[number].dateiname;
        }
        $scope.gotoNextPage = function() {
            $scope.pageNumberInput++;
            $scope.pageNumberInput = Math.min($scope.heft.pages.length-1,$scope.pageNumberInput);
            $scope.gotoPage($scope.pageNumberInput);
        }
        $scope.gotoPreviousPage = function() {
            $scope.pageNumberInput--;
            $scope.pageNumberInput = Math.max(0,$scope.pageNumberInput);
            $scope.gotoPage($scope.pageNumberInput);
        }
        $scope.istAktuellAnzuzeigen = function(page) {
            //console.log($scope.currentPage + " / " + page.dateiname);
            var anzeigen =  $scope.currentPage==page.dateiname;
            return anzeigen;

        };

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