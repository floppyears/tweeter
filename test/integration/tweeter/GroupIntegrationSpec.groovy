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
        when: "People are in a group"
        Group grp = Group.findByName("Group 1")
        List<String> tweetsText = grp.tweets.text


        then: "Their tweets should be in the groups tweets"
        tweetsText.contains("Andy's tweet!")
        tweetsText.contains("Jen's tweet!")
        tweetsText.contains("Kira's tweet!")
        !tweetsText.contains("Ken's tweet!")
        !tweetsText.contains("Bob's tweet!")
    }

    /**
     * Test fails because group has no followers. However,
     * it is apparent that it at one point did as the previous
     * test returned tweets which requires followers. Groups
     * seems to remove their followers after a bit for some reason?
     */
    void "test get group followers"() {
        when: "People are followers of a group"
        Group grp = Group.findByName("Group 1")

        then: "Only those people should be in the groups followers"
        grp.followers.contains(Person.findByUsername("warand"))
        grp.followers.contains(Person.findByUsername("cohjen"))
        grp.followers.contains(Person.findByUsername("ludkir"))
        !grp.followers.contains(Person.findByUsername("winken"))
        !grp.followers.contains(Person.findByUsername("colrob"))
    }
}
