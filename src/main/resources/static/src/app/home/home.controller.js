var homeModule = angular.module( 'teammateApp.home');

homeModule.controller('HomeCtrl', ['$scope', function HomeCtrl($scope) {
    var vm = this;
    $scope.myInterval = 5000;
    $scope.active = 0;
    var currIndex = 0;
    $scope.slides = [
        {
            title: 'Work effortless',
            image: 'assets/project-management.jpg',
            text: 'Teammate makes project managment effortless',
            id: currIndex++
        },
        {
            title: 'Communicate easily',
            image: 'assets/project-communication.jpg',
            text: 'Teammate improve project communication',
            id: currIndex++
        }
    ];
}]);
