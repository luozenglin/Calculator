package com.example.luozenglin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luozenglin.service.StandardCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_standard_layout);
        StandardCalculator standard = new StandardCalculator(this);
    }
}
