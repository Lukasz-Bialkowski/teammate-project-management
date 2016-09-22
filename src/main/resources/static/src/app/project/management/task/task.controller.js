var managementTaskModule = angular.module( 'teammateApp.project.management.task');

managementTaskModule.controller('TaskManagementCtrl', [ function TaskManagementCtrl () {
    var vm = this;
    vm.oneAtATime = false;

    vm.groups = [
        {
          title: "Dynamic Group Header - 1",
          content: "Dynamic Group Body - 1"
        },
        {
          title: "Dynamic Group Header - 2",
          content: "Dynamic Group Body - 2"
        }
    ];
    vm.items = ['Item 1', 'Item 2', 'Item 3'];

    vm.addItem = function() {
        var newItemNo = vm.items.length + 1;
        vm.items.push('Item ' + newItemNo);
    };
}]);