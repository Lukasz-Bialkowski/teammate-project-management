var projectEventsModule = angular.module('teammateApp.project.events', []);

projectEventsModule.config(['$stateProvider', function config($stateProvider) {
    $stateProvider
        .state('projectnav.events', {
            abstract: true,
            url: '/events',
            views: {
                "project": {
                    controller: 'EventsCtrl as cCtrl',
                    templateUrl: 'project/events/events.tpl.html'
                }
            },
            data: {
                pageTitle: 'Project Calendar'
            },
            resolve: {
                _userList: ['UserCrudSrv', function (UserCrudSrv) {
                    return UserCrudSrv.list().$promise;
                }],
                _eventEmptyRes: ['EventCrudSrv', '_projectId', function (EventCrudSrv, _projectId) {
                    return EventCrudSrv.create({projectId: _projectId}, {}).$promise;
                }],
                _projectEventList: ['EventManagementSrv', '_projectId', function (EventManagementSrv, _projectId) {
                    return EventManagementSrv.projectevents({projectId: _projectId}).$promise;
                }],
                _project: ['_projectId', function (_projectId) {
                    return _projectId;
                }]
            }
        }).state('projectnav.events.createevent', {
        url: '',
        views: {
            "events": {
                templateUrl: 'project/events/create-event.tpl.html'
            }
        },
        data: {
            pageTitle: 'Project Calendar'
            }
    }).state('projectnav.events.view', {
        url: '/:eventId',
        views: {
            "events": {
                templateUrl: 'project/events/view-event.tpl.html'
            }
        },
        data: {
            pageTitle: 'Project Calendar'
            }
    });
}]);