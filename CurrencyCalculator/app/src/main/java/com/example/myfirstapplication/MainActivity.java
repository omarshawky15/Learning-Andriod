package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View button) {
        TextView TX_1 = findViewById(R.id.userAmount);
        String s  = TX_1.getEditableText().toString();
        Double d ;
        if(s.matches("\\d*.\\d+"))d = Double.parseDouble(s);
        else {
            Toast.makeText(this, "Error in number", Toast.LENGTH_SHORT).show();
            return;
        }
        TX_1 = findViewById(R.id.ans);
        TX_1.setText(Double.toString(d*10));
    }
}
