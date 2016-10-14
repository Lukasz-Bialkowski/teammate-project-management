var managementModule = angular.module('teammateApp.management');

managementModule.controller('ProjectManagementCtrl', ['ProjectCrudSrv', '_projectEmptyRes', '_userList', function ProjectManagementCtrl(ProjectCrudSrv, _projectEmptyRes, _userList) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, ProjectCrudSrv);

    vm.current = _projectEmptyRes;
    vm.users = _userList;

}]);