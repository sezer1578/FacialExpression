package com.example.facialexpressions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmotionOptions extends AppCompatActivity {
    Toolbar toolbar1;
    TextView toolbarTitle;
    ImageView human, cartoon, emoji;
    TextView humantext, cartoontext, emojitext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_options);


        toolbar1 = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.titleText);

        toolbar1.setTitle(" ");
        toolbarTitle.setText("Choose Emotion Category ");
        setSupportActionBar(toolbar1);

        human = findViewById(R.id.human);
        humantext = findViewById(R.id.humantext);
        cartoon = findViewById(R.id.cartoon);
        cartoontext = findViewById(R.id.cartoontext);
        emoji = findViewById(R.id.emoji);
        emojitext = findViewById(R.id.emojitext);

        human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionOptions.this, HumanEmotionTest.class);
                startActivity(intent);
                //finish();
            }
        });

        humantext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionOptions.this, HumanEmotionTest.class);
                startActivity(intent);
               // finish();
            }
        });

        cartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionOptions.this, CartoonEmotionTest.class);
                startActivity(intent);
                //finish();
            }
        });

        cartoontext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionOptions.this, CartoonEmotionTest.class);
                startActivity(intent);
                //finish();
            }
        });

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionOptions.this, EmojiEmotionTest.class);
                startActivity(intent);
                //finish();
            }
        });

        emojitext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionOptions.this, EmojiEmotionTest.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}