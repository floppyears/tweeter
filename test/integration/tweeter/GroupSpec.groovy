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
        when: "People are a party of a group"
        Group grp = Group.findByName("Group 1")

        then: "Their tweets should be in the groups tweets"
        grp.tweets.contains("Andy's tweet!")
        grp.tweets.contains("Jen's tweet!")
        grp.tweets.contains("Kira's tweet!")
    }
}
