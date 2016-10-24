var projectDocsModule = angular.module( 'teammateApp.project.docs', [
]);

projectDocsModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectnav.docs', {
            url: '/document',
            views: {
                "project": {
                    controller: 'DocsCtrl as dCtrl',
                    templateUrl: 'project/docs/docs.tpl.html'
                }
            },
            data: {
                pageTitle: 'Dokumenty'
            },
            resolve: {
                _projectDocsList: ['DocsManagementSrv', '_projectId', function (DocsManagementSrv, _projectId) {
                    return DocsManagementSrv.projectdocuments({projectId: _projectId}).$promise;
                }],
                _docsEmptyRes: ['DocsCrudSrv', '_projectId', function (DocsCrudSrv, _projectId) {
                    return DocsCrudSrv.create({projectId: _projectId}, {}).$promise;
                }],
                _project: ['_projectId', function (_projectId) {
                    return _projectId;
                }]
            }
        })
        .state('projectnav.docs.createdocument', {
            url: '/new',
            views: {
                "document": {
                    templateUrl: 'project/docs/create-document.tpl.html'
                }
            },
            data: {
                pageTitle: 'Dokumenty'
            }
        })
        .state('projectnav.docs.viewdocument', {
            url: '/view/:documentName',
            views: {
                "document": {
                    templateUrl: 'project/docs/view-document.tpl.html'
                }
            },
            data: {
                pageTitle: 'Dokumenty'
            }
        });
}]);