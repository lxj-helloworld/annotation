package com.example.annotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.inject.InjectUtils;
import com.example.inject.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.my_textview)
    private TextView my_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        my_textview.setText("success inject45678.");
    }
}
