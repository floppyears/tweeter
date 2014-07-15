package tweeter



import spock.lang.*

/**
 *
 */
class PersonIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test get user's followers"() {
        given:
        Person andy = Person.findByUsername("warand")

        expect:
        !andy.followers.contains(andy)
        andy.followers.contains(Person.findByUsername("cohjen"))
        andy.followers.contains(Person.findByUsername("ludkir"))
        !andy.followers.contains(Person.findByUsername("winken"))
        !andy.followers.contains(Person.findByUsername("colrob"))
    }

    void "Test get user's follows tweets"() {
        given:
        Person andy = Person.findByUsername("warand")
        List followsTweets = andy.followsTweets.text.flatten()

        expect:
        followsTweets.contains("Andy's tweet!")
        followsTweets.contains("Jen's tweet!")
        followsTweets.contains("Kira's tweet!")
        followsTweets.contains("Ken's tweet!")
        !followsTweets.contains("Bob's tweet!")
    }
}
