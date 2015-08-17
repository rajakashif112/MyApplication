package com.example.hacker.myapplication;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.hardware.SensorManager;
import android.widget.ImageButton;
import android.content.Intent;

import java.util.List;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton  Manual=(ImageButton) findViewById(R.id.imageButton);
        ImageButton  About=(ImageButton) findViewById(R.id.imageButton5);
        ImageButton  Setting=(ImageButton) findViewById(R.id.imageButton4);
        ImageButton Map=(ImageButton) findViewById(R.id.imageButton3);
        ImageButton Tilt=(ImageButton) findViewById(R.id.imageButton2);
        ImageButton Noise=(ImageButton) findViewById(R.id.imageButton11);

        Manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i=new Intent(MainActivity.this,ManualProfileChange.class);
                startActivity(i);
            }
        });
        Noise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(MainActivity.this,NoiseChange.class);
                startActivity(i);

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
}
