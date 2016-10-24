var projectDocsModule = angular.module('teammateApp.project.docs');

projectDocsModule.controller('DocsCtrl', ['DocsCrudSrv', '_projectDocsList', '_docsEmptyRes', 'DocsManagementSrv', '_project', '$state', function DocsCtrl(DocsCrudSrv, _projectDocsList, _docsEmptyRes, DocsManagementSrv, _project, $state) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, DocsCrudSrv);

    vm.current = _docsEmptyRes;
    vm.documents = _projectDocsList;
    vm.data = [];

    vm.saveDocument = function () {
        DocsManagementSrv.saveprojectdocument({projectId: _project}, vm.current, function (response) {
            vm.current = response;
            DocsManagementSrv.projectdocuments({projectId: _project}, function (response) {
                vm.documents = response;
            });
        });
    };

    vm.getDocument = function (document) {
        DocsCrudSrv.get({projectId: _project, id: document.id}, function (response) {
            vm.current = response;
        });
    };

    vm.createDocument = function () {
        vm.current = {};
        $state.go('projectnav.docs.createdocument');
    };
}]);

