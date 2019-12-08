package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    /**
     * Represents the main screen of the app, the user just taps the screen and it will move them to
     * new game activity.
     */
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Creating");

        ImageButton logoButton = findViewById(R.id.logoButton);

        logoButton.setOnClickListener(unused -> launchNewGameActivity());

    }
    public void launchNewGameActivity() {
        Log.i(TAG, "Go to NewGameActivity");
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);

    }


}
