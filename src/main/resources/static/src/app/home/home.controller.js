var homeModule = angular.module( 'teammateApp.home');

homeModule.controller('HomeCtrl', ['$scope', function HomeCtrl($scope) {
    var vm = this;
    $scope.myInterval = 5000;
    $scope.active = 1;
    var slides = $scope.slides = [];
    var currIndex = 1;

    $scope.addSlide = function () {
        var newWidth = 1140 + slides.length + 1;
        slides.push({
            image: '//unsplash.it/' + newWidth + '/520',
            text: ['Teammate team', 'Powerful design', 'That is so cool'][slides.length % 3],
            id: currIndex++
        });
    };

    for (var i = 0; i < 3; i++) {
        $scope.addSlide();
    }
}]);
