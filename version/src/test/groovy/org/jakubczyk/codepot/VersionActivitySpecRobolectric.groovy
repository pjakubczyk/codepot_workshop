package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./version/src/main/AndroidManifest.xml")
class VersionActivitySpecRobolectric extends RoboSpecification {


    def "should show display version"() {
        given:
        def controller = Robolectric.buildActivity(VersionActivity)

        def activity = controller.get()

        when:
        controller.create().resume()

        then:
        activity.labelTv.text == "Version 16"
    }

    def "should change title to non kitkat"() {
        given:
        def controller = Robolectric.buildActivity(VersionActivity)

        def activity = controller.get()

        when:
        controller.create().resume()

        then:
        activity.titleTv.text == "I am NOT Kitkat"
    }
}