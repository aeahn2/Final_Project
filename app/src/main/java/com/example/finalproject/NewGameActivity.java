package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//import com.example.finalproject.R;

/** Represents the screen where you can create a new game and choose
 * from beginner or advanced, or see more info about each choice
 */

public final class NewGameActivity extends AppCompatActivity {
    private static final String TAG = "NewGameActivity";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        Log.i(TAG, "NewGameActivity");

        TextView errorMessage = findViewById(R.id.errorMessage);
        errorMessage.setVisibility(View.GONE);

        TextView begDes = findViewById(R.id.begDes);
        begDes.setText("Start with lower CS ability but higher mental health");
        TextView advDes = findViewById(R.id.advDes);
        advDes.setText("Start with higher CS ability but lower mental health");
        TextView enterNameText = findViewById(R.id.enterNameText);
        enterNameText.setText("Enter your name");





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
        EditText enterName = findViewById(R.id.enterName);
        String setName = enterName.getText().toString();
        TextView enterNameText = findViewById(R.id.enterNameText);
        intent.putExtra("grades", 100);
        intent.putExtra("social", 0);

        TextView errorMessage = findViewById(R.id.errorMessage);
        errorMessage.setVisibility(View.GONE);


        if (setName.trim().isEmpty()) {
            enterNameText.setTextColor(Color.RED);
        } else {
            enterNameText.setTextColor(Color.BLACK);
            intent.putExtra("name", setName);
            Log.i(TAG, "My name is" + setName);
        }

        if (gameMode.getCheckedRadioButtonId() == R.id.beginner && !(setName.trim().isEmpty())) {
            Log.i(TAG, "beginner button pressed");
            intent.putExtra("ability", 0);
            intent.putExtra("mental", 50);

            startActivity(intent);

        } else if (gameMode.getCheckedRadioButtonId() == R.id.advanced && !(setName.trim().isEmpty())) {
            Log.i(TAG, "advanced button clicked");
            intent.putExtra("ability", 50);
            intent.putExtra("mental", 0);

            startActivity(intent);

        } else if (gameMode.getCheckedRadioButtonId() != R.id.beginner && gameMode.getCheckedRadioButtonId() != R.id.advanced ){
            Log.i(TAG, "no version selected");
            errorMessage.setVisibility(View.VISIBLE);
            errorMessage.setText("Please select a difficulty level");
        }

    }
}
