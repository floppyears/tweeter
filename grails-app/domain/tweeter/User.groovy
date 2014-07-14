package tweeter

class User {
    static belongsTo = Person
    static hasMany = [followers: Person]
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