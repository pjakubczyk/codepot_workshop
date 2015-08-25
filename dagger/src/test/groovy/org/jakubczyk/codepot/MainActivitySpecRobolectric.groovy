package org.jakubczyk.codepot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./app/src/main/AndroidManifest.xml")
class MainActivitySpecRobolectric extends RoboSpecification {

    def "should build the activity"() {
        given:
        def activityController = Robolectric.buildActivity(DaggerActivity)

        and:
        def activity = activityController.get()

        when:
        activityController.create()

        then:
        activity.titleTv
    }

    def "should show low value"(){
        given:
        def activityController = Robolectric.buildActivity(DaggerActivity)

        and:
        def activity = activityController.get()

        and:
        activity.conditionValue = 2

        when:
        activityController.create().resume()

        then:
        activity.titleTv.text =~ "Low"
    }

    def "should show high value"(){
        given:
        def activityController = Robolectric.buildActivity(DaggerActivity)

        and:
        def activity = activityController.get()

        and:
        activity.conditionValue = 4

        when:
        activityController.create().resume()

        then:
        activity.titleTv.text =~ "High"
    }

    def "should show that bundle is empty"() {
        given:
        def activityController = Robolectric.buildActivity(DaggerActivity).withIntent(new Intent()).create()

        and:
        def activity = activityController.get()

        when:
        activity.processExtras()

        then:
        activity.labelTv.text == "Null Bundle"
    }

    def "should show bundle size"(){
        given: "fill bundle with elements"
        def bundle = new Bundle()
        bundle.putString("key1", "v1")
        bundle.putString("key2", "v2")

        and: "pass it to the intent"
        def intent = new Intent()
        intent.putExtras(bundle)

        and:
        def activityController = Robolectric.buildActivity(DaggerActivity).withIntent(intent).create()

        and:
        def activity = activityController.get()

        when:
        activity.processExtras()

        then:
        activity.labelTv.text == "Bundle with 2 elements"
    }

}