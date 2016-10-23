var taskboardModule = angular.module( 'teammateApp.project.taskboard');

taskboardModule.controller('TaskboardCtrl', ['TaskCrudSrv', '_taskList', '$scope', function TaskboardCtrl(TaskCrudSrv, _taskList, $scope) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, TaskCrudSrv);

    vm.tasks = _taskList;
    vm.data = [];

    $scope.models = {
        selected: null,
        lists: {
            TODO: [],
            INPROGRESS: [],
            DONE: []
        }
    };

    angular.forEach(_taskList, function (value, key) {
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

    $scope.lists = [
        {
            label: "Men",
            allowedTypes: ['man'],
            max: 4,
            people: [
                {name: "Bob", type: "man"},
                {name: "Charlie", type: "man"},
                {name: "Dave", type: "man"}
            ]
        },
        {
            label: "Women",
            allowedTypes: ['woman'],
            max: 4,
            people: [
                {name: "Alice", type: "woman"},
                {name: "Eve", type: "woman"},
                {name: "Peggy", type: "woman"}
            ]
        },
        {
            label: "People",
            allowedTypes: ['man', 'woman'],
            max: 6,
            people: [
                {name: "Frank", type: "man"},
                {name: "Mallory", type: "woman"},
                {name: "Alex", type: "unknown"},
                {name: "Oscar", type: "man"},
                {name: "Wendy", type: "woman"}
            ]
        }
    ];

}]);