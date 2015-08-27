package org.jakubczyk.codepot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./activity/src/main/AndroidManifest.xml")
class MainActivitySpecRobolectric extends RoboSpecification {

    def "should build the activity"() {
        given: "create activity controller"

        and: "get the activity from controller"

        when: "make controller call onCreate"

        then: "check if widget is not empty"
    }

    def "should show low value"(){
        given: "create activity controller"

        and: "get the activity from controller"

        and: "set conditional value to 2"

        when: "make controller call onCreate and onResume"

        then: "check if correct text is set"
    }

    def "should show high value"(){
        given: "create activity controller"

        and: "get the activity from controller"

        and: "set conditional value to 4"

        when: "make controller call onCreate and onResume"

        then: "check if correct text is set"
    }

    // The Intent

    def "should show that bundle is empty"() {
        given: "create activity controller with intent and call create"

        and: "get the activity from controller"

        when: "call action"

        then: "check if correct text is set"
    }

    def "should show bundle size"(){
        given: "fill bundle with elements"

        and: "pass it to the intent"

        and: "create activity controller with intent and call create"

        and: "get the activity from controller"

        when: "call action"

        then: "check if correct text is set"
    }

}