var base = '/tweeter';

function toUrl(url) {
    return base + url;
}

function view(name, ctrl) {
    ctrl = (ctrl ? ctrl + '/' : '');
    return '/tweeter/assets/angular/views/' + ctrl + name + '.html';
}

function partial(name, ctrl) {
    return view('_' + name, ctrl);
}

var app = angular.module('Tweeter', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('home', {
            url: toUrl('/'),
            templateUrl: view('home'), //'tweeter/assets/angular/views/home.html',
            controller: 'mainController'
        })
        .state('home.register', {
            url: toUrl('/register'),
            templateUrl: view('register', 'user'),
            controller: 'userController'
        })
        .state('user', {
            url: toUrl('/user/:username'),
            templateUrl: view('index', 'user'),
            controller: 'userController'
        });
    $locationProvider.html5Mode(true);
});

app.directive('tweet', function() {
    return {
        restrict: 'E',
        templateUrl: partial('tweet', 'tweet')
    };
});