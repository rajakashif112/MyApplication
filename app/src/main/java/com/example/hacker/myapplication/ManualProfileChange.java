package com.example.hacker.myapplication;

import android.app.Activity;
import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.hardware.SensorManager;
import android.widget.ImageButton;
import android.media.AudioManager;

/**
 * Created by Hacker on 15/08/2015.
 */
public class ManualProfileChange extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual_profile_change);
        
        final AudioManager myAudio=(AudioManager) getSystemService(AUDIO_SERVICE);
        final ImageButton Sillent=(ImageButton) findViewById(R.id.imageButton7);
        final ImageButton Vibrate=(ImageButton) findViewById(R.id.imageButton8);
        final ImageButton Ringer=(ImageButton) findViewById(R.id.imageButton6);


        Ringer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);


            }
        });
        Sillent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudio.setRingerMode(AudioManager.RINGER_MODE_SILENT);

            }
        });
        Vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

            }
        });


    }
}
