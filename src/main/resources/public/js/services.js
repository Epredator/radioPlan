angular.module('app.services', []).factory('radioplan', function($resource) {
  return $resource('/api/v1/radioplans/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
