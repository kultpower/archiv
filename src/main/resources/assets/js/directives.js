'use strict';

/* Directives */


angular.module('myApp.directives', []).
  directive('appVersion', ['version', function(version) {
    return function(scope, elm, attrs) {
      elm.text(version);
    };
  }])
    .directive('onKeyupFn', function() {
        return function(scope, elm, attrs) {
            //Evaluate the variable that was passed
            //In this case we're just passing a variable that points
            //to a function we'll call each keyup
            var keyupFn = scope.$eval(attrs.onKeyupFn);
            elm.bind('keyup', function(evt) {
                //$apply makes sure that angular knows
                //we're changing something
                scope.$apply(function() {
                    keyupFn.call(scope, evt.which);
                });
            });
        };
    })

    .directive('imageonload', [ function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var parameter = null;
            scope.$watch(attrs.imageonload, function (value) {
                parameter = attrs.imageonload;
            });
            element.bind('load', function() {
                scope.$emit('loadingFinished', parameter);
            });
        }
    };
}]);

;
