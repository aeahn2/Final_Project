package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Represents the game activity, where the user plays the game and sees its state.
 */

public final class GameActivity extends AppCompatActivity {
    int date = 0;
    ProgressBar gradesBar = findViewById(R.id.gradesBar);
    ProgressBar abilityBar = findViewById(R.id.abilityBar);
    ProgressBar mentalBar = findViewById(R.id.mentalBar);
    ProgressBar socialBar = findViewById(R.id.socialbar);


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }

    // bring up initial stats

    private void updateStats() {
        Button workMP = findViewById(R.id.workMP);
        Button friends = findViewById(R.id.friends);
        Button prairieLearn = findViewById(R.id.prairieLearn);
        Button party = findViewById(R.id.party);
        Intent intent = new Intent(this, GameActivity.class);

        workMP.setOnClickListener(unused -> workMPMethod());
        friends.setOnClickListener(unused -> friendsMethod());
        prairieLearn.setOnClickListener(unused -> prairieLearnMethod());
        party.setOnClickListener(unused -> partyMethod());


    }
    public void workMPMethod() {
        date++;
        gradesBar.setProgress(3);

    }

    public void friendsMethod() {
        date++;
    }

    public void prairieLearnMethod() {
        date++;
    }

    public void partyMethod() {
        date++;
    }

}
