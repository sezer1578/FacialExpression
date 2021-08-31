package com.example.facialexpressions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EmotionLearning extends AppCompatActivity {
ImageView happyemoji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_learning);
        happyemoji = findViewById(R.id.happyemoji);

        happyemoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmotionLearning.this, LearningHappy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}