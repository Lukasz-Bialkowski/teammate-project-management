var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.factory('DocsCrudSrv', ['$resource', function DocsCrudSrv($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = 'docs';

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}])
;