package org.jakubczyk.codepot

import android.content.Intent
import org.jakubczyk.codepot.inject.DaggerComponent
import org.jakubczyk.codepot.inject.DaggerInjector
import org.jakubczyk.codepot.inject.DaggerModule
import org.jakubczyk.codepot.projection.MediaProjectionManagerWrapper
import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./wrapper/src/main/AndroidManifest.xml")
class WrapperActivitySpecRobolectric extends RoboSpecification {


    def "should fail recording"(){
        given: "start default dagger module"
        DaggerInjector.start(new DaggerModule(Robolectric.application))

        and: "prepare controller"
        def controller = Robolectric.buildActivity(WrapperActivity)
        controller.create()

        and: "get the activity"
        def activity = controller.get()

        when: "call action, take video"
        activity.takeVideo()

        and: "fetch shadow of the wrapperAcitivity"
        def shadowActivity = Robolectric.shadowOf(activity)

        then: "check if restult has intent"
        def res = shadowActivity.peekNextStartedActivityForResult()

        res.intent
    }


    def "should should start recording"() {
        given: "create mock of media projection wrapper"
        def mock = Mock(MediaProjectionManagerWrapper) {
            register(_) >> { arguments ->
                def activity = arguments[0]
                activity.startActivityForResult(new Intent("android.intent.action.CHOOSER"), 345)
            }
        }

        and: "mock the component and let return mocked version of media projection wrapper"
        DaggerInjector.component = Mock(DaggerComponent) {
            getMediaProjectionManagerWrapper() >> mock
        }

        and: "prepare controller"
        def controller = Robolectric.buildActivity(WrapperActivity)
        controller.create()

        and: "get the activity"
        def activity = controller.get()

        when: "call action, take video"
        activity.takeVideo()

        and: "fetch shadow of the wrapperAcitivity"
        def shadowActivity = Robolectric.shadowOf(activity)

        then: "check if restult has intent"
        def res = shadowActivity.peekNextStartedActivityForResult()

        Intent intent = res.intent
        intent.action == "android.intent.action.CHOOSER"
    }


}