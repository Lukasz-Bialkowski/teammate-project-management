var projectEventsModule = angular.module('teammateApp.project.events');

projectEventsModule.controller('EventsCtrl', ['moment', '$sce', 'EventCrudSrv', '_userList', '_eventEmptyRes', '_projectEventList', 'EventManagementSrv', '_project', '$state', function EventsCtrl(moment, $sce, EventCrudSrv, _userList, _eventEmptyRes, _projectEventList, EventManagementSrv, _project, $state) {

    var vm = this;
    CrudfsCtrl.call(vm, vm, EventCrudSrv);

    vm.users = _userList;
    vm.current = _eventEmptyRes;
    vm.eventList = _projectEventList;
    vm.data = [];
    vm.eventSources = [];

    transformEvents(_projectEventList);

    vm.saveEvent = function () {
        EventManagementSrv.saveprojectevent({projectId: _project}, vm.current, function (response) {
            vm.current = response;
            EventManagementSrv.projectevents({projectId: _project}, function (response) {
                vm.eventList = response;
                transformEvents(response);
            });
        });
    };

    vm.create = function () {
        EventCrudSrv.create({projectId: _project}, {}, function (response) {
            vm.current = response;
        });
    };

    vm.generateMap = function () {
        return "http://maps.google.com/maps?hl=en&ie=UTF8&q=" + vm.current.location.longitude + "," + vm.current.location.latitude + "&z=15&output=embed";
    };

    vm.trustSrc = function () {
        return $sce.trustAsResourceUrl(vm.generateMap());
    };

    function transformEvents(events) {
        events.forEach(function (event, index) {
            console.log(event + " file");
            vm.eventSources.push(
                {
                    events: [{
                        id: event.id,
                        title: event.name,
                        start: event.eventStartDate,
                        end: event.eventEndDate
                    }]
                }
            );
        });
    }

    vm.uiConfig = {
        calendar: {
            eventClick: function (event) {
                EventCrudSrv.get({projectId: _project, id: event.id}).$promise.then(function (response) {
                    vm.current = response;
                    $state.go('projectnav.events.view');
                });
            },
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
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