var base = '/tweeter';

function toUrl(url) {
    return base + url;
}

function view(name, ctrl) {
    ctrl = (ctrl ? ctrl + '/' : '');
    return base + '/assets/angular/views/' + ctrl + name + '.html';
}

function partial(name, ctrl) {
    return view('_' + name, ctrl);
}

var app = angular.module('Tweeter', []);

app.directive('tweet', function() {
    return {
        restrict: 'E',
        templateUrl: partial('tweet', 'tweet')
    };
});

app.directive('createTweet', function() {
    return {
        restrict: 'E',
        templateUrl: partial('createTweet', 'tweet')
    };
});