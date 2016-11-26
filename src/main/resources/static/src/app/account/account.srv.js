var accountModule = angular.module('teammateApp.account');

accountModule.factory('AuthSrv', ['$state', '$http', function AuthSrv($state, $http) {
    var principal = {};

    return {
        login: function (userData) {
            var httpUrl = "login";
            var params = "username=" + userData.email + "&password=" + userData.passwordHash;
            var httpHeaders = {'Content-Type': 'application/x-www-form-urlencoded'};

            return $http.post(httpUrl, params, {headers: httpHeaders})
                .then(function (data) {
                    alert("Logging Successful");
                    localStorage.setItem("userSession", data);
                    $http.get("auth/credentials").then(function (response) {
                        principal = response.data;
                    });
                    $state.go("home");
                }, function () {
                    alert("Error accured while logging in");
                });
        },
        logout: function () {
            $http.post('logout', {}).then(function () {
                alert("You've been correctly logged out");
                localStorage.removeItem("userSession");
                principal = {};
                $state.go("home");
            });
        },
        isAuthenticated: function () {
            return localStorage.getItem("userSession") !== null;
        },
        getUser: function () {
            return principal;
        }
    };
}]);