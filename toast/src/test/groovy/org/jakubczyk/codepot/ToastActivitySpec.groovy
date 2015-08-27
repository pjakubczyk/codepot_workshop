package org.jakubczyk.codepot

import spock.lang.Specification

class ToastActivitySpec extends Specification {

    def "should assign listener to the label"() {
        given: "create activity"

        and: "mock the widget"

        when: "call action, setListeners()"

        then: "check if listener was added"
    }

    def "should show a toast on click event"() {
        given: "create activity"

        and: "mock the toaster"

        when: "call action, onClick()"

        then: "check if toaster showed text once"
    }
}