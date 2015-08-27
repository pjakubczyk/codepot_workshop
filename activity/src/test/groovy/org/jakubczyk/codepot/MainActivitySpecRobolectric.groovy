package org.jakubczyk.codepot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./activity/src/main/AndroidManifest.xml")
class MainActivitySpecRobolectric extends RoboSpecification {

    def "should build the activity"() {
        given: "create activity controller"
        def activityController = Robolectric.buildActivity(MainActivity)

        and: "get the activity from controller"
        def activity = activityController.get()

        when: "make controller call onCreate"
        activityController.create()

        then: "check if widget is not empty"
        activity.titleTv
    }

    def "should show low value"(){
        given: "create activity controller"
        def activityController = Robolectric.buildActivity(MainActivity)

        and: "get the activity from controller"
        def activity = activityController.get()

        and: "set conditional value to 2"
        activity.conditionValue = 2

        when: "make controller call onCreate and onResume"
        activityController.create().resume()

        then: "check if correct text is set"
        activity.titleTv.text =~ "Low"
    }

    def "should show high value"(){
        given: "create activity controller"
        def activityController = Robolectric.buildActivity(MainActivity)

        and: "get the activity from controller"
        def activity = activityController.get()

        and: "set conditional value to 4"
        activity.conditionValue = 4

        when: "make controller call onCreate and onResume"
        activityController.create().resume()

        then: "check if correct text is set"
        activity.titleTv.text =~ "High"
    }

    // The Intent

    def "should show that bundle is empty"() {
        given: "create activity controller with intent and call create"
        def activityController = Robolectric.buildActivity(MainActivity).withIntent(new Intent()).create()

        and: "get the activity from controller"
        def activity = activityController.get()

        when: "call action"
        activity.processExtras()

        then: "check if correct text is set"
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

        and: "create activity controller with intent and call create"
        def activityController = Robolectric.buildActivity(MainActivity).withIntent(intent).create()

        and: "get the activity from controller"
        def activity = activityController.get()

        when: "call action"
        activity.processExtras()

        then: "check if correct text is set"
        activity.labelTv.text == "Bundle with 2 elements"
    }

}