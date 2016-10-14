var taskboardModule = angular.module( 'teammateApp.project.taskboard');

taskboardModule.controller('TaskboardCtrl', ['TaskCrudSrv', '_taskList', function TaskboardCtrl(TaskCrudSrv, _taskList) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, TaskCrudSrv);

    vm.tasks = _taskList;

}]);