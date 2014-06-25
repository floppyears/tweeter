package tweeter

class Tweet {
    int id
    int userId
    String text
    Date createDate

    static constraints = {
        id unique: true
        userId shared: "mustFill"
        text shared: "mustFill", maxSize: 140
        createDate shared: "mustFill"
    }
}
