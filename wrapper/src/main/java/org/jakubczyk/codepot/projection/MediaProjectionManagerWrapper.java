package org.jakubczyk.codepot.projection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;

public class MediaProjectionManagerWrapper implements IMediaProjectionManagerWrapper {
    MediaProjectionManager mediaProjectionManager;

    public MediaProjectionManagerWrapper(Context context) {
        mediaProjectionManager = (MediaProjectionManager)
                context.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
    }

    public Intent createScreenCaptureIntent() {
        return mediaProjectionManager.createScreenCaptureIntent();
    }

    @Override
    public void register(Activity activity) {
        activity.startActivityForResult(createScreenCaptureIntent(), 345);
    }
}
