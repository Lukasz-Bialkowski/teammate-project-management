var projectUserDefinitionModule = angular.module('teammateApp.project.user');

projectUserDefinitionModule.factory('ProjectUserSrv', ['$resource', function ProjectUserSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project/:projectId/user';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {
        saveprojectmember: {
            method: 'POST',
            params: {
                operation: 'saveprojectmember'
            }
        },
        list: {
            method: 'GET',
            isArray: true
        }

    });
}]);

projectUserDefinitionModule.factory('ProjectUserCrudSrv', ['$resource', function ProjectUserCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'user';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);

projectUserDefinitionModule.factory('ProjectUserManagementSrv', ['$resource', function ProjectUserManagementSrv($resource) {
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