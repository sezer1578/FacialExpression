package com.example.facialexpressions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EmojiEmotionTest extends AppCompatActivity {
    Toolbar toolbar1;
    TextView toolbarTitle;
    Chronometer cmTimer;
    TextView tvResult;
    ImageView ivShowImage;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> techList = new ArrayList<>();
    int index;
    AppCompatButton btn1, btn2, btn3, btn4;
    TextView tvPoints;
    int points;
    long elapsedTime;
    String TAG = "TAG";
    Boolean resume = false;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji_emotion_test);

        toolbar1 = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.titleText);

        toolbar1.setTitle("");
        toolbarTitle.setText("Emoji Emotion Test");
        setSupportActionBar(toolbar1);

        cmTimer = (Chronometer)findViewById(R.id.tvTimer);
        tvResult = findViewById(R.id.tvResult);
        ivShowImage = findViewById(R.id.ivShowImage);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvPoints = findViewById(R.id.tvPoints);
        index = 0;

        techList.add("Happy");
        techList.add("Sad");
        techList.add("Angry");
        techList.add("Surprised");
        techList.add("Bored");
        techList.add("Scared");
        techList.add("Shy");
        techList.add("Grumpy");
        techList.add("Sick");
        map.put(techList.get(0), R.drawable.happyemoji);
        map.put(techList.get(1), R.drawable.sademoji);
        map.put(techList.get(2), R.drawable.angryemoji);
        map.put(techList.get(3), R.drawable.surprisedemoji);
        map.put(techList.get(4), R.drawable.boredemoji);
        map.put(techList.get(5), R.drawable.scaredemoji);
        map.put(techList.get(6), R.drawable.shyemoji);
        map.put(techList.get(7), R.drawable.grumpyemoji);
        map.put(techList.get(8), R.drawable.sickemoji);

        Collections.shuffle(techList);
        points = 0;
        startGame();

        cmTimer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            public void onChronometerTick(Chronometer arg0) {
                if (!resume) {
                    long minutes = ((SystemClock.elapsedRealtime() - cmTimer.getBase())/1000) / 60;
                    long seconds = ((SystemClock.elapsedRealtime() - cmTimer.getBase())/1000) % 60;
                    elapsedTime = SystemClock.elapsedRealtime();
                    Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);

                } else {
                    long minutes = ((elapsedTime - cmTimer.getBase())/1000) / 60;
                    long seconds = ((elapsedTime - cmTimer.getBase())/1000) % 60;
                    elapsedTime = elapsedTime + 1000;
                    Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);

                }
            }
        });
    }
    public void onClick() {
        if(!resume) {
            cmTimer.setBase(SystemClock.elapsedRealtime());
            cmTimer.start();
        }
        else {
            cmTimer.start();
        }
    }

    private void startGame(){
        onClick();
        resume=true;
        tvPoints.setText(points+"/"+techList.size());
        generateQuestions(index);
    }

    private void generateQuestions(int index) {
        ArrayList<String> techListTemp = (ArrayList<String>)techList.clone();
        String correctAnswer = techList.get(index);
        techListTemp.remove(correctAnswer);
        Collections.shuffle(techListTemp);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(techListTemp.get(0));
        newList.add(techListTemp.get(1));
        newList.add(techListTemp.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        btn1.setText(newList.get(0));
        btn2.setText(newList.get(1));
        btn3.setText(newList.get(2));
        btn4.setText(newList.get(3));
        ivShowImage.setImageResource(map.get(techList.get(index)));
    }

    public void nextQuestion(View view) {
        btn1.setBackground(getResources().getDrawable(R.drawable.button_background));
        btn2.setBackground(getResources().getDrawable(R.drawable.button_background));
        btn3.setBackground(getResources().getDrawable(R.drawable.button_background));
        btn4.setBackground(getResources().getDrawable(R.drawable.button_background));
        index++;
        if (index > techList.size() - 1){
            ivShowImage.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            Intent intent = new Intent(EmojiEmotionTest.this, GameOver.class);
            intent.putExtra("points", points);
            intent.putExtra("elapsedTime", elapsedTime);
            startActivity(intent);
            finish();
        } else {
            startGame();
        }
    }
    public void answerSelected(View view) {
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = techList.get(index);

        if(btn1.isPressed()){

            btn1.setBackground(getResources().getDrawable(R.drawable.button_background_selected));


        }else {
            btn1.setBackground(getResources().getDrawable(R.drawable.button_background));

        }
        if(btn2.isPressed()){

            btn2.setBackground(getResources().getDrawable(R.drawable.button_background_selected));


        }else {
            btn2.setBackground(getResources().getDrawable(R.drawable.button_background));

        }
        if(btn3.isPressed()){

            btn3.setBackground(getResources().getDrawable(R.drawable.button_background_selected));


        }else {
            btn3.setBackground(getResources().getDrawable(R.drawable.button_background));

        }
        if(btn4.isPressed()){

            btn4.setBackground(getResources().getDrawable(R.drawable.button_background_selected));


        }else {
            btn4.setBackground(getResources().getDrawable(R.drawable.button_background));

        }
        if(answer.equals(correctAnswer)){
            tvPoints.setText(points + "/"+ techList.size());
            points++;
            tvPoints.setText(points + "/"+ techList.size());
            tvResult.setText(answer+" selected!");
        }else{
            tvPoints.setText(points + "/"+ techList.size());
            tvResult.setText(answer+" selected!");
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        cmTimer.stop();
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(EmojiEmotionTest.this);
            builder.setTitle("Exit Test?");
            builder.setMessage("Do you want to exit test?");
            builder.setNegativeButton("No", null);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                 Intent intent = new Intent(EmojiEmotionTest.this,EmotionOptions.class);
                 startActivity(intent);
                 finish();



                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    cmTimer.start();
                }
            });
            builder.show();

            return true;
        }
        return false;
    }


}