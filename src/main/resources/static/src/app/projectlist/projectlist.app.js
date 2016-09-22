var projectListModule = angular.module( 'teammateApp.projectlist', []);

projectListModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectlist', {
            url: '/projectlist',
            views: {
                "main": {
                    controller: 'ProjectListCtrl as plCtrl',
                    templateUrl: 'projectlist/projectlist.tpl.html'
                }
            },
            data:{ pageTitle: 'Projects' }
        });
}]);