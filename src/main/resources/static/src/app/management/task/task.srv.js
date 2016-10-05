var managementModule = angular.module('teammateApp.management');

managementModule.factory('TaskCrudSrv', ['$resource', function TaskCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'task';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);

managementModule.factory('TaskManagementSrv', ['$resource', function TaskManagementSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'task';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {});
}]);