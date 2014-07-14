package tweeter

class Group extends User {

    static belongsTo = [owner: Person]
    static mappedBy = [owner: "groups"]
    String description

    def getTweets() {
        return followers.tweets.flatten()
    }

    static transients = {
        tweets
    }
}
