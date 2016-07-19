package com.example.mohsin.feedbackapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

public class Third_activity extends AppCompatActivity {
    SharedPreferences sharedpreferences;

    EditText cuName, cuNic, cuCell;
    Button btnCreateUser;

    TextView name,cuFb;
    public static final String Name = "nameKey";
    public static final String b1 = "butone";
    public static final String b2 = "buttwo";
    public static final String b3 = "butthree";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        name = (TextView)findViewById(R.id.branchview);
        cuName =(EditText) findViewById(R.id.cu_name);
        cuNic = (EditText) findViewById(R.id.cu_nic);
        cuCell = (EditText) findViewById(R.id.cu_cell);
        cuFb=(TextView) findViewById(R.id.cu_fb);
        btnCreateUser=(Button) findViewById(R.id.btn_createuser);

        sharedpreferences = getSharedPreferences("myPrefnew", Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        SharedPreferences settings = getSharedPreferences("mysettings",
                Context.MODE_PRIVATE);

        cuFb.setText(settings.getString("value",""));

        btnCreateUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String cname, nic, cell,fb, branchname;

                cname = cuName.getText().toString();
                nic = cuNic.getText().toString();
                cell = cuCell.getText().toString();
                fb = cuFb.getText().toString();
                branchname = name.getText().toString();
                UserDetailsTable userDetail = new UserDetailsTable(cname,
                        nic, cell, fb, branchname);

                new AsyncCreateUser().execute(userDetail);

            }
        });
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Third_activity.this, MainActivity.class);
                Third_activity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }

        }, 250000L);

    }
    /*public void Get(View view) {
            name = (TextView) findViewById(R.id.cu_branch);

            sharedpreferences = getSharedPreferences("myPref",Context.MODE_PRIVATE);

            if (sharedpreferences.contains(Name)) {
                name.setText(sharedpreferences.getString(Name, ""));
            }

        }*/
    protected class AsyncCreateUser extends
            AsyncTask<UserDetailsTable, Void, Void> {

        @Override
        protected Void doInBackground(UserDetailsTable... params) {

            RestAPI api = new RestAPI();
            try {

                api.CreateNewAccount(params[0].getCustomerName(),
                        params[0].getCustomerNic(), params[0].getCustomerCell(),
                        params[0].getCustomerFeedback(),params[0].getBranch());

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncCreateUser", e.getMessage());

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            Intent i = new Intent(Third_activity.this, Thankyou.class);
            startActivity(i);
        }

    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.

     @TargetApi(Build.VERSION_CODES.HONEYCOMB)
     private void setupActionBar() {
     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }
     }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
