var managementModule = angular.module('teammateApp.project.management');

managementModule.controller('ProjectManagementCtrl', ['ProjectCrudSrv', '_projectEmptyRes', function ProjectManagementCtrl(ProjectCrudSrv, _projectEmptyRes) {
    var vm = this;
    vm.current = _projectEmptyRes;

}]);