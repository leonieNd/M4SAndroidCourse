package com.example.lonie.asynctaskbln;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //getting Image

            new DownloadImg((ImageView) findViewById(R.id.imageView))
                    .execute("https://raw.githubusercontent.com/leonieNd/M4SAndroidCourse/master/senegal.png");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class DownloadImg extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public DownloadImg(ImageView myimg) {
            this.imageView = myimg;
            Toast.makeText(getApplicationContext(), "Chargement de l'image en cours. PATIENTEZ SVP", Toast.LENGTH_LONG).show();
            isonline();
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String link = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(link).openStream();
                bitmap = BitmapFactory.decodeStream(in);
                URL url = new URL("https://raw.githubusercontent.com/leonieNd/M4SAndroidCourse/master/senegal.png");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    Toast.makeText(getApplicationContext(), "Connexion Impossible !", Toast.LENGTH_LONG).show();
                    throw new Exception("Failed to connect");
                }



            } catch (Exception e) {
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
        public boolean isonline() {
            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
            else  {
                Toast.makeText(getApplicationContext(), "Vous n'avez pas accès à Internet. Veuillez vous connectez à Internet en premier.", Toast.LENGTH_LONG).show();
                return false;
            }
        }



    }


}
