var managementModule = angular.module('teammateApp.management', [
    'teammateApp.projectnav'
]);

managementModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('projectnav.managementTask', {
            url: '/createtask/:taskId',
            views: {
                "project": {
                    controller: 'TaskManagementCtrl as tmCtrl',
                    templateUrl: 'management/task/task.tpl.html'
                }
            },
            data: {
                pageTitle: 'Task Definition'
            },
            resolve: {
                _userList: ['UserCrudSrv', function (UserCrudSrv) {
                    return UserCrudSrv.list().$promise;
                }],
                _project: ['_projectId', function (_projectId) {
                    return _projectId;
                }],
                _taskEmptyRes: ['TaskCrudSrv', '_projectId', function (TaskCrudSrv, _projectId) {
                    return TaskCrudSrv.create({projectId: _projectId}, {}).$promise;
                }],
                _priorityList: ['TaskManagementSrv', '_projectId', function (TaskManagementSrv, _projectId) {
                    return TaskManagementSrv.prioritylist({projectId: _projectId}).$promise;
                }]
            }
        })
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