angular.module('app.services', []).factory('Paciente', function($resource) {
  return $resource('/api/v1/pacientes/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
