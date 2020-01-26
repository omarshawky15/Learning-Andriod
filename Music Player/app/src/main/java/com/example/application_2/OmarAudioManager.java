package com.example.application_2;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class OmarAudioManager {
    AudioManager am_1 ;
    Context context;
    public MediaPlayer mp;
    Thread time ;
    public SeekBar volsb  , progresssb;
    public OmarAudioManager (Context context, MediaPlayer mp){
        this.context = context;
        this.mp = mp;
        am_1 = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mp) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        progresssb.setProgress(mp.getCurrentPosition());
                    }
                },0,1000);
            }
        });
    }
    public void play (){
        mp.start();
    }
    public void pause (){
        mp.pause();
    }
    public void setVolumeSeekBar (SeekBar sb){
        this.volsb = sb;
        volsb.setMax(am_1.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        sb.setProgress(am_1.getStreamVolume(AudioManager.STREAM_MUSIC));
        am_1.setStreamVolume(AudioManager.STREAM_MUSIC,volsb.getProgress(),0);
        volsb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                am_1.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void setProgressSeekBar(SeekBar sb){
        this.progresssb = sb;
        sb.setMax(mp.getDuration());
        progresssb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });
    }

}
