package tweeter

class Person extends User {
    static belongsTo = User
    static hasMany = [tweets: Tweet, groups: Group, follows: User]
    static mappedBy = [tweets: "author", groups: "owner", follows: "followers"]
    String username
    String email

    static constraints = {
        username shared: "mustFill", unique: true, size: 4..15
        email shared: "mustFill", email: true
    }

    static mapping = {
        tweets sort: 'dateCreated', order: 'desc'
    }

}
