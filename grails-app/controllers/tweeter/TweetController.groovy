package tweeter

import grails.converters.JSON

class TweetController {
    def tweetService

    def index() {

    }

    def create() {
        Tweet newTweet = tweetService.createTweet(request.JSON)
        render newTweet.toMap() as JSON
    }

    def delete() {

    }

    def show() {

    }

    // Get tweets from users followed by current user
    def getFollowsTweets() {
        Person person = Person.get(session.userId)
        def tweets = tweetService.getFollowsTweets(person)
        render tweets as JSON
    }
}
