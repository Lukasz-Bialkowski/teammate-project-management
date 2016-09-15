angular.module( 'teammateApp', [
  'templates-app',
  'templates-common',
  'teammateApp.home',
  'teammateApp.about',
  'ui.router',
  "ngAnimate"
])

.config( function myAppConfig ( $stateProvider, $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/home' );
})

.run( function run () {
})

.controller( 'AppCtrl', function AppCtrl ( $scope, $location ) {
  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle + ' | TeamMate' ;
    }
  });
})

;
