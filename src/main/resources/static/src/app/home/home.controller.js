var homeModule = angular.module( 'teammateApp.home');

homeModule.controller( 'HomeCtrl', [ function HomeCtrl( ) {
    var vm = this;
    vm.myInterval = 3000;
    vm.slides = [
        { image: 'http://placehold.it/1900x1080&text=Slide One', text: 'blah' },
        { image: 'http://placehold.it/1900x1080&text=Slide Two', text: 'somthing' },
        { image: 'http://placehold.it/1900x1080&text=Slide Three', text: 'teammate' }
    ];

}]);
