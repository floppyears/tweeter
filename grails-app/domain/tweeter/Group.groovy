package tweeter

class Group extends User {
    String description

    def getTweets() {
        return followers.tweets.flatten()
    }

    static transients = {
        tweets
    }
}
