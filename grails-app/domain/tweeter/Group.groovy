package tweeter

import tweeter.User

class Group extends User {
    Person owner
    String description

    def getTweets() {
        return followers.tweets.flatten()
    }

    static transients = {
        tweets
    }
}
