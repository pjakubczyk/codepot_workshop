package org.jakubczyk.codepot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView titleTv;
    int conditionValue = 4;
    TextView labelTv;
    Intent startingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTv = (TextView) findViewById(R.id.title);
        labelTv = (TextView) findViewById(R.id.label);

        startingIntent = getIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (conditionValue > 3) {
            titleTv.setText("High Number");
        } else {
            titleTv.setText("Low Number");
        }
    }

    void processExtras() {
        Bundle bundle = startingIntent.getExtras();
        if (bundle == null) {
            labelTv.setText("Null Bundle");
        } else {
            labelTv.setText("Bundle with " + bundle.size() + " elements");
        }

    }
}
