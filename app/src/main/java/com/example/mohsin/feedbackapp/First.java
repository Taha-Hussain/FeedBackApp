package com.example.mohsin.feedbackapp;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class First extends AppCompatActivity implements SurfaceHolder.Callback{

    protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;
    private SurfaceView SurView;
    private SurfaceHolder camHolder;
    private boolean previewRunning;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    final Context context = this;
    public static Camera camera = null;
    private ImageView camera_image;
    private Bitmap bmp,bmp1;
    private ByteArrayOutputStream bos;
    private BitmapFactory.Options options,o,o2;
    private FileInputStream fis;
    ByteArrayInputStream fis2;
    private FileOutputStream fos;
    private File dir_image2,dir_image;
    private FrameLayout CamView;
    SharedPreferences settings;
    public static final String b1 = "butone";
    public static final String b2 = "buttwo";
    public static final String b3 = "butthree";

    String ba1;
    File tmpFile;
    public static String URL = "http://friendsfashion.net/android/UploadImage/upload-image.php";
    byte[] bitmapdata;

    public class uploadToServer extends AsyncTask<Void, Void, String> {

        ProgressDialog pd = new ProgressDialog(First.this);

        protected void onPreExecute() {
            super.onPreExecute();
            pd.setMessage("Wait Image Is Uploading!");
            pd.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            ba1 = Base64.encodeToString(bitmapdata, 0);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("encoded_string", ba1));
            nameValuePairs.add(new BasicNameValuePair("image_name", System.currentTimeMillis() + ".jpg"));
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(URL);
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                String st = EntityUtils.toString(response.getEntity());
                Log.v("log_tag", "In the try Loop" + st);
                Toast.makeText(First.this, "Image Uploaded On Server", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Log.v("log_tag", "Error in http connection " + e.toString());
            }
            return "Success";

        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        settings = getSharedPreferences("mysettings",Context.MODE_PRIVATE);


        CamView = (FrameLayout) findViewById(R.id.camview);

        SurView = (SurfaceView)findViewById(R.id.sview);
        camHolder = SurView.getHolder();
        camHolder.addCallback(this);
        camHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        button1 = (ImageButton)findViewById(R.id.img_smiley);
        button2 = (ImageButton)findViewById(R.id.img_neutral);
        button3 = (ImageButton)findViewById(R.id.img_sad);



        camera_image = (ImageView) findViewById(R.id.camera_image);


        button1.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                SharedPreferences.Editor editor = settings.edit();
                editor.putString("value","2");
                editor.commit();
                button1.setClickable(true);
                //  button1.setVisibility(View.INVISIBLE);  //<-----HIDE HERE
                camera.takePicture(null, null, mPicture);
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Second_activity");

                startActivity(intent);    }

                }, 1000L);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();



            }

        });
        button2.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("value","1");
                editor.commit();
                button2.setClickable(true);
                //  button1.setVisibility(View.INVISIBLE);  //<-----HIDE HERE
                camera.takePicture(null, null, mPicture);
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Second_activity");

                        startActivity(intent);    }

                }, 1000L);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }

        });

        button3.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("value","-1");
                editor.commit();
                button3.setClickable(true);
                //  button1.setVisibility(View.INVISIBLE);  //<-----HIDE HERE
                camera.takePicture(null, null, mPicture);
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent intent = new Intent("com.example.mohsin.feedbackapp.Second_activity");

                        startActivity(intent);    }

                }, 1000L);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }

        });


    }



    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        if(previewRunning){
            camera.stopPreview();
        }
        Camera.Parameters camParams = camera.getParameters();
        Camera.Size size = camParams.getSupportedPreviewSizes().get(0);
        camParams.setPreviewSize(size.width, size.height);
        camera.setParameters(camParams);
        try{
            camera.setPreviewDisplay(holder);
            camera.startPreview();
            previewRunning=true;
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    private Camera openFrontFacingCamera()
    {
        int cameraCount = 0;
        Camera cam = null;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        cameraCount = Camera.getNumberOfCameras();
        for ( int camIdx = 0; camIdx < cameraCount; camIdx++ ) {
            Camera.getCameraInfo( camIdx, cameraInfo );
            if ( cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT  ) {
                try {
                    cam = Camera.open( camIdx );
                } catch (RuntimeException e) {
                    //  Log.e(TAG "Camera failed to open: " + e.getLocalizedMessage());
                }
            }
        }

        return cam;
    }



    public void surfaceCreated(SurfaceHolder holder) {
        try{
            camera=openFrontFacingCamera();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.stopPreview();
        camera.release();
        camera=null;
    }



    public void TakeScreenshot(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int nu = preferences.getInt("image_num",0);
        nu++;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("image_num",nu);
        editor.commit();
        CamView.setDrawingCacheEnabled(true);
        CamView.buildDrawingCache(true);
        bmp = Bitmap.createBitmap(CamView.getDrawingCache());
        CamView.setDrawingCacheEnabled(false);
        bos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.JPEG, 100, bos);
        bitmapdata = bos.toByteArray();
        fis2 = new ByteArrayInputStream(bitmapdata);

        String picId=String.valueOf(nu);
        String myfile="MyImage"+picId+".jpeg";

        dir_image = new  File(Environment.getExternalStorageDirectory()+ File.separator+"My Custom Folder");
        dir_image.mkdirs();

        try {
            tmpFile = new File(dir_image,myfile);
            fos = new FileOutputStream(tmpFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis2.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            fis2.close();
            fos.close();

            Toast.makeText(getApplicationContext(),
                    "The file is saved at :/My Custom Folder/"+"MyImage"+picId+".jpeg",Toast.LENGTH_LONG).show();

            bmp1 = null;
            camera_image.setImageBitmap(bmp1);
            camera.startPreview();
            button1.setClickable(true);
            button2.setClickable(true);
            button3.setClickable(true);
            new uploadToServer().execute();
            //button1.setVisibility(View.VISIBLE);//<----UNHIDE HER
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private PictureCallback mPicture = new PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            dir_image2 = new  File(Environment.getExternalStorageDirectory()+
                    File.separator+"My Custom Folder");
            dir_image2.mkdirs();


            File tmpFile = new File(dir_image2,"TempImage.jpg");
            try {
                fos = new FileOutputStream(tmpFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
            options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;

            bmp1 = decodeFile(tmpFile);
            bmp=Bitmap.createScaledBitmap(bmp1,CamView.getWidth(), CamView.getHeight(),true);
            camera_image.setImageBitmap(bmp);
            tmpFile.delete();
            TakeScreenshot();

        }
    };


    public Bitmap decodeFile(File f) {
        Bitmap b = null;
        try {
            // Decode image size
            o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;

            fis = new FileInputStream(f);
            BitmapFactory.decodeStream(fis, null, o);
            fis.close();
            int IMAGE_MAX_SIZE = 1000;
            int scale = 1;
            if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
                scale = (int) Math.pow(
                        2,
                        (int) Math.round(Math.log(IMAGE_MAX_SIZE
                                / (double) Math.max(o.outHeight, o.outWidth))
                                / Math.log(0.5)));
            }

            // Decode with inSampleSize
            o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            fis = new FileInputStream(f);
            b = BitmapFactory.decodeStream(fis, null, o2);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }
}