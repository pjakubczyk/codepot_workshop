package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./toast/src/main/AndroidManifest.xml")
class ToastActivityRobolectricSpec extends RoboSpecification {

    def "should assign listener to the label"() {
        given: "create activity controller"

        and: "get the activity from controller"

        when: "make controller call onCreate"

        then: "check if correct text is set"
    }

    def "should show a toast on click event"() {
        given: "create activity controller"

        and: "get the activity from controller"

        and: "make controller call onCreate"

        when: "call action, click on the label"

        then: "check if correct text in the Toast is set"
    }
}