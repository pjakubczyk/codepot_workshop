package org.jakubczyk.codepot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.jakubczyk.codepot.inject.DaggerInjector;
import org.jakubczyk.codepot.projection.IMediaProjectionManagerWrapper;

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
        IMediaProjectionManagerWrapper wrapper = DaggerInjector.get().getMediaProjectionManagerWrapper();

        wrapper.register(this);
    }

}
