angular.module('app', [ 'ngRoute' ])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl : 'home.html',
            controller : 'home'
        }).otherwise('/');

    })
    .controller('navigation',
        function($rootScope, $scope, $http, $location) {
            $scope.tab = function(route) {
                return $route.current && route === $route.current.controller;
            };
        })
    .controller('home',
        function($scope, $http) {
            $http.get('/home/').success(function(data) {
                $scope.greeting = data;
        })
});