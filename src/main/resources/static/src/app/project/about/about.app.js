var projectAboutModule = angular.module( 'teammateApp.project.about', []);

projectAboutModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectnav.about', {
            url: '/about',
            views: {
                "project": {
                    controller: 'AboutCtrl as aCtrl',
                    templateUrl: 'project/about/about.tpl.html'
                }
            },
            data: {
                pageTitle: 'About Project'
            },
            resolve: {
                _currentProject: ['ProjectCrudSrv', '_projectId', function (ProjectCrudSrv, _projectId) {
                    return ProjectCrudSrv.get({id: _projectId}).$promise;
                }],
                _project: ['_projectId', function (_projectId) {
                    return _projectId;
                }]
            }
        });
}]);