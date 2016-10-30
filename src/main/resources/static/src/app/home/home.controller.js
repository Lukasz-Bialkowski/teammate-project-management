var homeModule = angular.module( 'teammateApp.home');

homeModule.controller('HomeCtrl', ['$scope', function HomeCtrl($scope) {
    var vm = this;
    $scope.myInterval = 5000;
    $scope.active = 0;
    var slides = $scope.slides = [];
    var currIndex = 0;

    $scope.addSlide = function () {
        var newWidth = 1140 + slides.length + 1;
        slides.push({
            image: '//unsplash.it/' + newWidth + '/520',
            text: ['Nice image', 'Awesome photograph', 'That is so cool', 'I love that'][slides.length % 4],
            id: currIndex++
        });
    };

    for (var i = 0; i < 4; i++) {
        $scope.addSlide();
    }
}]);
