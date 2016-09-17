var taskboardModule = angular.module( 'teammateApp.task.taskboard');

taskboardModule.controller('TaskboardCtrl', [ function TaskboardCtrl() {
    var vm = this;
    vm.variable = "This is taskboardCtrl variable";

}]);