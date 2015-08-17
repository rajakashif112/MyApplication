package com.example.hacker.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.widget.Toast;
import android.media.MediaRecorder;
import android.media.AudioFormat;
import android.os.Bundle;
import android.app.Activity;
import android.app.Application;

import java.io.IOException;


public class Noise extends Service {

    private static final int sampleRate = 8000;
    private int bufferSize=0;
    private double lastLevel = 0;
    public  Thread thread=new Thread();
    private static final int SAMPLE_DELAY = 75;
    AudioManager myaudio=(AudioManager) getSystemService(AUDIO_SERVICE);
     AudioRecord audio = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT, bufferSize);



    public void Resume()
    {


       audio.startRecording();
       thread =new Thread(new Runnable() {
            @Override
            public void run() {
                while(thread != null && !thread.isInterrupted())
                {
                    try {
                        Thread.sleep(SAMPLE_DELAY);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    readAudioBuffer();
                   Thread thre=new Thread(new Runnable() {
                        @Override
                        public void run() {
                              if(lastLevel>0&&lastLevel>50)
                              {
                                  myaudio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                              }
                            else if(lastLevel>100&&lastLevel<170)
                              {
                                  myaudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                              }
                             if(lastLevel>170)
                             {
                                 myaudio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                             }

                        }
                    });thre.start();

                }
            }
        });
        thread.start();
    }


    public Noise() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            bufferSize = AudioRecord.getMinBufferSize(sampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);

        } catch (Exception e) {

        }

        Toast.makeText(this,"Noise Profile Changer Activated",Toast.LENGTH_LONG).show();
        Resume();
        return START_STICKY;

    }

    /**
     * Functionality that gets the sound level out of the sample
     */
    private void readAudioBuffer() {

        try {
            short[] buffer = new short[bufferSize];

            int bufferReadResult = 1;

            if (audio != null) {

                // Sense the voice...
                bufferReadResult = audio.read(buffer, 0, bufferSize);
                double sumLevel = 0;
                for (int i = 0; i < bufferReadResult; i++) {
                    sumLevel += buffer[i];
                }
                lastLevel = Math.abs((sumLevel / bufferReadResult));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        thread.interrupt();
        thread = null;
        try {
            if (audio != null) {
                audio.stop();
                audio.release();
                audio = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Noise Profile Changer is Deactivated",Toast.LENGTH_LONG).show();
    }
}
