var accountModule = angular.module('teammateApp.account', []);

accountModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('login', {
            url: '/login',
            views: {
                "main": {
                    controller: 'LoginCtrl as lCtrl',
                    templateUrl: 'account/login.tpl.html'
                }
            },
            data: {
                pageTitle: 'Logowanie'
            }
        })
        .state('register', {
            url: '/register',
            views: {
                "main": {
                    controller: 'RegisterCtrl as uCtrl',
                    templateUrl: 'management/user/user.tpl.html'
                }
            },
            data: {
                pageTitle: 'Rejestracja'
            }
        });
}]);