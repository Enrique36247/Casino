package Threads.Casino;

import java.util.Random;

public class Bank {
    int totalMoney;

    public Bank(int totalMoney){
        this.totalMoney = totalMoney;
    }

    public int rollRoulette(){
        Random generator = new Random();
        int n = generator.nextInt(37);
        return n;
    }
}
