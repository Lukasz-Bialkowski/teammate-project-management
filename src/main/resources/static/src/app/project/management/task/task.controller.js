var managementTaskModule = angular.module( 'teammateApp.project.management.task');

managementTaskModule.controller('TaskManagementCtrl', [ function TaskManagementCtrl () {
    var vm = this;
    vm.current = {
        name: "Colorfull tooltip in nvd3",
        id: 'SECMGE12322',
        storyPoints: 10,
        owner: {name: "Łukasz Białkowski", value: "Something"}
    };
    vm.users = [{name: "Łukasz Białkowski", value: "Something"}];
}]);