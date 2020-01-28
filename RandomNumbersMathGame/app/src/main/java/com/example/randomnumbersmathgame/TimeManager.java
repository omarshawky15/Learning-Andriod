package com.example.randomnumbersmathgame;

public class TimeManager {
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
}
