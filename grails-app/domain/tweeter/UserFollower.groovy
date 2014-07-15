package tweeter

class UserFollower {
    User followed
    Person follower

    static constraints = {
        followed nullable: false
        follower nullable: false
    }

    static void link(User user, Person person) {
        UserFollower f = UserFollower.findByFollowedAndFollower(user, person)
        if(!f) {
            f = new UserFollower()
            user.addToPeople(f)
            person.addToUsers(f)
            f.save()
        }
    }

    static void unlink(User user, Person person) {
        UserFollower f = UserFollower.findByFollowedAndFollower(user, person)
        if(f) {
            f = new UserFollower()
            user.removeFromPeople(f)
            person.removeFromUsers(f)
            f.delete()
        }
    }
}
