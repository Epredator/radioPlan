angular.module('app.controllers', []).controller('radioplanListController', function($scope, $state, popupService, $window, radioplan) {
  $scope.radioplans = radioplan.query(); //fetch all radioplans. Issues a GET to /api/vi/radioplans

  $scope.deleteradioplan = function(radioplan) { // Delete a radioplan. Issues a DELETE to /api/v1/radioplans/:id
    if (popupService.showPopup('Really delete this?')) {
      radioplan.$delete(function() {
        $scope.radioplans = radioplan.query(); 
        $state.go('radioplans');
      });
    }
  };
}).controller('radioplanViewController', function($scope, $stateParams, radioplan) {
  $scope.radioplan = radioplan.get({ id: $stateParams.id }); //Get a single radioplan.Issues a GET to /api/v1/radioplans/:id
}).controller('radioplanCreateController', function($scope, $state, $stateParams, radioplan) {
  $scope.radioplan = new radioplan();  //create new radioplan instance. Properties will be set via ng-model on UI

  $scope.addradioplan = function() { //create a new radioplan. Issues a POST to /api/v1/radioplans
    $scope.radioplan.$save(function() {
      $state.go('radioplans'); // on success go back to the list i.e. radioplans state.
    });
  };
}).controller('radioplanEditController', function($scope, $state, $stateParams, radioplan) {
  $scope.updateradioplan = function() { //Update the edited radioplan. Issues a PUT to /api/v1/radioplans/:id
    $scope.radioplan.$update(function() {
      $state.go('radioplans'); // on success go back to the list i.e. radioplans state.
    });
  };

  $scope.loadradioplan = function() { //Issues a GET request to /api/v1/radioplans/:id to get a radioplan to update
    $scope.radioplan = radioplan.get({ id: $stateParams.id });
  };

  $scope.loadradioplan(); // Load a radioplan which can be edited on UI
});
