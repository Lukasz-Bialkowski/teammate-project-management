var projectCalendarModule = angular.module( 'teammateApp.project.calendar');

projectCalendarModule.controller('CalendarCtrl', [function CalendarCtrl() {
    var vm = this;
    vm.current = {
        eventStartTime: new Date(),
        eventEndDate: new Date()
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