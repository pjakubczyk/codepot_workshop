package org.jakubczyk.codepot;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;

public class MediaProjectionManagerWrapper {
    MediaProjectionManager mediaProjectionManager;

    public MediaProjectionManagerWrapper(Context context) {
        mediaProjectionManager = (MediaProjectionManager)
                context.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
    }

    public Intent createScreenCaptureIntent() {
        return mediaProjectionManager.createScreenCaptureIntent();
    }

    public MediaProjection getMediaProjection(int resultCode, Intent data) {
        return mediaProjectionManager.getMediaProjection(resultCode, data);
    }
}
