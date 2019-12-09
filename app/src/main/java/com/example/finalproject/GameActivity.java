package com.example.finalproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Represents the game activity, where the user plays the game and sees its state.
 */

public final class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    private static int date = 0;
    private String[] weekArray = new String[]{"Mon", "Wed", "Fri", "Sun"};
    private static int weekCounter = 1;
    private StringBuilder activityLogText = new StringBuilder();
    private static int counterMP = 0;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();

        date = 0;
        weekCounter = 1;
        counterMP = 0;



        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        String name = intent.getStringExtra("name");
        TextView playerName = findViewById(R.id.playerName);

        TextView playerMode = findViewById(R.id.playerMode);
        playerMode.setText(intent.getStringExtra("mode"));

        playerName.setText(name);
        Log.i(TAG, name);

        currentDate.setText(dateDisplay());

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        MediaPlayer welcome = MediaPlayer.create(GameActivity.this,R.raw.welcome);
        welcome.setVolume(1f, 1f);
        welcome.start();
        activityLogText.append("Welcome to [enter game name later]! Today is your first day of CS 125. \n");
        if (intent.getStringExtra("mode").equals("Beginner")) {
            activityLogText.append("As a beginner CS student, your CS ability is low due to lack of experience, " +
                    "but your mental health is high as a young, naive CS prospect. \n");
        } else {
            activityLogText.append("As an advanced CS student, your CS ability is high due to your experience, " +
                    "but as a result of cranking out countless lines of code and fixing an inordinate amount of errors, " +
                    "your mental health has suffered. \n");
        }
        activityLogText.append("You walk into the lecture hall, along with over 200 other students." +
                " As everyone settles down, you notice a beautiful, almost ethereal man donning a baseball cap on the stage." +
                " He clears his throat and begins to speak in a low, chocolaty voice: \n");
        activityLogText.append("\"Welcome to CS 125. My name is Geoff Challen and I am your professor for this course." +
                " CS 125 is 16 weeks long. Each week on Monday, Wednesday, Friday, and Sunday, " +
                "you will choose an activity to do. Each activity affects your grades, CS ability, mental health, and social life" +
                " in a different way. You can choose any activity you want, but try to keep all of your bars as high as possible. " +
                "At the end of this course, you will receive a final grade that determines whether" +
                " you pass or fail. Oh, and I almost forgot: your MP is due Sunday, and if you don't work on it at least once by then, " +
                "your grade will drop 10 points--no extensions or exceptions! Good luck!\" \n");
        activityLogText.append("He takes off his cap, and the fluorescent lights above reflect off of his shiny, bald head. " +
                "And with that, he disappears in a puff of smoke, leaving you with your newfound powers as a CS 125 student. \n" + "\n");
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


//    Work on MP (Mental Health -7, Grades +8, Social Life -5, CS Ability +6)
    public void workMPMethod() {
        counterMP++;
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        gradesBar.incrementProgressBy(8);
        abilityBar.incrementProgressBy(6);
        mentalBar.incrementProgressBy(-7);
        socialBar.incrementProgressBy(-5);

        TextView activityDisplay = findViewById(R.id.activityDisplay);

        List<String> givenList = Arrays.asList("You spent hours toiling away on the MP. \n \n",
                "Your eyes go blurry from staring at your MP. \n \n",
                "You make some more progress on the MP. \n \n");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));

        activityLogText.append("Week " + weekCounter + "(" + weekArray[date % 4] + ") : " + randomElement);
        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });


        date++;
        checkMP();
        currentDate.setText(dateDisplay());

    }


    //    Spend time with friends (Mental Health +3, Grades 0, Social Life +3, CS Ability -1)
    public void friendsMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);


        gradesBar.incrementProgressBy(0);
        abilityBar.incrementProgressBy(-1);
        mentalBar.incrementProgressBy(+3);
        socialBar.incrementProgressBy(+3);

        TextView activityDisplay = findViewById(R.id.activityDisplay);

        List<String> givenList = Arrays.asList("You spent quality time with your friends. \n \n",
                "You join your friends for a movie night. \n \n",
                "You decide to go to the ARC with your friends. \n \n");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));

        activityLogText.append("Week " + weekCounter + "(" + weekArray[date % 4] + ") : " + randomElement);

        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });

        date++;
        checkMP();
        currentDate.setText(dateDisplay());


    }

    //    Do PrairieLearn (Mental Health -1, Grades +3, Social Life -1, CS Ability +3)
    public void prairieLearnMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        gradesBar.incrementProgressBy(3);
        abilityBar.incrementProgressBy(3);
        mentalBar.incrementProgressBy(-1);
        socialBar.incrementProgressBy(-1);

        TextView activityDisplay = findViewById(R.id.activityDisplay);

        List<String> givenList = Arrays.asList("You wasted an hour on daily homework. \n \n",
                "Your homework is especially easy today, and you crank it out in 10 minutes. \n \n",
                "Geoff's voice in your head urges you to finish your daily homework. \n \n");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));

        activityLogText.append("Week " + weekCounter + "(" + weekArray[date % 4] + ") : " + randomElement);

        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });

        date++;
        checkMP();
        currentDate.setText(dateDisplay());

    }

    //    Go to party (Mental Health +5, Grades -6, Social Life +8, CS Ability -5)
    public void partyMethod() {
        ProgressBar gradesBar = findViewById(R.id.gradesBar);
        ProgressBar abilityBar = findViewById(R.id.abilityBar);
        ProgressBar mentalBar = findViewById(R.id.mentalBar);
        ProgressBar socialBar = findViewById(R.id.socialBar);
        TextView currentDate = findViewById(R.id.date);

        gradesBar.incrementProgressBy(-6);
        abilityBar.incrementProgressBy(-5);
        mentalBar.incrementProgressBy(5);
        socialBar.incrementProgressBy(8);

        TextView activityDisplay = findViewById(R.id.activityDisplay);

        List<String> givenList = Arrays.asList("You got absolutely hammered at a party and ascended into a state of Nirvana. \n \n",
                "You go wild on the dance floor at a party and videos of your moves go viral. \n \n",
                "You convince yourself that 'Geoff wouldn't mind' and head out to a midnight party. \n \n");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));

        activityLogText.append("Week " + weekCounter + "(" + weekArray[date % 4] + ") : " + randomElement);

        activityDisplay.setText(activityLogText);

        ScrollView scrollView = findViewById(R.id.activityLog);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });

        date++;
        checkMP();
        currentDate.setText(dateDisplay());

    }

    public String dateDisplay() {
        Log.i(TAG, Integer.toString(counterMP));
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

    public void checkMP() {
        Log.i(TAG, Integer.toString(counterMP));
        if (counterMP == 0 && date == 4) {
            ProgressBar gradesBar = findViewById(R.id.gradesBar);
            gradesBar.incrementProgressBy(-10);

            MediaPlayer disappointed = MediaPlayer.create(GameActivity.this,R.raw.disappointed);
            disappointed.start();
            TextView activityDisplay = findViewById(R.id.activityDisplay);

            activityLogText.append("You forgot to work on your MP! Tears slide down your face as Geoff" +
                    " docks 10 points from your grade, a disappointed look on his angelic face. \n \n");
            activityDisplay.setText(activityLogText);
            ScrollView scrollView = findViewById(R.id.activityLog);
            scrollView.fullScroll(View.FOCUS_DOWN);
        } else if (date == 4){
            counterMP = 0;
        }

    }

}
