var teammateApp = angular.module( 'teammateApp', [
    'templates-app',
    'templates-common',
    'ui.router',
    'ui.bootstrap',
    'teammateApp.home',
    'teammateApp.project',
    'teammateApp.sidebar',
    'teammateApp.contact',
    'teammateApp.task',
    'ngAnimate'
]);

teammateApp.config(['$stateProvider', '$urlRouterProvider', function myAppConfig ( $stateProvider, $urlRouterProvider ) {
    $urlRouterProvider.otherwise( '/home' );
}]);

teammateApp.run( function run () {});

teammateApp.controller( 'AppCtrl', [ '$scope', '$location', function AppCtrl ( $scope, $location ) {
    var vm = this;
    $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
        if ( angular.isDefined( toState.data.pageTitle ) ) {
            $scope.pageTitle = toState.data.pageTitle + ' | TeamMate' ;
        }
    });
}]);

