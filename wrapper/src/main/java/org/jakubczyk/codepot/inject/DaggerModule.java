package org.jakubczyk.codepot.inject;

import android.content.Context;

import org.jakubczyk.codepot.projection.IMediaProjectionManagerWrapper;
import org.jakubczyk.codepot.projection.MediaProjectionManagerWrapper;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {


    private Context context;

    public DaggerModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public IMediaProjectionManagerWrapper provideMediaProjectionManagerWrapper(Context context) {
        return new MediaProjectionManagerWrapper(context);
    }
}
