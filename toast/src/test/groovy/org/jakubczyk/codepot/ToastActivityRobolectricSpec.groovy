package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./toast/src/main/AndroidManifest.xml")
class ToastActivityRobolectricSpec extends RoboSpecification {

    def "should assign listener to the label"() {
        given: "create activity controller"
        def activityController = Robolectric.buildActivity(ToastActivity)

        and: "get the activity from controller"
        def activity = activityController.get()

        when: "make controller call onCreate"
        activityController.create()

        then: "check if correct text is set"
        Robolectric.shadowOf(activity.labelTv).getOnClickListener()
    }

    def "should show a toast on click event"() {
        given: "create activity controller"
        def activityController = Robolectric.buildActivity(ToastActivity)

        and: "get the activity from controller"
        def activity = activityController.get()

        and: "make controller call onCreate"
        activityController.create()

        when: "call action, click on the label"
        activity.labelTv.performClick()

        then: "check if correct text in the Toast is set"
        ShadowToast.textOfLatestToast =~ "Cli"
    }
}