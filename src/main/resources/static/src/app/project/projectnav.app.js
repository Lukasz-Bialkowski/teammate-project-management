var projectNavModule = angular.module('teammateApp.projectnav', [
    'teammateApp.project.about',
    'teammateApp.project.events',
    'teammateApp.project.docs',
    'teammateApp.project.taskboard'
]);

projectNavModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectnav', {
            abstract: true,
            url: '/project',
            views: {
                "main": {
                    controller: 'ProjectNavCtrl as pnCtrl',
                    templateUrl: 'project/projectnav.tpl.html'
                }
            },
            data:{ pageTitle: 'Project' }
        });
}]);
