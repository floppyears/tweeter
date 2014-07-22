package tweeter

class Tweet {
    static belongsTo = [author: Person]
    String text
    Date dateCreated

    static constraints = {
        text shared: "mustFill", maxSize: 140
    }

    def toMap() {
        [author: [id:this.author.id, username: this.author.username], text: this.text, dateCreated: this.dateCreated]
    }
}
