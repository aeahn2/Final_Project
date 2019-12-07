package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Represents the game activity, where the user plays the game and sees its state.
 */

public final class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    private static int date = 0;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();

        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        String name = intent.getStringExtra("name");
        TextView playerName = findViewById(R.id.playerName);

        playerName.setText(name);
        Log.i(TAG, name);

        currentDate.setText("Day " + Integer.toString(date) + " of 64");

        int grades = intent.getIntExtra("grades", 100);
        int ability = intent.getIntExtra("ability", 0);
        int mental = intent.getIntExtra("mental", 50);
        int social = intent.getIntExtra("social", 0);

        gradesBar.setProgress(grades);
        abilityBar.setProgress(ability);
        mentalBar.setProgress(mental);
        socialBar.setProgress(social);


        Button workMP = findViewById(R.id.workMP);
        Button friends = findViewById(R.id.friends);
        Button prairieLearn = findViewById(R.id.prairieLearn);
        Button party = findViewById(R.id.party);


        workMP.setOnClickListener(unused -> workMPMethod());
        friends.setOnClickListener(unused -> friendsMethod());
        prairieLearn.setOnClickListener(unused -> prairieLearnMethod());
        party.setOnClickListener(unused -> partyMethod());


    }


//    Work on MP (Mental Health -6, Grades +8, Social Life -10, CS Ability +6)
    public void workMPMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);
        if (date < 64) {

            gradesBar.incrementProgressBy(8);
            abilityBar.incrementProgressBy(6);
            mentalBar.incrementProgressBy(-6);
            socialBar.incrementProgressBy(-10);

            date++;
            currentDate.setText("Day " + Integer.toString(date) + " of 64");
        } else {
            Intent endIntent = new Intent(this, EndGameActivity.class);
            endIntent.putExtra("grades", gradesBar.getProgress());
            endIntent.putExtra("ability", abilityBar.getProgress());
            endIntent.putExtra("mental", mentalBar.getProgress());
            endIntent.putExtra("social", socialBar.getProgress());

            Log.i(TAG, "last day");

            startActivity(endIntent);
            finish();

        }

    }


    //    Spend time with friends (Mental Health +4, Grades -2, Social Life +3, CS Ability -2)
    public void friendsMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        if (date < 64) {
            gradesBar.incrementProgressBy(-2);
            abilityBar.incrementProgressBy(-2);
            mentalBar.incrementProgressBy(+4);
            socialBar.incrementProgressBy(+3);

            date++;
            currentDate.setText("Day " + Integer.toString(date) + " of 64");
        } else {
            Intent endIntent = new Intent(this, EndGameActivity.class);
            endIntent.putExtra("grades", gradesBar.getProgress());
            endIntent.putExtra("ability", abilityBar.getProgress());
            endIntent.putExtra("mental", mentalBar.getProgress());
            endIntent.putExtra("social", socialBar.getProgress());

            Log.i(TAG, "last day");

            startActivity(endIntent);
            finish();
        }

    }

    //    Do PrairieLearn (Mental Health 0, Grades +2, Social Life 0, CS Ability +2)
    public void prairieLearnMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        if (date < 64) {
            gradesBar.incrementProgressBy(2);
            abilityBar.incrementProgressBy(2);
            mentalBar.incrementProgressBy(-1);
            socialBar.incrementProgressBy(-2);

            date++;
            currentDate.setText("Day " + Integer.toString(date) + " of 64");
        } else {
            Intent endIntent = new Intent(this, EndGameActivity.class);
            endIntent.putExtra("grades", gradesBar.getProgress());
            endIntent.putExtra("ability", abilityBar.getProgress());
            endIntent.putExtra("mental", mentalBar.getProgress());
            endIntent.putExtra("social", socialBar.getProgress());

            Log.i(TAG, "last day");

            startActivity(endIntent);
            finish();

        }

    }

    //    Go to party (Mental Health +6, Grades -6, Social Life +6, CS Ability -6)
    public void partyMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        if (date < 64) {
            gradesBar.incrementProgressBy(-6);
            abilityBar.incrementProgressBy(-6);
            mentalBar.incrementProgressBy(6);
            socialBar.incrementProgressBy(6);

            date++;
            currentDate.setText("Day " + Integer.toString(date) + " of 64");
        } else {
            Intent endIntent = new Intent(this, EndGameActivity.class);
            endIntent.putExtra("grades", gradesBar.getProgress());
            endIntent.putExtra("ability", abilityBar.getProgress());
            endIntent.putExtra("mental", mentalBar.getProgress());
            endIntent.putExtra("social", socialBar.getProgress());

            Log.i(TAG, "last day");

            startActivity(endIntent);
            finish();

        }

    }

}
