package tweeter

class Person extends User {
    static hasMany = [tweets: Tweet, groups: Group, follows: User]
    static mappedBy = [tweets: "author", groups: "owner"]
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
