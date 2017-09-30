angular.module('app.controllers', []).controller('PacienteListController', function($scope, $state, popupService, $window, Paciente) {
  $scope.pacientes = Paciente.query(); //fetch all pacientes. Issues a GET to /api/vi/pacientes

  $scope.deletePaciente = function(paciente) { // Delete a Paciente. Issues a DELETE to /api/v1/pacientes/:id
    if (popupService.showPopup('Really delete this?')) {
    	paciente.$delete(function() {
        $scope.pacientes = Paciente.query(); 
        $state.go('pacientes');
      });
    }
  };
}).controller('PacienteViewController', function($scope, $stateParams, Paciente) {
  $scope.paciente = Paciente.get({ id: $stateParams.id }); //Get a single paciente.Issues a GET to /api/v1/pacientes/:id
}).controller('PacienteCreateController', function($scope, $state, $stateParams, Paciente) {
  $scope.paciente = new Paciente();  //create new pacientes instance. Properties will be set via ng-model on UI

  $scope.addPaciente = function() { //create a new pacientes. Issues a POST to /api/v1/pacientes
    $scope.paciente.$save(function() {
      $state.go('pacientes'); // on success go back to the list i.e. pacientes state.
    });
  };
}).controller('PacienteEditController', function($scope, $state, $stateParams, Paciente) {
  $scope.updatePaciente = function() { //Update the edited paciente. Issues a PUT to /api/v1/pacientes/:id
    $scope.paciente.$update(function() {
      $state.go('pacientes'); // on success go back to the list i.e. pacientes state.
    });
  };

  $scope.loadPaciente = function() { //Issues a GET request to /api/v1/pacientes/:id to get a paciente to update
    $scope.paciente = Paciente.get({ id: $stateParams.id });
  };

  $scope.loadPaciente(); // Load a paciente which can be edited on UI
});
