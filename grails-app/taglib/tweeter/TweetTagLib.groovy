package tweeter

class TweetTagLib {
    //static defaultEncodeAs = [taglib:'html']
    static encodeAsForTags = [tagName: [taglib:'html'], alert: [taglib:'none']]
    def alert = { attrs, body ->
        String msg
        String alertType
        boolean isNull = false
        switch (attrs.saved) {
            case "success":
                msg = "Successfully tweeted!"
                alertType = "success"
                break
            case "fail":
                msg = "Something went wrong."
                alertType = "danger"
                break
            case null:
                isNull = true
                break
        }
        if(!isNull) {
            out << render(template: "/tweet/alert", model: [alertType: alertType, msg: msg])
        }
    }
}
