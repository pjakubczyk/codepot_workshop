package org.jakubczyk.codepot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import spock.lang.Specification

class MainActivitySpec extends Specification {

    def "should fail with find view by id"() {
        given: "create an activity"

        when: "call on create"

        then: "check if widget is empty"
    }

    def "should show low value"() {
        given: "create an activity"

        and: "set the conditional value"

        and: "mock widget"

        when: "resume activity"

        then: "check if correct text is set"
    }

    def "should show high value"() {
        given: "create an activity"

        and: "set the conditional value"

        and: "mock widget"

        when: "resume activity"

        then: "check if correct text is set"
    }

    // The Intent

    def "should show that bundle is empty"() {
        given: "create an activity"

        and: "mock starting Intent"

        and: "mock widget"

        when: "call action"

        then: "check if correct text is set"
    }

    def "should show bundle size"() {
        given: "create an activity"

        and: "mock bundle, make size() return 2"

        and: "mock starting intent, make getExtras() return bundle"

        and: "mock widget"

        when: "call action"

        then: "check if correct text is set"
    }


}