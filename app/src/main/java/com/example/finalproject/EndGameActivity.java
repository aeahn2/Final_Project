package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        } else if (grades >= 80) {
            gradeFinal.setText("Class Grade: B");
        } else if (grades >= 70) {
            gradeFinal.setText("Class Grade: C");
        } else if (grades >= 60) {
            gradeFinal.setText("Class Grade: D");
        } else {
            gradeFinal.setText("Class Grade: F");
        }

        double score = (grades + ability + mental + social) / 4.0;
        scoreFinal.setText("Overall Score: " + Double.toString(score));


    }
}
