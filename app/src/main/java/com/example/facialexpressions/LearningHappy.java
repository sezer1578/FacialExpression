package com.example.facialexpressions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

public class LearningHappy extends AppCompatActivity {
    HorizontalScrollView scroll;
    Toolbar toolbar1;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_happy);
        scroll = findViewById(R.id.scroll);
        scroll.setHorizontalFadingEdgeEnabled(false);
        toolbar1 = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.titleText);

        toolbar1.setTitle("");
        toolbarTitle.setText("Learning Happy");
        setSupportActionBar(toolbar1);

    }
}