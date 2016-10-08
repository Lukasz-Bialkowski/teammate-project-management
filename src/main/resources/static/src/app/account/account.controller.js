var accountModule = angular.module('teammateApp.account');

accountModule.controller('LoginCtrl', ['AuthSrv', '$state', function (AuthSrv, $state) {
    var vm = this;
    vm.current = {
        email: "",
        passwordHash: ""
    };

    vm.cancel = function (dataLost) {
        if (dataLost) {
            var c = confirm("Are you sure to leave?");
            if (c) {
                $state.go("home");
            }
        }
    };

    vm.login = function () {
        AuthSrv.login(vm.current);
    };

}]);

accountModule.controller('RegisterCtrl', ['$scope', 'AuthSrv', function ($scope, AuthSrv) {
}]);