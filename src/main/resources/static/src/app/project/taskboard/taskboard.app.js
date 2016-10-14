var taskboardModule = angular.module( 'teammateApp.project.taskboard', []);

taskboardModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'projectnav.taskboard', {
        url: '/taskboard',
        views: {
            "project": {
                controller: 'TaskboardCtrl as tCtrl',
                templateUrl: 'project/taskboard/taskboard.tpl.html'
            }
        },
        data: {
            pageTitle: 'Taskboard'
        },
        resolve: {
            _taskList: ['TaskCrudSrv', function (TaskCrudSrv) {
                return TaskCrudSrv.list().$promise;
            }]
        }
    });
}]);