package org.jakubczyk.codepot;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.jakubczyk.codepot.inject.DaggerInjector;

import javax.inject.Inject;

public class DaggerActivity extends Activity {

    TextView titleTv;
    TextView labelTv;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTv = (TextView) findViewById(R.id.title);
        labelTv = (TextView) findViewById(R.id.label);

        DaggerInjector.get().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        titleTv.setText(user.toString());
        showNextUser();
        showNextUser();
        showNextUser();

    }

    void showNextUser() {
        User user = DaggerInjector.get().getUser();
        labelTv.setText(user.toString());
    }
}
