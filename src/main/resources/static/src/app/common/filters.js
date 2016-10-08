var teammateAppCommon = angular.module('teammateApp.common');

teammateAppCommon.filter('capitalize', function () {
    return function (input) {
        return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
    };
});