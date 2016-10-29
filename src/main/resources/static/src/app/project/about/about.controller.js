var projectAboutModule = angular.module( 'teammateApp.project.about');

projectAboutModule.controller( 'AboutCtrl', ['_currentProject', function AboutCtrl(_currentProject ) {
    var vm = this;
    vm.currentProject = _currentProject;
}]);

