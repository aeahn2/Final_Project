package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Represents the game activity, where the user plays the game and sees its state.
 */

public final class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    private static int date = 0;
    private String[] weekArray = new String[]{"Mon", "Wed", "Fri", "Sun"};
    private static int weekCounter = 1;
    private StringBuilder activityLogText = new StringBuilder();

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();

        date = 0;
        weekCounter = 1;

        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        String name = intent.getStringExtra("name");
        TextView playerName = findViewById(R.id.playerName);

        playerName.setText(name);
        Log.i(TAG, name);

        currentDate.setText(dateDisplay());

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        activityLogText.append("Welcome to [enter game name later] \n");
        activityDisplay.setText(activityLogText);

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

        gradesBar.incrementProgressBy(8);
        abilityBar.incrementProgressBy(6);
        mentalBar.incrementProgressBy(-6);
        socialBar.incrementProgressBy(-10);

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        activityLogText.append("You spent hours toiling away on the MP. \n");
        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        View lastChild = scrollView.getChildAt(scrollView.getChildCount() - 1);
        int bottom = lastChild.getBottom() + scrollView.getPaddingBottom();
        int sy = scrollView.getScrollY();
        int sh = scrollView.getHeight();
        int delta = bottom - (sy + sh);

        scrollView.smoothScrollBy(0, delta);

        date++;
        currentDate.setText(dateDisplay());

    }


    //    Spend time with friends (Mental Health +4, Grades -2, Social Life +3, CS Ability -2)
    public void friendsMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);


        gradesBar.incrementProgressBy(-2);
        abilityBar.incrementProgressBy(-2);
        mentalBar.incrementProgressBy(+4);
        socialBar.incrementProgressBy(+3);

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        activityLogText.append("You spent quality time with your friends. \n");
        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        View lastChild = scrollView.getChildAt(scrollView.getChildCount() - 1);
        int bottom = lastChild.getBottom() + scrollView.getPaddingBottom();
        int sy = scrollView.getScrollY();
        int sh = scrollView.getHeight();
        int delta = bottom - (sy + sh);

        scrollView.smoothScrollBy(0, delta);

        date++;
        currentDate.setText(dateDisplay());


    }

    //    Do PrairieLearn (Mental Health 0, Grades +2, Social Life 0, CS Ability +2)
    public void prairieLearnMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        gradesBar.incrementProgressBy(2);
        abilityBar.incrementProgressBy(2);
        mentalBar.incrementProgressBy(-1);
        socialBar.incrementProgressBy(-2);

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        activityLogText.append("You wasted an hour on daily homework. \n");
        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        View lastChild = scrollView.getChildAt(scrollView.getChildCount() - 1);
        int bottom = lastChild.getBottom() + scrollView.getPaddingBottom();
        int sy = scrollView.getScrollY();
        int sh = scrollView.getHeight();
        int delta = bottom - (sy + sh);

        scrollView.smoothScrollBy(0, delta);

        date++;
        currentDate.setText(dateDisplay());

    }

    //    Go to party (Mental Health +6, Grades -6, Social Life +6, CS Ability -6)
    public void partyMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        gradesBar.incrementProgressBy(-6);
        abilityBar.incrementProgressBy(-6);
        mentalBar.incrementProgressBy(6);
        socialBar.incrementProgressBy(6);

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        activityLogText.append("You got absolutely hammered at a party and ascended into a state of Nirvana. \n");
        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        View lastChild = scrollView.getChildAt(scrollView.getChildCount() - 1);
        int bottom = lastChild.getBottom() + scrollView.getPaddingBottom();
        int sy = scrollView.getScrollY();
        int sh = scrollView.getHeight();
        int delta = bottom - (sy + sh);

        scrollView.smoothScrollBy(0, delta);

        date++;
        currentDate.setText(dateDisplay());

    }

    public String dateDisplay() {
        if (date == 4) {
            date = 0;
            weekCounter++;
        }
        if (weekCounter > 16) {
            ProgressBar gradesBar = findViewById(R.id.gradesBar);
            ProgressBar abilityBar = findViewById(R.id.abilityBar);
            ProgressBar mentalBar = findViewById(R.id.mentalBar);
            ProgressBar socialBar = findViewById(R.id.socialBar);

            Intent endIntent = new Intent(this, EndGameActivity.class);
            endIntent.putExtra("grades", gradesBar.getProgress());
            endIntent.putExtra("ability", abilityBar.getProgress());
            endIntent.putExtra("mental", mentalBar.getProgress());
            endIntent.putExtra("social", socialBar.getProgress());

            Log.i(TAG, "last day");

            startActivity(endIntent);
            finish();
        }
        return ("Week " + weekCounter + ": " + weekArray[date % 4]);
    }

}
