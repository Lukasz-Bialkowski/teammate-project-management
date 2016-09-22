var managementTaskModule = angular.module( 'teammateApp.project.management.task', []);

managementTaskModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'projectnav.managementTask', {
        url: '/createtask',
        views: {
            "project": {
                controller: 'TaskManagementCtrl as tmCtrl',
                templateUrl: 'project/management/task/task.tpl.html'
            }
        },
        data:{ pageTitle: 'Task Definition' }
    });
}]);