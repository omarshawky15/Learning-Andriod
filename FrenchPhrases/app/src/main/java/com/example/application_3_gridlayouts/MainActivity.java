package com.example.application_3_gridlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PhraseManager ph ;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = new MediaPlayer();
        ph = new PhraseManager(this , mp);
    }
    public void click (View v){
        String s = v.getTag().toString();
        ph.playNew(s);
    }

}
