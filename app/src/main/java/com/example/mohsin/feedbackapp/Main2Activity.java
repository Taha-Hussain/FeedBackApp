package com.example.mohsin.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {

    public static ImageButton image_urdu;
    public static ImageButton image_english;

//    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
  //  boolean firstTime;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        OnClickImage();


    }

    public void OnClickImage()
    {
        image_urdu = (ImageButton) findViewById(R.id.img_urdu);
        image_english = (ImageButton) findViewById(R.id.img_eng);

        image_urdu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Urdu_first");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );
        image_english.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.First");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    }
                }
        );

    }


}


