var managementUserModule = angular.module( 'teammateApp.project.management.user', []);

managementUserModule.config(['$stateProvider', function config( $stateProvider ) {
    $stateProvider.state( 'projectnav.managementUser', {
        url: '/createuser',
        views: {
            "project": {
                controller: 'UserManagementCtrl as uCtrl',
                templateUrl: 'project/management/user/user.tpl.html'
            }
        },
        data:{ pageTitle: 'User Definition' }
    });
}]);