var projectEventsModule = angular.module('teammateApp.project.events');

projectEventsModule.factory('EventCrudSrv', ['$resource', function EventCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'event';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);