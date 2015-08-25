package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./dagger/src/main/AndroidManifest.xml")
class DaggerActivitySpecRobolectric extends RoboSpecification {


    def "should show first user"() {
        given:
        def controller = Robolectric.buildActivity(DaggerActivity)

        def activity = controller.get()

        when:
        controller.create().resume()

        then:
        activity.titleTv.text =~ "Adam no. 0"
    }

    def "should show third user"(){
        given:
        def controller = Robolectric.buildActivity(DaggerActivity)

        def activity = controller.get()

        when:
        controller.create().resume()

        then:
        activity.labelTv.text =~ "Adam no. 3"
    }
}