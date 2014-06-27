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
    }

    def show() {
        [ user:User.get(params.id) ]
    }
}
