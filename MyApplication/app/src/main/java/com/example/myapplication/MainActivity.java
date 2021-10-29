package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android_serialport_api.LedColors;
import android_serialport_api.LedControlUtil;

public class MainActivity extends AppCompatActivity {

    private boolean occupied;

    private LedControlUtil ledControlUtil;

    private ConstraintLayout layout;
    private TextView textViewStatus;
    private Button buttonOccupy;
    private Button buttonLeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ledControlUtil = new LedControlUtil();
        initViewElements();
        leave(null);
    }

    private void initViewElements() {
        layout = findViewById(R.id.layout);

        textViewStatus = findViewById(R.id.textViewStatus);

        buttonOccupy = findViewById(R.id.buttonOccupy);
        buttonOccupy.setOnClickListener(this::occupy);

        buttonLeave = findViewById(R.id.buttonLeave);
        buttonLeave.setOnClickListener(this::leave);

        updateView();
    }

    private void occupy(View v) {
        if (!occupied) {
            occupied = true;
            updateView();
        }
    }

    private void leave(View v) {
        if (occupied) {
            occupied = false;
            updateView();
        }
    }

    private void updateView() {
        if (occupied) {
            layout.setBackgroundResource(R.color.occupied);
            textViewStatus.setText(R.string.occupied);
            ledControlUtil.ledLoop(LedColors.GREEN.getColorIdentifier(), LedColors.RED.getColorIdentifier());
        } else {
            layout.setBackgroundResource(R.color.available);
            textViewStatus.setText(R.string.available);
            ledControlUtil.ledLoop(LedColors.RED.getColorIdentifier(), LedColors.GREEN.getColorIdentifier());
        }
    }

}