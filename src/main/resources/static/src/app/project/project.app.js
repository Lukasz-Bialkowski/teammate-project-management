var projectModule = angular.module( 'teammateApp.project', [

]);

projectModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projects', {
            url: '/projects',
            views: {
                "main": {
                    controller: 'ProjectListCtrl as plCtrl',
                    templateUrl: 'project/projectlist.tpl.html'
                }
            },
            data:{ pageTitle: 'Projects' }
        })
        .state( 'project', {
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