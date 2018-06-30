package com.ebookfrenzy.motionevent;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MotionEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);

        ConstraintLayout myLayout =
                (ConstraintLayout)findViewById(R.id.activity_motion_event);

        myLayout.setOnTouchListener(
                new ConstraintLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        handleTouch(m);
                        return true; // indicates the event has been consumed and may be garbage collected.
                    }
                }
        );


    }

    public void handleTouch(MotionEvent m) {
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);

        int pointerCount = m.getPointerCount();

        for(int i= 0; i < pointerCount; i++) {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = (int) m.getPointerId(i);
            int action = (int) m.getActionMasked();
            int actionIndex = (int)m.getActionIndex();
            String actionString;


            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    actionString = "Down";
                    break;

                case MotionEvent.ACTION_UP:
                    actionString = "Up";
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "Pointer Down";
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "Pointer Up";
                    break;

                case MotionEvent.ACTION_MOVE:
                    actionString = "Move";
                    break;

                default:
                    actionString = "";

            }

            String touchStatus = "Action: " + actionString + " Index: " + actionIndex + " ID: " + id + " X: " + x + "Y: " + y;

            if(id == 0) textView1.setText(touchStatus); else textView2.setText(touchStatus);


        }


    }
}
