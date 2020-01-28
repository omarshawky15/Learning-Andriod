package com.example.randomnumbersmathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timer , math , score ;

    Button[] bs;
    GameEngine gm ;
    TimeManager t;
    CountDownTimer c ;
    boolean gameEnded = true ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer); math = findViewById(R.id.mathop); score = findViewById(R.id.score);
        bs = new Button[4];
        bs[0] = findViewById(R.id.b0);
        bs[1] = findViewById(R.id.b1);
        bs[2] = findViewById(R.id.b2);
        bs[3] = findViewById(R.id.b3);
    }
    public void start(View v) {
        gm = new GameEngine();
        t = new TimeManager();
        score.setText("0/0");
        Button b = findViewById(R.id.start);
        b.setVisibility(View.INVISIBLE);
        gameEnded = false ;
        changeOp();
        timer.setText(t.changeTime(30));
        c= new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String s = t.changeTime((int)(millisUntilFinished/1000));
                timer.setText(s);
            }

            @Override
            public void onFinish() {
                endGame();
            }
        }.start();
    }
    public void changeOp (){
        String s = gm.GenerateMath();
        String[] ans = gm.GenerateSums();
        math.setText(s);
        for(int i=0 ;i<4 ;i++){
            bs[i].setText(ans[i]);
            bs[i].setTag(ans[i]);
        }
    }
    public void choice (View view){
        if(!gameEnded) {
            String s = view.getTag().toString();
            gm.validate(s);
            String s2 = gm.getScore() + "/" + gm.getAttempts();
            score.setText(s2);
            changeOp();
        }
        else return ;
    }
    public void endGame (){
        Button play = findViewById(R.id.playagain);
        play.setVisibility(View.VISIBLE);
        gameEnded = true;
    }
}
