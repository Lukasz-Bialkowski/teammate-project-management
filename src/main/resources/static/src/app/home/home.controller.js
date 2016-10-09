var homeModule = angular.module( 'teammateApp.home');

homeModule.controller( 'HomeCtrl', [ function HomeCtrl( ) {
    var vm = this;
    vm.myInterval = 3000;
    vm.slides = [
        {image: 'http://placehold.it/1140x520&text=Slide One', text: 'blah'}
    ];

}]);
