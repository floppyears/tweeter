package tweeter

class User {
    static hasMany = [tweets: Tweet]
    String username
    String firstName
    String lastName
    String email
    Date creationDate


    static constraints = {
        username shared: "mustFill", size: 4..15
        firstName shared: "mustFill"
        lastName shared: "mustFill"
        email shared: "mustFill", email: true
    }
}
