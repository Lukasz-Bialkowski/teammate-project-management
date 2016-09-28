var managementUserModule = angular.module('teammateApp.project.management.user');

managementUserModule.controller('UserManagementCtrl', ['$scope', function UserManagementCtrl($scope) {
    var vm = this;
    vm.current = {
        name: "Łukasz",
        surname: "Białkowski",
        dateOfBirth: 123123123123,
        position: {name: 'em', value: 'employee'},
        employmentForm: {name: 'e2e', value: 'e2e'},
        enabled: false
    };

    vm.positionList = [{name: 'em', value: 'employee'}];
    vm.employmentForms = [{name: 'e2e', value: 'e2e'}];

    $scope.today = function () {
        $scope.dt = new Date();
    };
    $scope.today();
    $scope.dateOptions = {
        dateDisabled: false,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 5
    };
    $scope.open2 = function ($event) {
        if ($event) {
            $event.preventDefault();
            $event.stopPropagation(); // This is the magic
        }
        $scope.popup2.opened = true;
    };
    $scope.setDate = function (year, month, day) {
        $scope.dt = new Date(year, month, day);
    };
    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.popup2 = {opened: false};
}]);