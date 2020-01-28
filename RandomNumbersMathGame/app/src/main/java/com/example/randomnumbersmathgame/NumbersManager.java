package com.example.randomnumbersmathgame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumbersManager {
    int multiplier =10 ,ans = 20;
    Random rand ;
    public NumbersManager(){
        rand = new Random();
    }
    public int generateNormalNumber(int max){
        return rand.nextInt(max);
    }
    public String[] GenerateMath (){
        String []s = new String [2];
        int n_1 = this.generateNormalNumber(multiplier) , n_2  = this.generateNormalNumber(multiplier);
        s[0]= n_1 +" + "+n_2;
        ans = (n_1+n_2);
        s[1] = ""+ans ;
        multiplier*=2;
        return s ;
    }
    public String [] generateSumNumber (){
        Set<Integer> set = new HashSet<>();
        String []s = new String[4];
        for(int i =0 ;i<4; i++) {
            int x = generateNormalNumber(ans * 2);
            while(set.contains(x) || x==ans)x =generateNormalNumber(ans * 2);
            set.add(x);
            s[i] = ""+x;
        }
        s[generateNormalNumber(4)] = ""+ans ;
        return s ;
    }

}
