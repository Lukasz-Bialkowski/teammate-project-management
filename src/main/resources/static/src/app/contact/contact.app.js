var contactModule = angular.module( 'teammateApp.contact', [
    'placeholders'
]);

contactModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'contact', {
        url: '/contact',
        views: {
            "main": {
            controller: 'ContactCtrl as cCtrl',
            templateUrl: 'contact/contact.tpl.html'
            }
        },
        data: {pageTitle: 'Contact us'}
    });
}]);

