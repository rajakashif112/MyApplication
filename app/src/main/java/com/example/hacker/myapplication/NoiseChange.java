package com.example.hacker.myapplication;

/**
 * Created by Hacker on 17/08/2015.
 */
import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;


public class NoiseChange  extends Activity{
    Button act;
    Button Dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noise);
        act=(Button) findViewById(R.id.button3);
        Dec=(Button) findViewById(R.id.button4);
        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getBaseContext(),Noise.class));
            }
        });
        Dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getBaseContext(),Noise.class));

            }
        });
    }
}
