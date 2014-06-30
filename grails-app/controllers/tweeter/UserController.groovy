package tweeter



class UserController {

    def index() {
        User user = User.get(session.userId)
        if(!user) {
            render view: "register"
        }
        [ user:user, strSaved:params.strSaved ]
    }

    def register() {
        User user = User.get(session.userId)
        if(!user) {
            user = new User(params);
            if (!user.save()) {
                return [ user: user ]
            } else {
                session.userId = user.id
                session.username = user.username
                render view: "index", user: user
            }
        }
        else {
            render view: "index", user: user
        }
    }

    def login() {
        User user = User.findByUsername(params.username)
        if (!user) {
            render view: "register"
        }
        else {
            session.userId = user.id
            session.username = user.username
            render view: "index", user: user
        }
    }

    def logout() {
        session.invalidate()
        render view: "register"
    }

    def show() {
        println params
        [ user:User.get(params.id) ]
    }
}
