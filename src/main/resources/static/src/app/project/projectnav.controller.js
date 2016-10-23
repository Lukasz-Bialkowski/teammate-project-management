var projectNavModule = angular.module( 'teammateApp.projectnav');

projectNavModule.controller('ProjectNavCtrl', ['_currentProject', function ProjectNavCtrl(_currentProject) {
    var vm = this;
    vm.currentProject = _currentProject;
}]);

