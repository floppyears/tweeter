package tweeter

class User {
    static hasMany = [followers: User]
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name shared: "mustFill", size: 3..20
    }

    String getFollowed() {
        return User.findAll("from User where ? in elements(followers)", [this])
    }

    static transients = {
        followed
    }
}
