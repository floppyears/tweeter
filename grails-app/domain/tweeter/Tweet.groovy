package tweeter

class Tweet {
    static belongsTo = [author: User]
    String text
    Date dateCreated

    static constraints = {
        text shared: "mustFill", maxSize: 140
    }
}
