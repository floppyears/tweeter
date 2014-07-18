package tweeter



class UserController {

    def staticPage() {

    }

    def index() {
        User user = User.get(session.userId)
        if(!user) {
            render view: "register"
        }
        [ user:user, strSaved:params.strSaved ]
    }

    def register() {
        Person user = Person.get(session.userId)
        if(!user) {
            user = new Person(params);
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
        Person user = Person.findByUsername(params.username)
        if (!user) {
            render view: "register"
        }
        else {
            session.userId = user.id
            session.username = user.username
            render view: "index", model: [user: user]
        }
    }

    def logout() {
        session.invalidate()
        render view: "register"
    }

    def show() {
        [ user:User.get(params.id) ]
    }
}
