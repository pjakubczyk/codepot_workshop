package org.jakubczyk.codepot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import spock.lang.Specification

class MainActivitySpec extends Specification {

    def "should fail with find view by id"() {
        given: "create an activity"
        def activity = new MainActivity()

        when: "call on create"
        activity.onCreate(null)

        then: "check if widget is empty"
        !activity.titleTv
    }

    def "should show low value"() {
        given: "create an activity"
        def activity = new MainActivity()

        and: "set the conditional value"
        activity.conditionValue = 2

        and: "mock widget"
        activity.titleTv = Mock(TextView)

        when: "resume activity"
        activity.onResume()

        then: "check if correct text is set"
        1 * activity.titleTv.setText("Low Number")
    }

    def "should show high value"() {
        given: "create an activity"
        def activity = new MainActivity()

        and: "set the conditional value"
        activity.conditionValue = 4

        and: "mock widget"
        activity.titleTv = Mock(TextView)

        when: "resume activity"
        activity.onResume()

        then: "check if correct text is set"
        1 * activity.titleTv.setText("High Number")
    }

    // The Intent

    def "should show that bundle is empty"() {
        given: "create an activity"
        def activity = new MainActivity()

        and: "mock starting Intent"
        activity.startingIntent = Mock(Intent) {
            getExtras() >> null
        }

        and: "mock widget"
        activity.labelTv = Mock(TextView)

        when: "call action"
        activity.processExtras()

        then: "check if correct text is set"
        1 * activity.labelTv.setText("Null Bundle")
    }

    def "should show bundle size"() {
        given: "create an activity"
        def activity = new MainActivity()

        and: "mock bundle, make size() return 2"
        def bundle = Mock(Bundle) {
            size() >> 2
        }

        and: "mock starting intent, make getExtras() return bundle"
        activity.startingIntent = Mock(Intent) {
            getExtras() >> bundle
        }

        and: "mock widget"
        activity.labelTv = Mock(TextView)

        when: "call action"
        activity.processExtras()

        then: "check if correct text is set"
        1 * activity.labelTv.setText("Bundle with 2 elements")
    }


}