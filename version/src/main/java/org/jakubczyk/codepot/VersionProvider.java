package org.jakubczyk.codepot;

import android.os.Build;

public class VersionProvider {

    public boolean isAtLeastKitkat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }
}
