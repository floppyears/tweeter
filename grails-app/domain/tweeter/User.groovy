package tweeter

class User {
    static hasMany = [tweet: Tweet]
    int id
    String username
    String firstname
    String lastname
    String email


    static constraints = {
        id unique: true
        username shared: "mustFill", size: 4..15
        firstname shared: "mustFill"
        lastname shared: "mustFill"
        email shared: "mustFill", email: true
    }
}
