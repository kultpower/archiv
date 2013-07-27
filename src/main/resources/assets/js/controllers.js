'use strict';

/* Controllers */

angular.module('myApp.controllers', [])

    .controller('HefteController', ['$scope', 'hefteService', function ($scope, hefteService) {
        $scope.debug = 'hefte!!';

        hefteService.hefte(function(data) {
            $scope.hefte = data;
        });
    }])

    .controller('heftController', ['$scope', '$q', 'heftService', '$routeParams', function ($scope, $q, heftService, $routeParams) {
        $scope.debug = 'einzelnes Heft: ' + $routeParams.heftname;


        heftService.heft($routeParams.heftname).then(function() {
            $scope.loadingData=true;
            $scope.heft = heftService.data();
            //alert($scope.heft.filledPageNumbers[0]);
            $scope.gotoPageByRealPageNumber($scope.heft.filledPageNumbers[0]);

            $scope.loadingData=false;
        });

        $scope.path=$routeParams.heftname;
        $scope.currentPage = "";
        $scope.bigPage = null;
        $scope.pageNumberInput = 1;

        $scope.bigPageImgUrl=null;
        $scope.realPageNumber="";

        $scope.$on('loadingFinished', function(event, parameter) {
            $scope.$apply(function () {
                $scope.loadingData=false;
            });
        });
        $scope.clickImage=function(urlPrefix, path, page) {
            $scope.loadingData=true;
            $scope.bigPageImgUrl=urlPrefix + path + '/big/' + page.dateiname;
            $scope.bigPage=page.dateiname;
            $scope.pageNumberInput = $scope.heft.pages.indexOf(page);
        };

        $scope.gotoPageByRealPageNumber = function(realPageNumber) {
            if (realPageNumber<1) realPageNumber=1;
            //console.log('gotoPageByRealPageNumber:' + realPageNumber);
            $scope.currentPage = $scope.heft.pagesByRealPageNumber[realPageNumber].dateiname;
            $scope.realPageNumber = realPageNumber;
            var stelle = $scope.heft.filledPageNumbers.indexOf($scope.realPageNumber);
        }


        $scope.gotoNextPage = function() {
            $scope.realPageNumber++;
            $scope.realPageNumber++;
            $scope.realPageNumber = Math.min($scope.realPageNumber,$scope.heft.filledPageNumbers[$scope.heft.filledPageNumbers.length-1]);
            $scope.gotoPageByRealPageNumber($scope.realPageNumber);
        }
        $scope.gotoPreviousPage = function() {
            $scope.realPageNumber--;
            $scope.realPageNumber--;
            $scope.realPageNumber = Math.max($scope.heft.filledPageNumbers[0], $scope.realPageNumber);
            $scope.gotoPageByRealPageNumber($scope.realPageNumber);
        }
        $scope.getTextForDoublePageLink = function(doublePage) {
            var text = "";
            text += doublePage[0];
            if (doublePage.length>0) {
                if(typeof doublePage[1]!='undefined') {
                    text += " / " + doublePage[1];
                }
            }
            return text;
        }

        $scope.istAktuellAnzuzeigen = function(page) {
            //var anzeigen =  ($scope.currentPage==page.dateiname );
            var anzeigen =
                (
                    $scope.realPageNumber==page.realPageNumber
                    //||
                    //($scope.heft.filledPageNumbers[($scope.heft.filledPageNumbers.indexOf($scope.realPageNumber)+1)]==page.realPageNumber)
                    //($scope.realPageNumber+1)==page.realPageNumber
                );
            if (!anzeigen) {
                for (var i=0; i < $scope.heft.doublePages.length && !anzeigen; i++) {
                    if ($scope.heft.doublePages[i].indexOf($scope.realPageNumber)>-1) {
                        if ($scope.heft.doublePages[i].indexOf(page.realPageNumber)>-1) {
                            anzeigen = true;
                        }
                    }
                }
            }
            return anzeigen;

        };
        $scope.handleKeypress = function(key) {
            //console.log("pressed: " + key);
            if (key==13) {
                $scope.gotoPageByRealPageNumber($scope.pageNumberInput);
            }
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