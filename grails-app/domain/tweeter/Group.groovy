package tweeter

class Group extends User {
    static belongsTo = [owner: Person]
    String description

    String getTweets() {
        return Tweet.findAllByAuthor(followers)
    }

    static transients = {
        tweets
    }
}
