package com.example.lonie.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        if (id == R.id.action_help) {

            final Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }
    public void sendSMS(View v){

        final Intent smsintent = new Intent(Intent.ACTION_SENDTO);
        smsintent.setData(Uri.parse("smsto:"+Uri.encode("0686331753")));
        smsintent.putExtra("texte_to_send","Salut Leonie NDOYE");
        startActivity(smsintent);

    }

    public void callNumber(View v){

        Intent phoneintent = new Intent(Intent.ACTION_DIAL);
        phoneintent.setData(Uri.parse("tel:0033686331753"));
        startActivity(phoneintent);
    }

    public void goToWeb(View v){
        Intent webintent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.fr"));
        startActivity(webintent);
    }

    public  void locate(View v){

        String geoUri = String.format("geo:41.69411,44.83368");
        Uri geo = Uri.parse(geoUri);
        Intent mapintent = new Intent(Intent.ACTION_VIEW,geo);
        startActivity(mapintent);
    }
    public void newACT(View v){
        final Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

}
