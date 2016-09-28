var taskboardModule = angular.module('teammateApp.project.taskboard');

taskboardModule.factory('TaskCrudSrv', ['$resource', '$state', function TaskCrudSrv($resource, $state) {
    var contextPath = $state.current.data.contextPath;
    var crudResourceMapping = $state.current.data.crudResourceMapping;

    var srv = new CrudfsSrv(contextPath, crudResourceMapping, $resource);
    return srv.getResource();
}])
;