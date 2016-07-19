package com.example.mohsin.feedbackapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Urdu_second extends AppCompatActivity {

    private static ImageButton Urdu_info;
    private static ImageButton Urdu_thanks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_second);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        OnClickImage();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Urdu_second.this, MainActivity.class);
                Urdu_second.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }

        }, 250000L);
    }

    public void OnClickImage() {
        Urdu_info = (ImageButton) findViewById(R.id.urdu_info);
        Urdu_thanks = (ImageButton) findViewById(R.id.urdu_thanks);
        Urdu_info.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Urdu_second.this, Urdu_details.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );
        Urdu_thanks.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_thanks");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );
    }
}
