var managementModule = angular.module('teammateApp.management');

managementModule.controller('UserManagementCtrl', ['UserCrudSrv', '_userEmptyRes', '_positionsList', '_employmentFormsList', function (UserCrudSrv, _userEmptyRes, _positionsList, _employmentFormsList) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, UserCrudSrv);

    vm.selected = {};
    vm.current = _userEmptyRes;
    vm.data = [];
    vm.positionsList = _positionsList;
    vm.employmentFormsList = _employmentFormsList;
    vm.passwordsMatch = false;

    vm.validatePasswordMatch = function () {
        vm.passwordsMatch = (vm.validationPassword === vm.current.passwordHash);
    };

    // DATEPICKER
    vm.dateOptions = {
        dateDisabled: false,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 5
    };
    vm.togglePopup = function ($event) {
        if ($event) {
            $event.preventDefault();
            $event.stopPropagation();
        }
        vm.popup.birthDate = !vm.popup.birthDate;
    };
    vm.setDate = function (year, month, day) {
        vm.dt = new Date(year, month, day);
    };
    vm.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    vm.format = vm.formats[0];
    vm.popup = {
        birthDate: false
    };
}]);