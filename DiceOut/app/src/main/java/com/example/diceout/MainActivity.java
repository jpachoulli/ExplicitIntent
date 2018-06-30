package com.example.diceout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    // Field to hold the result of the roll.
    TextView rollResult;

    // Field to hold the roll button.
    Button rollButton;

    // Field to hold the score
    int score;

    // Random number generators
    Random rand;

    // Integer variable to hold the dice.
    int die1;
    int die2;
    int die3;

    // Array list to hold all 3 dice values
    ArrayList<Integer> dice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Set the initial score
        score = 0;

        // Find the id of the TextView xml widget and assign it to the TextView object 'rollResult'.
        rollResult = findViewById(R.id.rollResult);

        // Find the id of the Button xml widget and assign it to the Button object 'rollButton'.
        rollButton = findViewById(R.id.rollButton);

        // Initialize the random number generators.
        rand = new Random();

        // Initialize the ArrayList.
        dice = new ArrayList<Integer>();


        // Create greeting
        Toast.makeText(getApplicationContext(), "Welcome to DiceOut!", Toast.LENGTH_LONG).show();
    }

    public void rollDice(View v) {

        rollResult.setText("Clicked!");

        // Roll dice.
        die1 = rand.nextInt(6) +1;
        die2 = rand.nextInt(6) +1;
        die3 = rand.nextInt(6) +1;

        // Set dice values into the ArrayList, but clear the list prior so not retaining old values
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        // Build message with the result.
        String msg = "The numbers you rolled are: " + die1 + ", " + die2 + ", &" + die3;
        // Update the app to display the 'rollResult' message
        rollResult.setText(msg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
