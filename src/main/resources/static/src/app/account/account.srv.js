var accountModule = angular.module('teammateApp.account');

accountModule.factory('AuthSrv', ['$state', '$http', function AuthSrv($state, $http) {
    var credentials = {};

    return {
        login: function (userData) {
            var httpUrl = "login";
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
            $http.post('logout', {}).then(function () {
                alert("Zostałeś wylogowany");
                localStorage.removeItem("userSession");
                credentials = {};
                $state.go("home");
            });
        },
        isAuthenticated: function () {
            return localStorage.getItem("userSession") !== null;
        },
        getUser: function () {
            return credentials;
        }
    };
}]);