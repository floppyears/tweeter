app.controller('userController', function($scope, $http) {
    $scope.message = "Angular welcome!";

    $scope.getFollowsTweets = function() {
        $http.get(
            "/tweeter/tweet/getFollowsTweets"
        ).success(function(data) {
            $scope.tweets = new Array();
            for(var key in data) {
                $scope.tweets.push(data[key]);
            }
            if (!$scope.$$phase) {
                $scope.$apply();
            }
        });
    };

    if ($scope.user === undefined || $scope.user === null) {
        $http.get(
            "user/currentUser"
        ).success(function(data){
            $scope.user = data;
        });
    }

    $scope.saveTweet = function(tweet) {
        var newTweet = angular.copy(tweet);
        newTweet.author = {};
        newTweet.author.id = $scope.user.id;
        newTweet.author.username = $scope.user.username;
        $http.post(
            "tweet/create",
            newTweet
        ).success(function(data) {
            $scope.tweet.text = '';
            $scope.tweets.push(data);
        });
    };

    $scope.getFollowsTweets();
});