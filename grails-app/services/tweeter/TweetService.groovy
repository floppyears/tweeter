package tweeter

import grails.transaction.Transactional

@Transactional
class TweetService {

    def createTweet(Person person, String text) {
        Tweet tweet = new Tweet(author: person, text: text)
        return tweet.save()
    }
}
