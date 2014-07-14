package tweeter

class User {
    static hasMany = [followers: Person]
    static mappedBy = [followers: "follows"]
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name shared: "mustFill", size: 3..20
    }
     /*
    def getFollowing() {
        return User.findAll("from User where ? in elements(followers)", [this])
    }

    static transients = {
        following
    }      */
}