package com.example.android.hellocompat;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Text view for Hello World.
    private TextView mHelloTextView;
    // array of color names, these match the color resources in color.xml
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the main text view
        mHelloTextView = (TextView) findViewById(R.id.hello_textview);

        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

        public void changeColor(View view) {
            // get a random color name from the color array (20 colors)
            Random random = new Random();
            String colorName = mColorArray[random.nextInt(20)];

            // get the color identifier that matches the color name
            int colorResourceName = getResources().getIdentifier(colorName, "color",
                    getApplicationContext().getPackageName());

            // get the color ID from the resources
            int colorRes = ContextCompat.getColor(this, colorResourceName);

            // Set the text color
            mHelloTextView.setTextColor(colorRes);
        }
    }
