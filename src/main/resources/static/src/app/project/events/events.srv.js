var projectEventsModule = angular.module('teammateApp.project.events');

projectEventsModule.factory('EventCrudSrv', ['$resource', function EventCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project/:projectId/event';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);

projectEventsModule.factory('EventManagementSrv', ['$resource', function EventManagementSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project/:projectId/event';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {
        saveprojectevent: {
            method: 'POST',
            params: {
                operation: 'saveprojectevent'
            }
        },
        projectevents: {
            method: 'GET',
            params: {
                operation: 'projectevents'
            },
            isArray: true
        }
    });
}]);