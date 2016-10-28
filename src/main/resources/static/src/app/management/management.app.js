var managementModule = angular.module('teammateApp.management', []);

managementModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('managementUser', {
            url: '/createuser',
            views: {
                "main": {
                    controller: 'UserManagementCtrl as uCtrl',
                    templateUrl: 'management/user/user.tpl.html'
                }
            },
            data: {
                pageTitle: 'User Definition'
            },
            resolve: {
                _userEmptyRes: ['UserCrudSrv', function (UserCrudSrv) {
                    return UserCrudSrv.create().$promise;
                }],
                _positionsList: ['UserManagementSrv', function (UserManagementSrv) {
                    return UserManagementSrv.positionsList().$promise;
                }],
                _employmentFormsList: ['UserManagementSrv', function (UserManagementSrv) {
                    return UserManagementSrv.employmentFormsList().$promise;
                }]
            }
        })
        .state('managementProject', {
            url: '/createproject',
            views: {
                "main": {
                    controller: 'ProjectManagementCtrl as pmCtrl',
                    templateUrl: 'management/project/project.tpl.html'
                }
            },
            data: {
                pageTitle: 'Project Definition'
            },
            resolve: {
                _projectEmptyRes: ['ProjectCrudSrv', function (ProjectCrudSrv) {
                    return ProjectCrudSrv.create().$promise;
                }],
                _userList: ['UserCrudSrv', function (UserCrudSrv) {
                    return UserCrudSrv.list().$promise;
                }]
            }
        });
}]);