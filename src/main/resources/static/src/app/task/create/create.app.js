var taskDefinitionModule = angular.module( 'teammateApp.task.definition', [
]);

taskDefinitionModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'taskdefinition', {
        url: '/taskdefinition',
        views: {
            "main": {
                controller: 'TaskDefinitionCtrl as tdCtrl',
                templateUrl: 'task/create/create.tpl.html'
            }
        },
        data:{ pageTitle: 'Task Definition' }
    });
}]);