package tweeter

class TweetController {

    def index() {

    }

    def create() {
        User user = User.get(session.userId)
        Tweet tweet = new Tweet([author: user, text:params.text])
        def strSaved = user.save() ? "success" : "fail"
        println tweet.save()
        redirect(view:"index", controller:"user", params:[strSaved:strSaved])
    }

    def delete() {

    }

    def show() {

    }
}
