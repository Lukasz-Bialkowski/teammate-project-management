var projectNavModule = angular.module('teammateApp.projectnav', [
    'teammateApp.project.about',
    'teammateApp.project.events',
    'teammateApp.project.docs',
    'teammateApp.project.taskboard',
    'teammateApp.project.task',
    'teammateApp.project.user'
]);

projectNavModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectnav', {
            abstract: true,
            url: '/project/:projectId',
            views: {
                "main": {
                    controller: 'ProjectNavCtrl as pnCtrl',
                    templateUrl: 'project/projectnav.tpl.html'
                }
            },
            data: {
                pageTitle: 'Project'
            },
            resolve: {
                _currentProject: ['ProjectCrudSrv', '$stateParams', function (ProjectCrudSrv, $stateParams) {
                    return ProjectCrudSrv.get({id: $stateParams.projectId}).$promise;
                }],
                _projectId: ['$stateParams', function ($stateParams) {
                    return $stateParams.projectId;
                }]
            }
        });
}]);
