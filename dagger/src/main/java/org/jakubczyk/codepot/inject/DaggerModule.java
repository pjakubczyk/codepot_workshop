package org.jakubczyk.codepot.inject;

import android.content.Context;

import org.jakubczyk.codepot.User;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {

    int ordinal = 0;

    private Context context;

    public DaggerModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    public User provideUser(Context context) {
        User u = new User();
        u.name = "Adam no. " + ordinal;
        u.fromPackage = context.getPackageName();
        ++ordinal;
        return u;
    }
}
