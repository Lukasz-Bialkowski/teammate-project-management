var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.factory('DocsCrudSrv', ['$resource', function DocsCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project/:projectId/document';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}]);

projectDocsModule.factory('DocsManagementSrv', ['$resource', function DocsManagementSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'project/:projectId/document';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {
        saveprojectdocument: {
            method: 'POST',
            params: {
                operation: 'saveprojectdocument'
            }
        },
        projectdocuments: {
            method: 'GET',
            params: {
                operation: 'projectdocuments'
            },
            isArray: true
        }
    });
}]);