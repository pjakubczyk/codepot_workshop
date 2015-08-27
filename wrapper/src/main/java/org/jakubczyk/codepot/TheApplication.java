package org.jakubczyk.codepot;

import android.app.Application;

import org.jakubczyk.codepot.inject.DaggerInjector;
import org.jakubczyk.codepot.inject.DaggerModule;

public class TheApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerInjector.start(new DaggerModule(this));
    }
}
