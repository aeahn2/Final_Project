package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//import com.example.finalproject.R;

/** Represents the screen where you can create a new game and choose
 * from beginner or advanced, or see more info about each choice
 */

public final class NewGameActivity extends AppCompatActivity {
    private static final String TAG = "NewGameActivity";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.i(TAG, "NewGameActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

//        RadioGroup gameMode = findViewById(R.id.gameMode);


//        RadioButton beginner = findViewById(R.id.beginner);
//
//        RadioButton advanced = findViewById(R.id.advanced);
//
        Button startGame = findViewById(R.id.startGame);
//
        startGame.setOnClickListener(unused -> createGameClicked());

    }

    private void createGameClicked() {
        RadioGroup gameMode = findViewById(R.id.gameMode);
        Intent intent = new Intent(this, GameActivity.class);
        if (gameMode.getCheckedRadioButtonId() == R.id.beginner) {
            Log.i(TAG, "beginner button pressed");
        } else if (gameMode.getCheckedRadioButtonId() == R.id.advanced) {
            Log.i(TAG, "advanced button clicked");
        }
    }
}
