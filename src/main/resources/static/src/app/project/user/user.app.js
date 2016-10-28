var projectUserDefinitionModule = angular.module('teammateApp.project.user', []);

projectUserDefinitionModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('projectnav.managementUser', {
            url: '/user',
            views: {
                "project": {
                    controller: 'ProjectUserCtrl as uCtrl',
                    templateUrl: 'project/user/user.tpl.html'
                }
            },
            data: {
                pageTitle: 'User Definition'
            },
            resolve: {
                _userEmptyRes: ['ProjectUserCrudSrv', function (ProjectUserCrudSrv) {
                    return ProjectUserCrudSrv.create().$promise;
                }],
                _project: ['_projectId', function (_projectId) {
                    return _projectId;
                }],
                _positionsList: ['ProjectUserManagementSrv', function (ProjectUserManagementSrv) {
                    return ProjectUserManagementSrv.positionsList().$promise;
                }],
                _employmentFormsList: ['ProjectUserManagementSrv', function (ProjectUserManagementSrv) {
                    return ProjectUserManagementSrv.employmentFormsList().$promise;
                }]
            }
        });
}]);