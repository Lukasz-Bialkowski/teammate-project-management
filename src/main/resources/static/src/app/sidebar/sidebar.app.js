var sidebarModule = angular.module( 'teammateApp.sidebar', [

]);

sidebarModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'sidebar', {
            url: '/sidebar',
            views: {
                "main": {
                    controller: 'SidebarCtrl as sbCtrl',
                    templateUrl: 'sidebar/sidebar.tpl.html'
                }
            },
            data:{ pageTitle: 'Docs' }
        });
}]);