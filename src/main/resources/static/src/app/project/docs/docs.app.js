var projectDocsModule = angular.module( 'teammateApp.project.docs', [

]);

projectDocsModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectnav.docs', {
            url: '/docs',
            views: {
                "project": {
                    controller: 'DocsCtrl as dCtrl',
                    templateUrl: 'project/docs/docs.tpl.html'
                }
            },
            data: {
                pageTitle: 'Docs'
            }
        });
}]);