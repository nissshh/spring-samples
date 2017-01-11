'use strict';

/**
 * @ngdoc overview
 * @name testdataApp
 * @description
 * # testdataApp
 *
 * Main module of the application.
 */
angular.module('Authentication', [])
var app =
	angular.module('testdataApp', [
	'Authentication', 	
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.grid', 
    'ui.grid.treeView',
    'ui.grid.edit', 
    'ui.grid.rowEdit', 
    'ui.grid.cellNav' 
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/login', {
        templateUrl: 'modules/authentication/views/login.html',
        controller: 'LoginController',
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/npdata', {
        templateUrl: 'views/npdata.html',
        controller: 'NPDataCtrl',
        controllerAs: 'npdata'
      })
      .when('/npform', {
        templateUrl: 'views/npform.html',
        controller: 'NPFormCtrl',
        controllerAs: 'formPostCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      });
  })
.run(['$rootScope', '$location', '$cookieStore', '$http','$log',
    function ($rootScope, $location, $cookieStore, $http,$log) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
           $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
        	$log.log('inside $locationChangeStart'+$cookieStore);
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/login');
            }
        });
  }]);
