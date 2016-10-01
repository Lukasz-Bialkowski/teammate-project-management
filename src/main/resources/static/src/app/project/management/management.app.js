var managementModule = angular.module('teammateApp.project.management', []);

managementModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('projectnav.managementTask', {
            url: '/createtask',
            views: {
                "project": {
                    controller: 'TaskManagementCtrl as tmCtrl',
                    templateUrl: 'project/management/task/task.tpl.html'
                }
            },
            data: {
                pageTitle: 'Task Definition'
            },
            resolve: {
                _userList: ['UserCrudSrv', function (UserCrudSrv) {
                    return UserCrudSrv.list().$promise;
                }],
                _taskEmptyRes: ['TaskCrudSrv', function (TaskCrudSrv) {
                    return TaskCrudSrv.create().$promise;
                }]
            }
        })
        .state('projectnav.managementUser', {
            url: '/createuser',
            views: {
                "project": {
                    controller: 'UserManagementCtrl as uCtrl',
                    templateUrl: 'project/management/user/user.tpl.html'
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
        .state('projectnav.managementProject', {
            url: '/createproject',
            views: {
                "project": {
                    controller: 'ProjectManagementCtrl as pmCtrl',
                    templateUrl: 'project/management/project/project.tpl.html'
                }
            },
            data: {
                pageTitle: 'Project Definition'
            },
            resolve: {
                _projectEmptyRes: ['ProjectCrudSrv', function (ProjectCrudSrv) {
                    return ProjectCrudSrv.create().$promise;
                }]
            }
        });
}]);