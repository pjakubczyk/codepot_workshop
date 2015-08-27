package org.jakubczyk.codepot

import android.widget.TextView
import spock.lang.Specification

class VersionActivitySpec extends Specification {

    def "should show display version"() {
        given: "create activity"

        and: "mock version provider"

        and: "mock both widgets"

        when: "call onResume()"

        then: "check which version has been reported"
    }

    def "should change title to kitkat"() {
        given: "create activity"

        and: "mock version provider, make it return Kitkat"

        and: "mock both widgets"

        when: "call onResume"

        then: "check if text is the KITKAT one"
    }

    def "should change title to non kitkat"() {
        given: "create activity"

        and: "mock version provider, don't override methods"

        and: "mock both widgets"

        when: "call onResume"

        then: "check if text is not the KITKAT one"
    }

}