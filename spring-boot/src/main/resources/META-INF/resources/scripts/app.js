'use strict';

/**
 * @ngdoc overview
 * @name testdataApp
 * @description
 * # testdataApp
 *
 * Main module of the application.
 */
var app = angular
  .module('testdataApp', [
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
        templateUrl: 'views/npdata.html',
        controller: 'NPDataCtrl',
        controllerAs: 'npdata'
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
        controllerAs: 'npform'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
