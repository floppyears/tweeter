app.controller('userController', function($scope, $stateParams, $http) {
    $scope.message = "Angular welcome!"

    if($stateParams.username) {
        $http.get(
            "user/userByName",
            {params:{username: $stateParams.username}}
        ).success(function(data){
            $scope.user = data;
        });
    }

});