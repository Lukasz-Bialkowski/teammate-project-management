var homeModule = angular.module( 'teammateApp.home');

homeModule.controller('HomeCtrl', ['$scope', function HomeCtrl($scope) {
    var vm = this;
    $scope.myInterval = 5000;
    $scope.active = 0;
    var slides = $scope.slides = [];
    var currIndex = 0;

    $scope.addSlide = function () {
        slides.push({
            image: 'http://placehold.it/1140x520&text=Slide One',
            text: ['Teammate team', 'Powerful design', 'That is so cool'][slides.length % 3],
            id: currIndex++
        });
    };

    for (var i = 0; i < 3; i++) {
        $scope.addSlide();
    }
}]);
