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
                _docsList: ['DocsCrudSrv', function (DocsCrudSrv) {
                    return DocsCrudSrv.list().$promise;
                }],
                _docsEmptyRes: ['DocsCrudSrv', function (DocsCrudSrv) {
                    return DocsCrudSrv.create().$promise;
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