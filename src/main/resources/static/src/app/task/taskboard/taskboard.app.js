var taskboardModule = angular.module( 'teammateApp.task.taskboard', [
]);

taskboardModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'taskboard', {
        url: '/taskboard',
        views: {
            "main": {
                controller: 'TaskboardCtrl as tCtrl',
                templateUrl: 'task/taskboard/taskboard.tpl.html'
            }
        },
        data:{ pageTitle: 'Taskboard' }
    });
}]);