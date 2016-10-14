var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.controller('DocsCtrl', ['DocsCrudSrv', '_docsList', '_docsEmptyRes', function DocsCtrl(DocsCrudSrv, _docsList, _docsEmptyRes) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, DocsCrudSrv);

    vm.current = _docsEmptyRes;
    vm.documents = _docsList;
    vm.data = [];
}]);

