package tweeter

class Tweet {
    static belongsTo = [author: User]
    int id
    String text
    Date createDate

    static constraints = {
        id unique: true
        text shared: "mustFill", maxSize: 140
        createDate shared: "mustFill"
    }
}
