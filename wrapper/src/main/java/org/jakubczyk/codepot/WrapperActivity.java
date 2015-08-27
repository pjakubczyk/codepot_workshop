package org.jakubczyk.codepot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.jakubczyk.codepot.inject.DaggerComponent;
import org.jakubczyk.codepot.inject.DaggerInjector;

public class WrapperActivity extends Activity {

    TextView titleTv;
    TextView labelTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTv = (TextView) findViewById(R.id.title);
        labelTv = (TextView) findViewById(R.id.label);
    }

    void takeVideo() {
        MediaProjectionManagerWrapper wrapper = DaggerInjector.get().getMediaProjectionManagerWrapper();

        Intent intent = wrapper.createScreenCaptureIntent();

        startActivityForResult(intent, 456);
    }

}
