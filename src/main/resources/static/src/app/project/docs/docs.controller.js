var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.controller('DocsCtrl', ['DocsCrudSrv', function DocsCtrl(DocsCrudSrv) {
    var vm = this;
    vm.someVariable = "This is a test variable";

    DocsCrudSrv.list({}, function list(serverResponse) {
        vm.theResponse = serverResponse;
    });

}]);

