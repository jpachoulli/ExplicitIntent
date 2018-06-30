package com.ebookfrenzy.eventhandlingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventHandlingDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling_demo);

        Button button = new Button(this);
        button.callOnClick();
    }

    public void buttonClick(View view) {

        view = findViewById(R.id.button);

        Toast msg = Toast.makeText(this, "You just clicked the button!!", Toast.LENGTH_LONG);
        msg.show();

    }
}
