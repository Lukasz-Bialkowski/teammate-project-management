var projectTaskDefinitionModule = angular.module('teammateApp.project.task', []);

projectTaskDefinitionModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('projectnav.managementTask', {
            url: '/createtask/:taskId',
            views: {
                "project": {
                    controller: 'TaskManagementCtrl as tmCtrl',
                    templateUrl: 'project/task/task.tpl.html'
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
        });
}]);