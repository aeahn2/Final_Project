package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGameActivity extends AppCompatActivity {
    private static final String TAG = "EndGameActivity";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();

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

        gradeScore.setText("Grade: " + grades);
        abilityScore.setText("CS Ability: " + ability);
        mentalScore.setText("Mental Health: " + mental);
        socialScore.setText("Social Life: " + social);

//        if (grades > )


    }
}
