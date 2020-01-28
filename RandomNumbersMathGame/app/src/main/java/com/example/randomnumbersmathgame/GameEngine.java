package com.example.randomnumbersmathgame;

public class GameEngine {
    NumbersManager numMan ;
    String ans ;
    private int score =0 , attempts = 00 ;
    public GameEngine(){
        numMan = new NumbersManager();
    }
    public String [] GenerateSums (){
        String []s =  numMan.generateSumNumber() ;
        return s;
    }
    public String GenerateMath(){
        String[] s = numMan.GenerateMath();
        ans  = s[1] ;
        return s [0] ;
    }
    public boolean validate (String ans){
        if(this.ans.equals(ans)){score++;attempts++;return true ;}
        else {attempts++;return false ;}
    }
    public int getScore (){return score;}
    public int getAttempts (){return attempts;}
}
