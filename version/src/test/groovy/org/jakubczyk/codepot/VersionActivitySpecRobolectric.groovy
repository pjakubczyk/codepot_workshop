package org.jakubczyk.codepot

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./version/src/main/AndroidManifest.xml")
class VersionActivitySpecRobolectric extends RoboSpecification {


    def "should show display version"() {
        given: "create activity controller"

        and: "get the activity from controller"

        when: "make controller call create and resume"

        then: "check with version is reported"
    }

    def "should change title to non kitkat"() {
        given: "create activity controller"

        and: "get the activity from controller"

        when: "make controller call create and resume"

        then: "check which text is fine"
    }
}