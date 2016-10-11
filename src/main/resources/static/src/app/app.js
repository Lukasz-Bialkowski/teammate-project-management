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
    'teammateApp.management',
    'teammateApp.account',
    'ngAnimate',
    'ngResource',
    'ui.calendar'
]);

teammateApp.config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function myAppConfig($stateProvider, $urlRouterProvider, $httpProvider) {
    $urlRouterProvider.otherwise( '/home' );
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);

teammateApp.run( function run () {});

teammateApp.controller('AppCtrl', ['$scope', 'AuthSrv', function AppCtrl($scope, AuthSrv) {
    var vm = this;
    $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
        if ( angular.isDefined( toState.data.pageTitle ) ) {
            $scope.pageTitle = toState.data.pageTitle + ' | TeamMate' ;
        }
    });

    vm.isAuthenticated = AuthSrv.isAuthenticated;
    vm.logout = AuthSrv.logout;

}]);

