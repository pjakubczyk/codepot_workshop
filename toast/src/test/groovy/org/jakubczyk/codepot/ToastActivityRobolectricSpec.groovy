package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./toast/src/main/AndroidManifest.xml")
class ToastActivityRobolectricSpec extends RoboSpecification {

    def "should assign listener to the label"() {
        given:
        def activityController = Robolectric.buildActivity(ToastActivity)

        and:
        def activity = activityController.get()

        when:
        activityController.create()

        then:
        Robolectric.shadowOf(activity.labelTv).getOnClickListener()
    }

    def "should show a toast on click event"() {
        given:
        def activityController = Robolectric.buildActivity(ToastActivity)

        and:
        def activity = activityController.get()

        and:
        activityController.create()

        when:
        activity.labelTv.performClick()

        then:
        ShadowToast.textOfLatestToast =~ "Cli"
    }
}