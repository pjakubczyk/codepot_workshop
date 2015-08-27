package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./version/src/main/AndroidManifest.xml", emulateSdk = 19)
class VersionActivitySpecRobolectricKitkat extends RoboSpecification {


    def "should show display version"() {
        given: "create activity controller"
        def controller = Robolectric.buildActivity(VersionActivity)

        and: "get the activity from controller"
        def activity = controller.get()

        when: "make controller call create and resume"
        controller.create().resume()

        then: "check with version is reported"
        activity.labelTv.text == "Version 19"
    }

    def "should change title to kitkat"() {
        given: "create activity controller"
        def controller = Robolectric.buildActivity(VersionActivity)

        and: "get the activity from controller"
        def activity = controller.get()

        when: "make controller call create and resume"
        controller.create().resume()

        then: "check which text is fine"
        activity.titleTv.text == "I am KITKAT"
    }
}