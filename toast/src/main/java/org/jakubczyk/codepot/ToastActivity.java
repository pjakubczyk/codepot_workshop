package org.jakubczyk.codepot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ToastActivity extends Activity implements View.OnClickListener {

    TextView titleTv;
    TextView labelTv;
    Toaster toaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTv = (TextView) findViewById(R.id.title);
        labelTv = (TextView) findViewById(R.id.label);
        toaster = new Toaster(this);

        setListeners();
    }

    void setListeners(){
        labelTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        toaster.show("Clicked!");
    }
}
