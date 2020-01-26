package com.example.application_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp ;
    OmarAudioManager oam ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this ,R.raw.monster);
        oam = new OmarAudioManager(this,mp);
        oam.setVolumeSeekBar((SeekBar) findViewById(R.id.VolSeekBar));
        oam.setProgressSeekBar((SeekBar) findViewById(R.id.ProgressSeekBar));
    }
    public void play (View v){
        oam.play();
    }
    public void pause (View v){
        oam.pause();
    }
}
