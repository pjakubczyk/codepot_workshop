package org.jakubczyk.codepot

import android.widget.TextView
import spock.lang.Specification


class ToastActivitySpec extends Specification {

    def "should assign listener to the label"() {
        given: "create activity"
        def activity = new ToastActivity()

        and: "mock the widget"
        activity.labelTv = Mock(TextView)

        when: "call action, setListeners()"
        activity.setListeners()

        then: "check if listener was added"
        1 * activity.labelTv.setOnClickListener(activity)
    }

    def "should show a toast on click event"() {
        given: "create activity"
        def activity = new ToastActivity()

        and: "mock the toaster"
        activity.toaster = Mock(Toaster)

        when: "call action, onClick()"
        activity.onClick(null)

        then: "check if toaster showed text once"
        1 * activity.toaster.show("Clicked!")
    }
}