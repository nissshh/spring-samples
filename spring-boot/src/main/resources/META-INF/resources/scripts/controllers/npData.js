'use strict';

/**
 * @ngdoc function
 * @name testdataApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the testdataApp
 */
app.controller('NPDataCtrl',['$scope','$http',function ($scope,$http) {
    $scope.gridOptions = {
        enableSorting: true,
        columnDefs: [
          { name:'name', field: 'name' ,displayName:'Name'},
          { name:'age', field: 'age' ,displayName:'Age'},
          { name: 'gender',displayName:'Gender' },
          { name: 'registered', displayName: 'Registered' , type: 'date', cellFilter: 'date:"yyyy-MM-dd"'},
          { name: 'phone', displayName: 'Phone'},
          { name: 'email', displayName: 'EMail'},
          { name: 'balance', displayName: 'Balance', type: 'number'},
          { name: 'address', displayName: 'Address', type: 'object'},
          { name: 'about', displayName: 'About'},
          { name: 'isActive', displayName: 'Active', type: 'boolean'}
        ],
      };

    $http.get('/person')
    	.then(function(response) {
    		$scope.gridOptions.data = response.data; 
    	}, function(response) {
			console.log('Some Error'+response.statusText);
		});
  }]);
