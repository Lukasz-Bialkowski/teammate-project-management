var taskboardModule = angular.module( 'teammateApp.project.taskboard');

taskboardModule.controller('TaskboardCtrl', ['TaskCrudSrv', function TaskboardCtrl(TaskCrudSrv) {
    var vm = this;
    vm.variable = "This is taskboardCtrl variable";

    TaskCrudSrv.list({}, function (response) {
        vm.theResponse = response;
    });
}]);