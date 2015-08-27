package org.jakubczyk.codepot

import android.widget.TextView
import spock.lang.Specification

class VersionActivitySpec extends Specification {

    def "should show display version"() {
        given: "create activity"
        def activity = new VersionActivity()

        and: "mock version provider"
        activity.versionProvider = Mock(VersionProvider)

        and: "mock both widgets"
        activity.titleTv = Mock(TextView)
        activity.labelTv = Mock(TextView)

        when: "call onResume()"
        activity.onResume()

        then: "check which version has been reported"
        1 * activity.labelTv.setText("Version 0")
    }

    def "should change title to kitkat"() {
        given: "create activity"
        def activity = new VersionActivity()

        and: "mock version provider, make it return Kitkat"
        activity.versionProvider = Mock(VersionProvider) {
            isAtLeastKitkat() >> true
        }

        and: "mock both widgets"
        activity.titleTv = Mock(TextView)
        activity.labelTv = Mock(TextView)

        when: "call onResume"
        activity.onResume()

        then: "check if text is the KITKAT one"
        1 * activity.titleTv.setText("I am KITKAT")
    }

    def "should change title to non kitkat"() {
        given: "create activity"
        def activity = new VersionActivity()

        and: "mock version provider, don't override methods"
        activity.versionProvider = Mock(VersionProvider)

        and: "mock both widgets"
        activity.titleTv = Mock(TextView)
        activity.labelTv = Mock(TextView)

        when: "call onResume"
        activity.onResume()

        then: "check if text is not the KITKAT one"
        1 * activity.titleTv.setText("I am NOT Kitkat")
    }

}