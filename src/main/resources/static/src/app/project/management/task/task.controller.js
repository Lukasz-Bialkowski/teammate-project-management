var managementModule = angular.module('teammateApp.project.management');

managementModule.controller('TaskManagementCtrl', ['TaskCrudSrv', '_userList', '_taskEmptyRes', function TaskManagementCtrl(TaskCrudSrv, _userList, _taskEmptyRes) {
    var vm = this;
    vm.current = _taskEmptyRes;
    vm.users = _userList;
}]);