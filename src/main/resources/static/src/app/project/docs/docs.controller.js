var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.controller('DocsCtrl', ['DocsCrudSrv', function DocsCtrl(DocsCrudSrv) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, DocsCrudSrv);

}]);

