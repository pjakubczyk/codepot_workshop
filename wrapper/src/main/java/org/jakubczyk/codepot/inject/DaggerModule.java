package org.jakubczyk.codepot.inject;

import android.content.Context;

import org.jakubczyk.codepot.MediaProjectionManagerWrapper;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {

    int ordinal = 0;

    private Context context;

    public DaggerModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public MediaProjectionManagerWrapper provideMediaProjectionManagerWrapper(Context context) {
        return new MediaProjectionManagerWrapper(context);
    }
}
