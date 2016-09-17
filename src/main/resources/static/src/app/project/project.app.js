var projectModule = angular.module( 'teammateApp.project', [

]);

projectModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'project', {
        url: '/project',
        views: {
            "main": {
                controller: 'ProjectCtrl as pCtrl',
                templateUrl: 'project/project.tpl.html'
            }
        },
        data:{ pageTitle: 'Project' }
    });
}]);