var taskboardModule = angular.module('teammateApp.project.taskboard');

taskboardModule.factory('TaskCrudSrv', ['$resource', function TaskCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'task';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}])
;