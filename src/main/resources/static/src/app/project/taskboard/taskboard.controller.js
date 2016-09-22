var taskboardModule = angular.module( 'teammateApp.project.taskboard');

taskboardModule.controller('TaskboardCtrl', [ function TaskboardCtrl() {
    var vm = this;
    vm.variable = "This is taskboardCtrl variable";

}]);