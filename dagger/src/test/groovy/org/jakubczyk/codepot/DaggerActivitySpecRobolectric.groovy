package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./dagger/src/main/AndroidManifest.xml")
class DaggerActivitySpecRobolectric extends RoboSpecification {


    def "should show first user"() {
        given: "create activity controller"
        def controller = Robolectric.buildActivity(DaggerActivity)

        and: "get the activity from controller"
        def activity = controller.get()

        when: "make controller run create() resume()"
        controller.create().resume()

        then: "check if correct text is set"
        activity.titleTv.text =~ "Adam no. 0"
    }

    def "should show third user"() {
        given: "create activity controller"
        def controller = Robolectric.buildActivity(DaggerActivity)

        and: "get the activity from controller"
        def activity = controller.get()

        when: "make controller run create() resume()"
        controller.create().resume()

        then: "check if correct text is set after thrid run"
        activity.labelTv.text =~ "Adam no. 3"
    }
}