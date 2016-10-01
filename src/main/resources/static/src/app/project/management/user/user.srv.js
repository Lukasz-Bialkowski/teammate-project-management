var managementModule = angular.module('teammateApp.project.management');

managementModule.factory('UserCrudSrv', ['$resource', function UserCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'user';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);

managementModule.factory('UserManagementSrv', ['$resource', function UserManagementSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'user';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {
        positionsList: {
            method: 'GET',
            params: {operation: 'positionsList'},
            isArray: true
        },
        employmentFormsList: {
            method: 'GET',
            params: {operation: 'employmentFormsList'},
            isArray: true
        }
    });
}]);