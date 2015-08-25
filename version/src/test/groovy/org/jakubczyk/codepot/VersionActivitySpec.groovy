package org.jakubczyk.codepot

import android.widget.TextView
import spock.lang.Specification

class VersionActivitySpec extends Specification {

    def "should show display version"() {
        given:
        def activity = new VersionActivity()

        and:
        activity.versionProvider = Mock(VersionProvider)

        and:
        activity.titleTv = Mock(TextView)
        activity.labelTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.labelTv.setText("Version 0")
    }

    def "should change title to kitkat"() {
        given:
        def activity = new VersionActivity()

        and:
        activity.versionProvider = Mock(VersionProvider) {
            isAtLeastKitkat() >> true
        }

        and:
        activity.titleTv = Mock(TextView)
        activity.labelTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText("I am KITKAT")
    }

    def "should change title to non kitkat"() {
        given:
        def activity = new VersionActivity()

        and:
        activity.versionProvider = Mock(VersionProvider)

        and:
        activity.titleTv = Mock(TextView)
        activity.labelTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText("I am NOT Kitkat")
    }

}