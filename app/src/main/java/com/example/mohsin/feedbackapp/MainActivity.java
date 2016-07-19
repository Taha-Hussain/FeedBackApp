package com.example.mohsin.feedbackapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences  sharedpreferences;

    Button btnbranch;
    TextView name;
    public static final String Name = "nameKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        name = (TextView) findViewById(R.id.cu_branch);
        sharedpreferences  = getSharedPreferences("myPrefnew", Context.MODE_PRIVATE);
        if (sharedpreferences .contains(Name)) {
            name.setText(sharedpreferences .getString(Name, ""));

        }


        btnbranch=(Button) findViewById(R.id.btn_branch);

        btnbranch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);

                EditText editText = (EditText)findViewById(R.id.cu_branch);
                String text = editText.getText().toString();

                Intent myIntent = new Intent(v.getContext(),Third_activity.class);
                myIntent.putExtra("mytext",text);
                gotonew(v);
                startActivity(i);
                finish();
            }
        });

        SharedPreferences pref = getSharedPreferences("myPrefnew", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();
        } else {
            Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();
        }
    }




    public void onDestroy()
    {
        super.onDestroy();
        String n = name.getText().toString();
        Editor editor = sharedpreferences .edit();
        editor.putString(Name, n);
        editor.apply();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void gotonew(View v)
    {
        EditText editText = (EditText)findViewById(R.id.cu_branch);
        String text = editText.getText().toString();

        Intent myIntent = new Intent(v.getContext(),Urdu_third.class);
        myIntent.putExtra("mytext",text);

    }
}


