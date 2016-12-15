'use strict';

/**
 * @ngdoc function
 * @name testdataApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the testdataApp
 */
app.controller('NPFormCtrl',['$scope','$http','$log',function ($scope,$http,$log) {
	var self  = this;


	self.savePerson=function(form,person) {
		if(form.$valid) {
			$log.log("Ok to Submit");
		} else {
			$log.error("There was an error in form validation!");
		} 
	}
}]);