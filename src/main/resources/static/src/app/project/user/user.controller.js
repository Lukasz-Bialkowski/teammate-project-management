var projectUserDefinitionModule = angular.module('teammateApp.project.user');

projectUserDefinitionModule.controller('ProjectUserCtrl', ['ProjectUserCrudSrv', 'ProjectUserSrv', '_userEmptyRes', '_positionsList', '_employmentFormsList', '_project', function (ProjectUserCrudSrv, ProjectUserSrv, _userEmptyRes, _positionsList, _employmentFormsList, _project) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, ProjectUserCrudSrv);

    vm.selected = {};
    vm.current = _userEmptyRes;
    vm.data = [];
    vm.positionsList = _positionsList;
    vm.employmentFormsList = _employmentFormsList;
    vm.passwordsMatch = false;

    vm.validatePasswordMatch = function () {
        vm.passwordsMatch = (vm.validationPassword === vm.current.passwordHash);
    };

    vm.saveUser = function () {
        ProjectUserSrv.saveprojectmember({projectId: _project}, vm.current, function (response) {
            vm.current = response;
        });
    };

    // DATEPICKER
    vm.dateOptions = {
        dateDisabled: false,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
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