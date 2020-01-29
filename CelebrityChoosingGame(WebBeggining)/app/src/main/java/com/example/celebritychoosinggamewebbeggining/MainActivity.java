package com.example.celebritychoosinggamewebbeggining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>ImageLinks , ImageNames;
    ArrayList<Button> buttons ;
    String ans ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons = new ArrayList<>();
        buttons.add((Button)findViewById(R.id.b0));
        buttons.add((Button)findViewById(R.id.b1));
        buttons.add((Button)findViewById(R.id.b2));
        buttons.add((Button)findViewById(R.id.b3));
        this.initialize();
    }

    public void initialize() {
        HTMLAsync a = new HTMLAsync();
        a.execute("http://www.posh24.se/kandisar");
        String s = null;
        try {
            s = a.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringFormatter ssss = new StringFormatter("<div class=\"image\">\\s*<(.*?)>");
        ssss.setString(s);
        ImageNames = new ArrayList<>();
        ImageLinks = new ArrayList<>();
        while (ssss.next()) {
            ImageNames.add(ssss.getName());
            ImageLinks.add(ssss.getLink());
        }
        this.changeChoices();
    }
    public void changeChoices(){
        Random rand = new Random();
        int x = rand.nextInt(4),y = rand.nextInt(ImageLinks.size());
        ans = ImageNames.get(y);
        Set<String> s = new HashSet<>();
        s.add(ImageNames.get(y));
        for(int i=0 ; i<4 ; i++){
            int z = rand.nextInt(ImageLinks.size());
            while(s.contains(ImageNames.get(z)))z = rand.nextInt(ImageLinks.size());
            s.add(ImageNames.get(z));
            buttons.get(i).setTag(ImageNames.get(z));
            buttons.get(i).setText(ImageNames.get(z));
        }
        buttons.get(x).setTag(ImageNames.get(y));
        buttons.get(x).setText(ImageNames.get(y));
        ImageAsync a = new ImageAsync();a.execute(ImageLinks.get(y));
        ImageView img = findViewById(R.id.img);
        try {
            img.setImageBitmap(a.get());
        }catch (Exception e){}
    }
    public void choiceMade(View v){

        if(ans.equals(v.getTag())) Toast.makeText(this , "Correct !", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this , "Wrong !", Toast.LENGTH_SHORT).show();
        changeChoices();
    }
}
