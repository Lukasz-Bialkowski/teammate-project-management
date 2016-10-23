var managementModule = angular.module('teammateApp.management');

managementModule.controller('TaskManagementCtrl', ['TaskCrudSrv', '_userList', '_taskEmptyRes', '$stateParams', function TaskManagementCtrl(TaskCrudSrv, _userList, _taskEmptyRes, $stateParams) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, TaskCrudSrv);
    vm.loggedHours = 0;
    vm.users = _userList;
    vm.data = [];
    vm.newWorklog = {};


    if ($stateParams.taskId) {
        TaskCrudSrv.get({id: $stateParams.taskId}).$promise.then(function (response) {
            vm.current = response;
            vm.loggedHours = countLoggedHours(response.worklogs);
        });
    } else {
        vm.current = _taskEmptyRes;
    }

    function countLoggedHours(worklogs) {
        var loggedHours = 0;
        worklogs.forEach(function (worklog) {
            loggedHours += worklog.workingHours;
        });

        return loggedHours;
    }

    vm.addWorklog = function () {
        vm.current.worklogs.push(vm.newWorklog);
        TaskCrudSrv.save(vm.current, function (response) {
            vm.loggedHours = countLoggedHours(response.worklogs);
            window.location.reload();
        });
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
        vm.popup.workDate = !vm.popup.workDate;
    };
    vm.setDate = function (year, month, day) {
        vm.dt = new Date(year, month, day);
    };
    vm.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    vm.format = vm.formats[0];
    vm.popup = {
        workDate: false
    };
}]);