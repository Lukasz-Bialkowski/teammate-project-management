var accountModule = angular.module('teammateApp.account');

accountModule.controller('LoginCtrl', ['AuthSrv', function (AuthSrv) {
    var vm = this;
    vm.current = {
        email: "",
        passwordHash: ""
    };

    vm.enteredDataLost = function (dataLost) {
        if (dataLost) {
            confirm("Are you sure to leave?");
        }
    };

    vm.login = function () {
        AuthSrv.login(vm.current);
    };
}]);

accountModule.controller('RegisterCtrl', ['$scope', 'AuthSrv', function ($scope, AuthSrv) {
    var vm = this;
    vm.current = {};

    // DATEPICKER
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