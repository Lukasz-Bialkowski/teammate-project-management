var teammateApp = angular.module( 'teammateApp', [
    'templates-app',
    'templates-common',
    'ui.router',
    'ui.bootstrap',
    'teammateApp.home',
    'teammateApp.projectlist',
    'teammateApp.projectnav',
    'teammateApp.contact',
    'teammateApp.common',
    'teammateApp.account',
    'ngAnimate',
    'ngResource'
]);

teammateApp.config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function myAppConfig($stateProvider, $urlRouterProvider, $httpProvider) {
    $urlRouterProvider.otherwise( '/home' );
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);

teammateApp.run( function run () {});

teammateApp.controller( 'AppCtrl', [ '$scope', '$location', function AppCtrl ( $scope, $location ) {
    var vm = this;
    $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
        if ( angular.isDefined( toState.data.pageTitle ) ) {
            $scope.pageTitle = toState.data.pageTitle + ' | TeamMate' ;
        }
    });

    // TODO Implement userSessionSrv
    // TODO Extract Management directories and states (task, taskboard)
    // vm.authenticated = userSessionSrv.isAuthenticated;
    // vm.login = userSessionSrv.login;
    // vm.logout = userSessionSrv.logout;

}]);

