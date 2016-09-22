var projectCalendarModule = angular.module( 'teammateApp.project.calendar', []);

projectCalendarModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider
        .state( 'projectnav.calendar', {
            url: '/calendar',
            views: {
                "project": {
                    controller: 'CalendarCtrl as cCtrl',
                    templateUrl: 'project/calendar/calendar.tpl.html'
                }
            },
            data:{ pageTitle: 'Project Calendar' }
        });
}]);