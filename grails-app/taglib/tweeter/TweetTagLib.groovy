package tweeter

import groovy.time.TimeCategory
import groovy.time.TimeDuration

import java.sql.Timestamp

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

    def humanDate = { attrs, body ->
        Timestamp tweetStamp = attrs.date
        Date tweetDate = new Date(tweetStamp.getTime())
        Date now = new Date()
        TimeDuration timeSince = TimeCategory.minus(now, tweetDate)
        if (timeSince.getDays() > 3)
            out << tweetDate.format("MMMMM d, yyyy")
        else if (timeSince.getDays() > 0)
            out << timeSince.getDays() << "d"
        else if (timeSince.getHours() > 0)
            out << timeSince.getHours() << "h"
        else if (timeSince.getMinutes() > 0)
            out << timeSince.getMinutes() << "m"
        else
            out << timeSince.getSeconds() << "s"
    }
}
