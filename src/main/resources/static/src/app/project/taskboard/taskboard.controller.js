var taskboardModule = angular.module( 'teammateApp.project.taskboard');

taskboardModule.controller('TaskboardCtrl', ['TaskCrudSrv', 'AuthSrv', 'TaskManagementSrv', '_project', '_projectTaskList', '$scope', function TaskboardCtrl(TaskCrudSrv, AuthSrv, TaskManagementSrv, _project, _projectTaskList, $scope) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, TaskCrudSrv);

    vm.tasks = _projectTaskList;
    vm.data = [];

    $scope.models = {
        selected: null,
        lists: {
            TODO: [],
            INPROGRESS: [],
            DONE: []
        }
    };

    vm.accessedByOwner = function (taskOwnerEmail) {
        return AuthSrv.getUser().email === taskOwnerEmail;
    };

    angular.forEach(_projectTaskList, function (value, key) {
        value.loggedHours = countWorklog(value);
        switch (value.status) {
            case 'TODO':
                $scope.models.lists.TODO.push(value);
                break;
            case 'IN_PROGRESS':
                $scope.models.lists.INPROGRESS.push(value);
                break;
            case 'DONE':
                $scope.models.lists.DONE.push(value);
                break;
        }
    });

    function countWorklog(task) {
        var loggedHours = 0;
        task.worklogs.forEach(function (worklog) {
            loggedHours += worklog.workingHours;
        });

        return loggedHours;
    }

    vm.saveTaskboard = function () {
        var temporaryTaskList = [];
        $scope.models.lists.TODO.forEach(function (item) {
            item.status = 'TODO';
            temporaryTaskList.push(item);
        });
        $scope.models.lists.INPROGRESS.forEach(function (item) {
            item.status = 'IN_PROGRESS';
            temporaryTaskList.push(item);
        });
        $scope.models.lists.DONE.forEach(function (item) {
            item.status = 'DONE';
            temporaryTaskList.push(item);
        });
        vm.tasks = [];
        TaskManagementSrv.saveprojecttasklist({projectId: _project}, temporaryTaskList, function (response) {
            vm.tasks = response;
        });
    };

}]);