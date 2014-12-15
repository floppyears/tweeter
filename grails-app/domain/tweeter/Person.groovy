package tweeter

class Person extends User {
    static hasMany = [tweets: Tweet, groups: Group, users: UserFollower]
    static mappedBy = [tweets: "author", groups: "owner", users:"follower"]
    String username
    String email

    static constraints = {
        username shared: "mustFill", unique: true, size: 4..15
        email shared: "mustFill", email: true
    }

    static mapping = {
        tweets sort: 'dateCreated', order: 'desc'
    }

    static transients = {
        follows
        followsTweets
    }

    List<Tweet> getFollowsTweets() {
        return follows.tweets.flatten().unique()
    }

    List<User> getFollows() {
        return users.collect { it.followed }
    }

    void addToFollows(User user) {
        UserFollower.link(user, this)
    }

    void removeFromFollows(User user) {
        UserFollower.unlink(user, this)
    }

}
