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
			$log.debug("Ok to Submit");
			$log.debug(person);
			$http.put('/person',person).then(function(response) {
		 		$log.log(response.data); 
		 	}, function(response) {
				$log.error('Some Error'+response.statusText);
				$log.error(response.data);
			});
		} else {
			$log.error("There was an error in form validation!");
		} 
	}
	

	self.resetForm = function(personForm, person) {
		$log.debug("Formcleared");
		$scope.person = angular.copy({});
		personForm.$setPristine();
	};
	
	 
	
}]);
