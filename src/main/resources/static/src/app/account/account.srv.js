var accountModule = angular.module('teammateApp.account');

accountModule.factory('AuthSrv', ['$state', '$http', function AuthSrv($state, $http) {
    var credentials = {};

    return {
        login: function (userData) {
            var httpUrl = "/teammate/login";
            var params = "username=" + userData.email + "&password=" + userData.passwordHash;
            var httpHeaders = {'Content-Type': 'application/x-www-form-urlencoded'};

            return $http.post(httpUrl, params, {headers: httpHeaders})
                .then(function (data) {
                    alert("Sukces logowania");
                    localStorage.setItem("userSession", data);
                    credentials = userData;
                    $state.go("home");
                }, function () {
                    alert("Błąd logowania");
                });
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