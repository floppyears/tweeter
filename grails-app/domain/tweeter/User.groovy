package tweeter

class User {
    static hasMany = [tweets: Tweet]
    String username
    String firstName
    String lastName
    String email
    Date dateCreated

    static constraints = {
        username shared: "mustFill", unique: true, size: 4..15
        firstName shared: "mustFill"
        lastName shared: "mustFill"
        email shared: "mustFill", email: true
    }

    String getName() {
        return firstName << ' ' << lastName
    }

    static transients = {
        name
    }
}
