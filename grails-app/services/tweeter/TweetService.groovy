package tweeter

import grails.transaction.Transactional

@Transactional
class TweetService {

    def createTweet(tweet) {
        Person author = Person.get(tweet.author.id)
        Tweet newTweet = new Tweet(author: author, text: tweet.text)
        return newTweet.save() ? newTweet : null
    }

    def getFollowsTweets(person) {
        def tweets = []
        person.followsTweets.sort{ a, b -> b.dateCreated <=> a.dateCreated }.collect{
            tweets << it.toMap()
            println it.toMap()
        }
        return tweets
    }
}
