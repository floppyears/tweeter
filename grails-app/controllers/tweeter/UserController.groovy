package tweeter

class UserController {

    def index() {
        User user;

        if(session) {
            user = session["user"]
        }
        if(!user) {
            render view: "register"
        }
        [ user:user ]
    }

    def register() {
        User newUser = new User();

    }

    def show() {
        [ user:User.get(params.id) ]
    }
}
