package tweeter



import spock.lang.*

/**
 *
 */
class PersonIntegrationSpec extends Specification {
    static transactional = false

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
}
