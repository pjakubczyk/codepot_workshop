package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./dagger/src/main/AndroidManifest.xml")
class DaggerActivitySpecRobolectric extends RoboSpecification {


    def "should show first user"() {
        given: "create activity controller"

        and: "get the activity from controller"

        when: "make controller run create() resume()"

        then: "check if correct text is set"
    }

    def "should show third user"() {
        given: "create activity controller"

        and: "get the activity from controller"

        when: "make controller run create() resume()"

        then: "check if correct text is set after thrid run"
    }
}