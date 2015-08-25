package org.jakubczyk.codepot;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class VersionActivity extends Activity {

    TextView titleTv;
    TextView labelTv;

    VersionProvider versionProvider = new VersionProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTv = (TextView) findViewById(R.id.title);
        labelTv = (TextView) findViewById(R.id.label);
    }

    @Override
    protected void onResume() {
        super.onResume();

        labelTv.setText("Version " + Build.VERSION.SDK_INT);

        if (versionProvider.isAtLeastKitkat())
            titleTv.setText("I am KITKAT");
        else
            titleTv.setText("I am NOT Kitkat");
    }

}
