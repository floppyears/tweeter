package tweeter



import spock.lang.*

/**
 *
 */
class TweetIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test create tweet and save"() {
        given:
        Person andy = Person.findByUsername("warand")
        andy.addToTweets(text: "Andy's new tweet!")

        expect:
        andy.save()
    }
}
