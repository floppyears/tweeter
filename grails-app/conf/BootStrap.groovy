import tweeter.Group
import tweeter.Person
import tweeter.Tweet

class BootStrap {
    List<Person> people


    def init = { servletContext ->
        println "BOOTSTRAP INIT"
        makePeople()
        makeGroups()
        makeFollowers()
        makeTweets()
    }

    def destroy = {
        println "BOOTSTRAP DESTROY"
        removeTweets()
        removeGroups()
        removePeople()
    }

    def makePeople() {
        println "MAKE PEOPLE"
        Person andy = new Person(name: "Andy Warhog", username: "warand", email: "andy.warhog@example.com")
        Person jen = new Person(name: "Jennifer Cohen", username: "cohjen", email: "jen.cohen@example.com")
        Person kira = new Person(name: "Kiralyn Ludwig", username: "ludkir", email: "kira.ludwig@example.com")
        Person ken = new Person(name: "Kenneth Winehold", username: "winken", email: "ken.whinehold@example.com")
        Person bob = new Person(name: "Robert Cole", username: "colrob", email: "robert.cole@example.com")

        people = []
        people << andy
        people << jen
        people << kira
        people << ken
        people << bob
        for(person in people) {
            if(!person.save()) {
                println person.errors
            }
        }
    }

    def makeFollowers() {
        println "MAKE FOLLOWERS"
        people[0].addToFollowers(people[1])
        people[0].addToFollowers(people[2])
        people[0].save()

        println "ADDING TO JEN"
        people[1].addToFollowers(people[2])
        people[1].addToFollowers(people[3])
        people[1].addToFollowers(people[4])
        people[1].save()

        println "ADDING TO KIRA"
        people[2].addToFollowers(people[0])
        people[2].addToFollowers(people[3])
        people[2].addToFollowers(people[4])
        people[2].save()

        println "ADDING TO KEN"
        people[3].addToFollowers(people[0])
        people[3].addToFollowers(people[1])
        people[3].save()

        println "ADDING TO BOB"
        people[4].addToFollowers(people[3])
        people[4].save()

        /*
        println "SAVING FOLLOWERS"
        for(person in people) {
            println "SAVING: " << person
            println person.followers
            println person.save()
            println person.errors
        }*/
    }

    def makeGroups() {
        println "MAKE GROUPS"
        Group grpOne = new Group(name: "Group 1", description: "Users andy, jen, and kira.", owner: people[0])
        Group grpTwo = new Group(name: "Group 2", description: "Users ken, and bob.", owner: people[3])
        Group grpThree = new Group(name: "Group 3", description: "Users andy, jen, kira, ken, and bob.", owner: people[1])


        assert grpOne.save()
        assert grpTwo.save()
        assert grpThree.save()

        grpOne.addToFollowers(people[0])
        grpOne.addToFollowers(people[1])
        grpOne.addToFollowers(people[2])

        grpTwo.addToFollowers(people[3])
        grpTwo.addToFollowers(people[4])

        grpThree.addToFollowers(people[0])
        grpThree.addToFollowers(people[1])
        grpThree.addToFollowers(people[2])
        grpThree.addToFollowers(people[3])
        grpThree.addToFollowers(people[4])


        assert grpOne.save()
        assert grpTwo.save()
        assert grpThree.save()
    }

    def makeTweets() {
        println "MAKE TWEETS"
        Tweet andyTweet = new Tweet([author: people[0], text: "Andy's tweet!"])
        Tweet jenTweet = new Tweet(author: people[1], text: "Jen's tweet!")
        Tweet kiraTweet = new Tweet(author: people[2], text: "Kira's tweet!")
        Tweet kenTweet = new Tweet(author: people[3], text: "Ken's tweet!")
        Tweet bobTweet = new Tweet(author: people[4], text: "Bob's tweet!")

        people[0].addToTweets(andyTweet)
        people[1].addToTweets(jenTweet)
        people[2].addToTweets(kiraTweet)
        people[3].addToTweets(kenTweet)
        people[4].addToTweets(bobTweet)
        andyTweet.save()
        jenTweet.save()
        kiraTweet.save()
        kenTweet.save()
        bobTweet.save()
    }

    def removePeople() {
        println "REMOVE PEOPLE"
        if(people == null) {
            people = Person.all
        }
        for(person in people) {
            person.delete(flush:true)
        }
    }

    def removeGroups() {
        println "REMOVE GROUPS"
        for(person in Person.all) {
            for(group in person.groups) {
                group.delete(flush:true)
            }
        }
    }

    def removeTweets() {
        println "REMOVE TWEETS"
        for(person in Person.all) {
            for(tweet in person.tweets) {
                tweet.delete(flush:true)
            }
        }
    }
}
