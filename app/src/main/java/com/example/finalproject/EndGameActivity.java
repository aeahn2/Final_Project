package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public final class EndGameActivity extends AppCompatActivity {
    private static final String TAG = "EndGameActivity";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();

        Log.i(TAG, "EndGameActivity");


        TextView gradeScore = findViewById(R.id.gradeScore);
        TextView abilityScore = findViewById(R.id.abilityScore);
        TextView mentalScore = findViewById(R.id.mentalScore);
        TextView socialScore = findViewById(R.id.socialScore);

        TextView gradeFinal = findViewById(R.id.gradeFinal);
        TextView scoreFinal = findViewById(R.id.scoreFinal);

        int grades = intent.getIntExtra("grades", 0);
        int ability = intent.getIntExtra("ability", 0);
        int mental = intent.getIntExtra("mental", 0);
        int social = intent.getIntExtra("social", 0);

        String gradeScoreString = "Grade: " + grades;
        gradeScore.setText(gradeScoreString);
        abilityScore.setText("CS Ability: " + ability);
        mentalScore.setText("Mental Health: " + mental);
        socialScore.setText("Social Life: " + social);


        if (grades >= 90) {
            gradeFinal.setText("Class Grade: A");
            gradeFinal.setTextColor(Color.GREEN);
        } else if (grades >= 80) {
            gradeFinal.setText("Class Grade: B");
            gradeFinal.setTextColor(Color.GREEN);
        } else if (grades >= 70) {
            gradeFinal.setText("Class Grade: C");
            gradeFinal.setTextColor(Color.parseColor("#F5CE09"));
        } else if (grades >= 60) {
            gradeFinal.setText("Class Grade: D");
            gradeFinal.setTextColor(Color.RED);
        } else {
            gradeFinal.setText("Class Grade: F");
            gradeFinal.setTextColor(Color.RED);
        }

        double score = (grades + ability + mental + social) / 4.0;
        scoreFinal.setText("Overall Score: " + Double.toString(score));
        if (score >= 80) {
            scoreFinal.setTextColor(Color.GREEN);
        } else if (score >= 70) {
            scoreFinal.setTextColor(Color.parseColor("#F5CE09"));
        } else {
            scoreFinal.setTextColor(Color.RED);
        }

        TextView passFail = findViewById(R.id.passFail);

        if (grades >= 70 && score >= 70) {
            passFail.setText("PASSED");
            passFail.setTextColor(Color.GREEN);
            MediaPlayer cheering = MediaPlayer.create(EndGameActivity.this,R.raw.cheering);
            cheering.start();
        } else {
            passFail.setText("FAILED");
            passFail.setTextColor(Color.RED);
            MediaPlayer fail = MediaPlayer.create(EndGameActivity.this,R.raw.fail);
            fail.start();
        }

        Button playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(unused -> launchNewGameActivity());

    }

    public void launchNewGameActivity() {
        Log.i(TAG, "Go to NewGameActivity");
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);

    }
}
