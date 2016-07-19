package com.example.mohsin.feedbackapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;


public class Customer_details extends AppCompatActivity {

    private static ImageButton image_account;
    private static ImageButton image_deposit;
    private static ImageButton image_atm;
    private static ImageButton image_withdraw;
    private static ImageButton image_other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        OnClickImage();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Customer_details.this, MainActivity.class);
                Customer_details.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }

        }, 250000L);
    }

    public void OnClickImage() {
        image_account = (ImageButton) findViewById(R.id.new_account);
        image_deposit = (ImageButton) findViewById(R.id.deposit);
        image_atm = (ImageButton) findViewById(R.id.atm);
        image_withdraw = (ImageButton) findViewById(R.id.withdraw);
        image_other = (ImageButton) findViewById(R.id.other);

        image_account.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Third_activity");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );
        image_deposit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Third_activity");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );
        image_atm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Third_activity");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );

        image_withdraw.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Third_activity");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );
        image_other.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Third_activity");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );

    }





}