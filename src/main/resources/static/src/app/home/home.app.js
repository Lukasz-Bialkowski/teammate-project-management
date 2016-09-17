var homeModule = angular.module( 'teammateApp.home', [

]);

homeModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'home', {
        url: '/home',
        views: {
            "main": {
                controller: 'HomeCtrl as hCtrl',
                templateUrl: 'home/home.tpl.html'
            }
        },
        data:{ pageTitle: 'Home' }
    });
}]);