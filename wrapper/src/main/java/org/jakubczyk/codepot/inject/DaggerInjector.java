package org.jakubczyk.codepot.inject;


public class DaggerInjector {

    public static DaggerComponent component;

    public static void start(DaggerModule daggerModule) {
        component = DaggerComponent.Initializer
                .init(daggerModule);
    }

    public static DaggerComponent get() {
        return component;
    }


}
