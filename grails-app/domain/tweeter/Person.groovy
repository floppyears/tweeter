package tweeter

import tweeter.User

class Person extends User {
    static belongsTo = [followed: User]
    static hasMany = [tweets: Tweet, groups: Group]
    static mappedBy = [groups: "owner"]
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
