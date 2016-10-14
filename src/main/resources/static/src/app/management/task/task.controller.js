var managementModule = angular.module('teammateApp.management');

managementModule.controller('TaskManagementCtrl', ['TaskCrudSrv', '_userList', '_taskEmptyRes', function TaskManagementCtrl(TaskCrudSrv, _userList, _taskEmptyRes) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, TaskCrudSrv);

    vm.current = _taskEmptyRes;
    vm.users = _userList;

}]);