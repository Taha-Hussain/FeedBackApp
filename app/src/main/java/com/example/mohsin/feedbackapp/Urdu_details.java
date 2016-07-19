package com.example.mohsin.feedbackapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.ImageButton;

public class Urdu_details extends AppCompatActivity {
    private static ImageButton urdu_account;
    private static ImageButton urdu_deposit;
    private static ImageButton urdu_atm;
    private static ImageButton urdu_withdraw;
    private static ImageButton urdu_other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        OnClickImage();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Urdu_details.this, MainActivity.class);
                Urdu_details.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }

        }, 250000L);
    }

    public void OnClickImage() {
        urdu_account = (ImageButton) findViewById(R.id.urdu_account);
        urdu_deposit = (ImageButton) findViewById(R.id.urdu_deposit);
        urdu_atm = (ImageButton) findViewById(R.id.urdu_atm);
        urdu_withdraw = (ImageButton) findViewById(R.id.urdu_withdraw);
        urdu_other = (ImageButton) findViewById(R.id.urdu_other);

        urdu_account.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_third");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                }
        );
        urdu_deposit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_third");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                }
        );
        urdu_atm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_third");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                }
        );

        urdu_withdraw.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_third");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                }
        );
        urdu_other.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_third");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                }
        );

    }
}
