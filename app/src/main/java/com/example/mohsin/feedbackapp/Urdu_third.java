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

public class Urdu_third extends AppCompatActivity {
    SharedPreferences sharedpreferences;

    EditText cuNameur, cuNicur, cuCellur;
    Button btnCreateUserur;

    TextView name,cuFbur;
    public static final String Name = "nameKey";
    private static ImageButton ur_final;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_thitd);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        name = (TextView)findViewById(R.id.branchview_ur);
        cuNameur =(EditText) findViewById(R.id.cu_name_ur);
        cuNicur = (EditText) findViewById(R.id.cu_nic_ur);
        cuCellur = (EditText) findViewById(R.id.cu_cell_ur);
        cuFbur=(TextView) findViewById(R.id.cu_fb_ur);
        btnCreateUserur=(Button) findViewById(R.id.btn_createuser_ur);

        sharedpreferences = getSharedPreferences("myPrefnew", Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        SharedPreferences fbUrdu = getSharedPreferences("urdu",
                Context.MODE_PRIVATE);
        cuFbur.setText(fbUrdu.getString("value",""));

        btnCreateUserur.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String cname_ur, nic_ur, cell_ur,fb_ur, branchname;

                cname_ur = cuNameur.getText().toString();
                nic_ur = cuNicur.getText().toString();
                cell_ur = cuCellur.getText().toString();
                fb_ur = cuFbur.getText().toString();
                branchname = name.getText().toString();
                UserDetailsTable userDetail = new UserDetailsTable(cname_ur,
                        nic_ur, cell_ur, fb_ur, branchname);

                new AsyncCreateUser().execute(userDetail);

            }
        });

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Urdu_third.this, MainActivity.class);
                Urdu_third.this.startActivity(intent);
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

            Intent i = new Intent(Urdu_third.this, Urdu_thanks.class);
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
