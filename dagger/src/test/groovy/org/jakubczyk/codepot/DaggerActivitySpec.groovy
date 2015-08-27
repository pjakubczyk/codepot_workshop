package org.jakubczyk.codepot

import android.content.Context
import android.widget.TextView
import org.jakubczyk.codepot.inject.DaggerComponent
import org.jakubczyk.codepot.inject.DaggerInjector
import org.jakubczyk.codepot.inject.DaggerModule
import spock.lang.Specification

class DaggerActivitySpec extends Specification {

    // use default Module
    def "should show first user"() {
        given: "create an activity"

        and: "set a new user"

        and: "mock the widget"

        when: "call onResume"

        then: "check if correct text is set"
    }

    def "should show third user"() {
        given: "prepare Dagger Injector"

        and: "create an activity"

        and: "mock the widget"

        when: "call action, update Users"

        then: "check if first no 0 is set"

        then: "check if first no 1 is set"

        then: "check if first no 2 is set"
    }

    // replace "Component"
    def "should show first user with component"() {
        given: "Override DaggerInjector component with a Mock"

        and: "create an activity"

        and: "call OnCreate"

        and: "mock the widget"

        when: "call onResume"

        then: "check if correct text is set"
    }

    def "should show thrid user with component"() {
        given: "Override DaggerInjector component with a Mock"

        and: "create an activity"

        and: "mock the wigdet"

        when: "call action, update Users()"

        then: "check if 3 times the label was set"
    }
}