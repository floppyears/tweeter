package tweeter

class Group extends User {
    static belongsTo = [owner: Person]
    static mappedBy = [owner: "groups"]
    String description

    static transients = {
        tweets
    }

    def getTweets() {
        return followers.tweets.flatten()
    }
}
