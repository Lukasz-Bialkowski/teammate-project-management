var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.factory('DocsCrudSrv', ['$resource', '$state', function DocsCrudSrv($resource, $state) {
    var contextPath = $state.current.data.contextPath;
    var crudResourceMapping = $state.current.data.crudResourceMapping;

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}])
;