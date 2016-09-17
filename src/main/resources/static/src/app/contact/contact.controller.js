var contactModule = angular.module( 'teammateApp.contact');

contactModule.controller( 'ContactCtrl', [ function ContactCtrl ( ) {
    var vm = this;
    vm.dropdownDemoItems = [
        "The first choice!",
        "And another choice for you.",
        "but wait! A third!"
    ];
}]);