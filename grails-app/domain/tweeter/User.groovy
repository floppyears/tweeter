package tweeter

class User {
    static belongsTo = Person
    static hasMany = [people: UserFollower]
    static mappedBy = [people: "followed"]
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name shared: "mustFill", size: 3..20
    }

    static transients = {
        followers
        followersTweets
    }

    def getFollowersTweets() {
        return followers.tweets.flatten()
    }

    def getFollowers() {
        return people.collect { it.follower }
    }

    void addToFollowers(Person person) {
        UserFollower.link(this, person)
    }

    void removeFromFollowers(Person person) {
        UserFollower.unlink(this, person)
    }
}