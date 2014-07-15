package tweeter



import spock.lang.*

/**
 *
 */
class GroupIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test get group tweets"() {
        given:
        Group grp = Group.findByName("Group 1")
        List<String> tweetsText = grp.tweets.text


        expect:
        tweetsText.contains("Andy's tweet!")
        tweetsText.contains("Jen's tweet!")
        tweetsText.contains("Kira's tweet!")
        !tweetsText.contains("Ken's tweet!")
        !tweetsText.contains("Bob's tweet!")
    }

    void "test get group followers"() {
        given:
        Group grp = Group.findByName("Group 1")

        expect:
        grp.followers.contains(Person.findByUsername("warand"))
        grp.followers.contains(Person.findByUsername("cohjen"))
        grp.followers.contains(Person.findByUsername("ludkir"))
        !grp.followers.contains(Person.findByUsername("winken"))
        !grp.followers.contains(Person.findByUsername("colrob"))
    }
}
