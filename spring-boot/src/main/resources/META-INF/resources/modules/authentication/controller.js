'use strict';
 
angular.module('Authentication')
 
.controller('LoginController',
    ['$scope', '$rootScope', '$location','$log', 'AuthenticationService',
    function ($scope, $rootScope, $location, $log ,AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
        $scope.firstname='Nishant';
		$scope.lastname='Sonar';
		$scope.email='nishant.sonar@synechron.com';
		
        $scope.loggedin = function () {
        	var loginStatus = AuthenticationService.Loggedin()
        	if(loginStatus){
        		return true;
        	} else {
        		return false;
        	}
        		
        };
        
        $scope.login = function () {
        	$log.info('Inside login method');
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password);
                    $location.path('/');
                    $scope.loggedin=true;
                    $scope.firstname=response.firstname;
            		$scope.lastname=response.lastname;
            		$scope.email=response.email;
            		
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }]);