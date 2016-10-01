var managementModule = angular.module('teammateApp.project.management');

managementModule.factory('ProjectCrudSrv', ['$resource', function ProjectCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);

managementModule.factory('ProjectManagementSrv', ['$resource', function ProjectManagementSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {});
}]);