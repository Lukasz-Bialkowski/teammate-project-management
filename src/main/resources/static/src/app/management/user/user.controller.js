var managementModule = angular.module('teammateApp.management');

managementModule.controller('UserManagementCtrl', ['UserCrudSrv', '_userEmptyRes', '_positionsList', '_employmentFormsList', function (UserCrudSrv, _userEmptyRes, _positionsList, _employmentFormsList) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, UserCrudSrv);

    vm.selected = {};
    vm.current = _userEmptyRes;
    vm.data = [];
    vm.positionsList = _positionsList;
    vm.employmentFormsList = _employmentFormsList;

    // vm.save = save;
    // vm.remove = remove;
    // vm.create = create;
    // vm.get = get;
    // vm.list = list;
    //
    // function list() {
    //     UserCrudSrv.list({}, function (response) {
    //         vm.data = response;
    //     });
    // }
    //
    // function get(item) {
    //     UserCrudSrv.get({id: item.id}, function (response) {
    //         processSelect(item, response);
    //     });
    // }
    //
    // function processSelect(item, response) {
    //     vm.selected = item;
    //     vm.current = response;
    // }
    //
    // function create() {
    //     UserCrudSrv.create(function (response) {
    //         processCreate(response);
    //     });
    // }
    //
    // function processCreate(response) {
    //     vm.selected = null;
    //     vm.current = response;
    //     vm.current.dateOfBirth = new Date();
    // }
    //
    // function save(item) {
    //     UserCrudSrv.save(item, function (response) {
    //         console.log(response);
    //         processSave(item, response);
    //     });
    // }
    //
    // function itemIndexInDataArray(item) {
    //     return vm.data
    //         .map(function (x) {
    //             return x.id;
    //         })
    //         .indexOf(item.id);
    // }
    //
    // function processSave(item, response) {
    //     if (item.id) {
    //         vm.data[itemIndexInDataArray(item)] = item;
    //         vm.selected = item;
    //         vm.current = response;
    //     } else {
    //         vm.selected = jQuery.extend(true, {}, response);
    //         vm.data.push(vm.selected);
    //         vm.current = response;
    //     }
    // }
    //
    // function remove(item) {
    //     UserCrudSrv.remove({id: item.id}, function () {
    //         processRemove(item);
    //     });
    // }
    //
    // function processRemove(item) {
    //     vm.data.splice(itemIndexInDataArray(item), 1);
    //     vm.selected = {};
    //     vm.current = {};
    // }
    //
    // function reset() {
    //     vm.current = {};
    // }

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