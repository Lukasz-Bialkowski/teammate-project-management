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
                _eventEmptyRes: ['EventCrudSrv', function (EventCrudSrv) {
                    return EventCrudSrv.create().$promise;
                }]
            }
        }).state('projectnav.events.createevent', {
        url: '/events',
        views: {
            "events": {
                templateUrl: 'project/events/create-event.tpl.html'
            }
        },
        data: {
            pageTitle: 'Project Calendar'
        }
    }).state('projectnav.events.viewevent', {
        url: '/events',
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