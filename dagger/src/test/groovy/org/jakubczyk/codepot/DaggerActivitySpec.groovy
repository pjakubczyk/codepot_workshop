package org.jakubczyk.codepot

import android.widget.TextView
import org.robolectric.Robolectric
import spock.lang.Ignore
import spock.lang.Specification


class DaggerActivitySpec extends Specification {


    def "should show first user"() {
        given:
        def activity = new DaggerActivity()

        and:
        activity.user = new User([name: "Adam", fromPackage: "org.jakubczyk"])

        and:
        activity.titleTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText(!null)
    }

    @Ignore
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