var accountModule = angular.module('teammateApp.account');

accountModule.factory('AuthSrv', ['$resource', function ($resource) {
    var contextPath = 'http://localhost:8080/teammate/';
    var crudResourceMapping = '/auth';

    return $resource(contextPath + crudResourceMapping + '/:id/:secId/:operation/:page', {}, {
        credentials: {
            params: {
                method: 'GET',
                params: {
                    operation: 'credentials'
                }
            }
        }
    });
}]);

// THIS SERVICE STORES ACCTUALY LOGGED USER
accountModule.factory('sessionService', ['$state', function ($state) {
    var credentials = {};
    return {
        login: function (userData) {
            alert('Zalogowany jako ' + userData.login);
            localStorage.setItem("userSession", userData);
            credentials = userData;
        },
        logout: function () {
            localStorage.removeItem("userSession");
            $state.go("home");
        },
        isAuthenticated: function () {
            return localStorage.getItem("userSession") !== null;
        },
        getUser: function () {
            return credentials;
        }
    };
}]);