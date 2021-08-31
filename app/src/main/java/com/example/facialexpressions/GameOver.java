package com.example.facialexpressions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    TextView tvPoints, tvPersonalBest;
    Chronometer timetaken;
    SharedPreferences sharedPreferences;

    Toolbar toolbar1;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        int points = getIntent().getExtras().getInt("points");
        tvPoints = findViewById(R.id.tvPoints);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        timetaken = findViewById(R.id.timetaken);
        sharedPreferences = getSharedPreferences("pref", 0);

        toolbar1 = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.titleText);

        toolbar1.setTitle("");
        toolbarTitle.setText("Game Over");
        setSupportActionBar(toolbar1);
        int pointsSP = sharedPreferences.getInt("pointsSP",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(points > pointsSP){
            pointsSP = points;
            editor.putInt("pointsSP", pointsSP);
            editor.commit();

        }
        tvPersonalBest.setText("" + pointsSP);

        long elapsedTime = getIntent().getExtras().getLong("elapsedTime");
        long minutes = (elapsedTime/1000) / 60;
        long seconds = (elapsedTime/1000) % 60;
        tvPoints.setText("  "+points+"/10");
        timetaken.setText(" "+minutes + ":" + seconds);

    }

    public void goLearning(View view){
        Intent intent = new Intent(GameOver.this, EmotionLearning.class);
        startActivity(intent);
        finish();
    }

    public void gohomepage(View view){
        Intent intent = new Intent(GameOver.this, TestOrLearning.class);
        startActivity(intent);
        finish();
    }

    public void restart(View view){
        Intent intent = new Intent(GameOver.this, EmotionOptions.class);
        startActivity(intent);
        finish();
    }

}