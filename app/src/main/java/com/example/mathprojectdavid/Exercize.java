package com.example.mathprojectdavid;

import java.util.Random;

public class Exercize {
    private int num3;

    private int num4;

    /**
     * get random nums to Etgar
     */
    public void generateNumEtgar(){
        Random r = new Random();
        num3 = r.nextInt(10);
        num4 = r.nextInt(90)+10;
    }

    /**
     * get random nums to loach
     */
    public void generateNumloach(){
        Random r = new Random();
        num3 = r.nextInt(10);
        num4 = r.nextInt(10);
    }

    /**
     * get random nums to till 20
     */
    public void generateNumstill20(){
        Random r = new Random();
        num3 = r.nextInt(10);
        num4 = r.nextInt(10)+10;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    /**
     * check if comment = true answer
     * @param answer
     * @return
     */
    public boolean checkAnswer(String answer){
        String result = num3*num4+"";
        if(answer.equals(result))
            return true;
        else
            return false;
    }
}
