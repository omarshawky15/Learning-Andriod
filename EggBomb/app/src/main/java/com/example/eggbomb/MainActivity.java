package com.example.eggbomb;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer c ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    public String changeTime(int progress){
        int min = progress/60 ,sec = progress%60;
        String s = "";
        if (min == 0)s+="00:";
        else if (min<10) s+="0" +min+":" ;
        else s+=min;
        if (sec == 0)s+="00";
        else if (sec<10) s+="0" +sec;
        else s+=sec;
        return s;
    }
    public int calcTime(String s){
        String []sp = s.split(":");
        return Integer.parseInt(sp[0])*60 + Integer.parseInt(sp[1]);
    }
    public void initialize(){
        Button b = findViewById(R.id.pause);
        b.setEnabled(false);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.start);
        b.setEnabled(true);
        b.setVisibility(View.VISIBLE);
        final TextView timer = findViewById(R.id.timer);
        SeekBar sb = findViewById(R.id.seekBar);
        sb.setEnabled(true);
        sb.setMax(240);
        sb.setProgress(30);
        timer.setText(changeTime(sb.getProgress()));
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.isEnabled()){
                    if(progress==0)progress=30;
                    String s = changeTime(progress);
                    timer.setText(s);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
    public void start(View v){
        Button b = findViewById(R.id.start);
        b.setEnabled(false);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.pause);
        b.setEnabled(true);
        b.setVisibility(View.VISIBLE);
        SeekBar sb = findViewById(R.id.seekBar);
        sb.setEnabled(false);

        final TextView timer = findViewById(R.id.timer);
        int time = calcTime(timer.getText().toString());
        Log.i("info" , Integer.toString(time));
        c = new CountDownTimer(time*1000 ,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int time = calcTime(timer.getText().toString());
                timer.setText(changeTime(time-1));
                Log.i("info" , Integer.toString(time));

            }

            @Override
            public void onFinish() {
                initialize();
            }
        }.start();
    }
    public void pause (View v){
        c.cancel();
        initialize();
    }
}
