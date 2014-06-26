package tweeter

class Tweet {
    static belongsTo = [author: User]
    String text
    Date createDate

    static constraints = {
        text shared: "mustFill", maxSize: 140
        createDate shared: "mustFill"
    }
}
