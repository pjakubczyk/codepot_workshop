package org.jakubczyk.codepot

import android.content.Intent
import org.jakubczyk.codepot.inject.DaggerComponent
import org.jakubczyk.codepot.inject.DaggerInjector
import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = "./wrapper/src/main/AndroidManifest.xml")
class WrapperActivitySpecRobolectric extends RoboSpecification {


    def "should should start recording"() {
        given:
        def mock = Mock(MediaProjectionManagerWrapper) {
            createScreenCaptureIntent() >> new Intent("android.intent.action.CHOOSER")
        }

        DaggerInjector.component = Mock(DaggerComponent) {
            getMediaProjectionManagerWrapper() >> mock
        }


        def controller = Robolectric.buildActivity(WrapperActivity)
        controller.create()

        and:
        def activity = controller.get()

        when:
        activity.takeVideo()

        and:
        def shadowActivity = Robolectric.shadowOf(activity)

        then:
        def res = shadowActivity.peekNextStartedActivityForResult()

        Intent intent = res.intent
        intent.action == "android.intent.action.CHOOSER"
    }


}