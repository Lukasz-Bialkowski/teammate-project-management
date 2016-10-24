var projectEventsModule = angular.module('teammateApp.project.events');

projectEventsModule.controller('EventsCtrl', ['moment', 'EventCrudSrv', '_userList', '_eventEmptyRes', '_projectEventList', 'EventManagementSrv', '_project', '$state', function EventsCtrl(moment, EventCrudSrv, _userList, _eventEmptyRes, _projectEventList, EventManagementSrv, _project, $state) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, EventCrudSrv);

    vm.users = _userList;
    vm.current = _eventEmptyRes;
    vm.eventList = _projectEventList;
    vm.data = [];

    vm.saveEvent = function () {
        EventManagementSrv.saveprojectevent({projectId: _project}, vm.current, function (response) {
            vm.current = response;
        });
    };

    vm.eventSources = [
        {
            events: [
                {
                    title: 'Event1',
                    start: '2016-10-10'
                },
                {
                    title: 'Event2',
                    start: '2016-10-11'
                },
                {
                    title: 'Custom event',
                    start: '2016-10-12'
                }
            ],
            color: 'black'
        },
        {
            events: [
                {
                    title: 'Event1',
                    start: '2016-10-10'
                },
                {
                    title: 'Event2',
                    start: '2016-10-11'
                },
                {
                    title: 'Custom event',
                    start: '2016-10-12'
                }
            ],
            color: 'brown'
        }
    ];
    vm.uiConfig = {
        calendar: {
            eventClick: function (event) {
                EventCrudSrv.get({projectId: _project, id: event.id}).$promise.then(function (response) {
                    vm.current = response;
                    $state.go('projectnav.events.viewevent({eventId: event.id})');
                });
                console.log(event);
            }
        }
    };

    // DATEPICKER
    vm.dateOptions = {
        dateDisabled: false,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 5
    };
    vm.togglePopup = function ($event, popupClicked) {
        if ($event) {
            $event.preventDefault();
            $event.stopPropagation();
        }
        if (popupClicked === 'startDate') {
            vm.popup.startDate = !vm.popup.startDate;
        } else {
            vm.popup.endDate = !vm.popup.endDate;
        }
    };
    vm.setDate = function (year, month, day) {
        vm.dt = new Date(year, month, day);
    };
    vm.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    vm.format = vm.formats[0];
    vm.popup = {
        startDate: false,
        endDate: false
    };
}]);