package com.example.radek.lottogenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    protected TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void generate() {
        Random randomGenerator = new Random();
        List<String> values = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            values.add(i, String.valueOf(randomGenerator.nextInt(60)));
            Collections.shuffle(values);
        }
        String v = values.toString().replace('[', ' ').replace(']', ' ');
        mTextView.setText(v);
    }
}
