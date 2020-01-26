package com.example.application_3_gridlayouts;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class PhraseManager {
    MainActivity ma;
    MediaPlayer mp;
    HashMap<Integer, String> map;

    public PhraseManager(MainActivity ma, MediaPlayer mp) {
        this.ma = ma;
        map = new HashMap<Integer, String>();
        this.mp = mp;
    }

    public void playNew(String s) {
        int id = ma.getResources().getIdentifier("raw/" + s, null, ma.getPackageName());
        mp.pause();
        mp = MediaPlayer.create(ma, id);
        mp.start();
    }
}
