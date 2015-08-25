package org.jakubczyk.codepot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import spock.lang.Specification

class MainActivitySpec extends Specification {

    def "should fail with find view by id"() {
        when:
        def activity = new DaggerActivity()
        activity.onCreate(null)

        then:
        !activity.titleTv
    }

    def "should show low value"() {
        given:
        def activity = new DaggerActivity()

        and:
        activity.conditionValue = 2

        and:
        activity.titleTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText("Low Number")
    }

    def "should show high value"() {
        given:
        def activity = new DaggerActivity()

        and:
        activity.conditionValue = 4

        and:
        activity.titleTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText("High Number")
    }

    def "should show that bundle is empty"() {
        given:
        def activity = new DaggerActivity()

        and:
        activity.startingIntent = Mock(Intent) {
            getExtras() >> null
        }

        and:
        activity.labelTv = Mock(TextView)

        when:
        activity.processExtras()

        then:
        1 * activity.labelTv.setText("Null Bundle")
    }

    def "should show bundle size"(){
        given:
        def activity = new DaggerActivity()

        and:
        def bundle = Mock(Bundle) {
            size() >> 2
        }

        and:
        activity.startingIntent = Mock(Intent) {
            getExtras() >> bundle
        }

        and:
        activity.labelTv = Mock(TextView)

        when:
        activity.processExtras()

        then:
        1 * activity.labelTv.setText("Bundle with 2 elements")
    }


}