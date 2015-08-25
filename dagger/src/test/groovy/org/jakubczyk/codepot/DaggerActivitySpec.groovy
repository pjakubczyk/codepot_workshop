package org.jakubczyk.codepot

import android.content.Context
import android.widget.TextView
import org.jakubczyk.codepot.inject.DaggerComponent
import org.jakubczyk.codepot.inject.DaggerInjector
import org.jakubczyk.codepot.inject.DaggerModule
import org.robolectric.Robolectric
import spock.lang.Ignore
import spock.lang.Specification


class DaggerActivitySpec extends Specification {

    def "should show first user"() {
        given:
        DaggerInjector.start(new DaggerModule(Mock(Context)))

        and:
        def activity = new DaggerActivity()

        and:
        activity.user = new User([name: "Adam", fromPackage: "org.jakubczyk"])

        and:
        activity.titleTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText("name=Adam fromPackage=org.jakubczyk")
    }

    def "should show third user"() {
        given:
        DaggerInjector.start(new DaggerModule(Mock(Context)))

        and:
        def activity = new DaggerActivity()

        and:
        activity.labelTv = Mock(TextView)

        when:
        activity.updateUsers()

        then:
        1 * activity.labelTv.setText("name=Adam no. 0 fromPackage=null")

        then:
        1 * activity.labelTv.setText("name=Adam no. 1 fromPackage=null")

        then:
        1 * activity.labelTv.setText("name=Adam no. 2 fromPackage=null")
    }

    // replace "Component"
    def "should show first user with component"(){
        given:
        DaggerInjector.component = Mock(DaggerComponent){
            inject(_) >> { arguments ->
                arguments[0].user = new User([name: "Adam", fromPackage: "org.jakubczyk"])
            }
        }

        and:
        def activity = new DaggerActivity()

        and:
        activity.onCreate(null)
        activity.titleTv = Mock(TextView)

        when:
        activity.onResume()

        then:
        1 * activity.titleTv.setText("name=Adam fromPackage=org.jakubczyk")
    }

    def "should show thrid user with component"(){
        given:
        DaggerInjector.component = Mock(DaggerComponent){
            getUser() >> new User([name: "Adam", fromPackage: "org.jakubczyk"])
        }

        and:
        def activity = new DaggerActivity()

        and:
        activity.labelTv = Mock(TextView)

        when:
        activity.updateUsers()

        then:
        3 * activity.labelTv.setText("name=Adam fromPackage=org.jakubczyk")
    }
}