package tweeter



class UserController {

    def index() {
        if(!session.user) {
            render view: "register"
        }
        [ user:session.user ]
    }

    def register() {
        if(!session.user) {
            User newUser = new User(params);
            newUser.creationDate = new Date()
            if (!newUser.save()) {
                return [ user: newUser ]
            } else {
                session.user = newUser
                render view: "index.gsp", user: newUser
            }
        }
        else {
            render view: "index", user: session.user
        }
    }

    def login() {
        User user = User.findByUsername(params.username)
        if (!user) {
            render view: "register"
        }
        else {
            session.user = user
            render view: "index", user: user
        }
    }

    def logout() {
        session.user = null
        render view: "register"
    }

    def show() {
        [ user:User.get(params.id) ]
    }
}
