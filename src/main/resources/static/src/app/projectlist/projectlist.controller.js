var projectListModule = angular.module( 'teammateApp.projectlist');

projectListModule.controller('ProjectListCtrl', ['_projectList', function ProjectListCtrl(_projectList) {
    var vm = this;

    vm.projects = _projectList;



}]);