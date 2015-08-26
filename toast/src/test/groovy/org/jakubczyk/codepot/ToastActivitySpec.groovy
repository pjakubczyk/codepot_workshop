package org.jakubczyk.codepot

import android.widget.TextView
import spock.lang.Specification


class ToastActivitySpec extends Specification {

    def "should assign listener to the label"() {
        given:
        def activity = new ToastActivity()

        and:
        activity.labelTv = Mock(TextView)

        when:
        activity.setListeners()

        then:
        1 * activity.labelTv.setOnClickListener(activity)
    }

    def "should show a toast on click event"() {
        given:
        def activity = new ToastActivity()

        and:
        activity.toaster = Mock(Toaster)

        when:
        activity.onClick(null)

        then:
        1 * activity.toaster.show("Clicked!")
    }
}