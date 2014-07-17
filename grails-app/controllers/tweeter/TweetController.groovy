package tweeter

class TweetController {
    TweetService ts

    def index() {

    }

    def create() {
        Person person = Person.get(session.userId)
        flash.tweetMsg = ts.createTweet(person, params.text) ? "success" : "fail"
        redirect(view:"index", controller:"user")
    }

    def delete() {

    }

    def show() {

    }
}
