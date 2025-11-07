package Threads.Casino;

import java.util.Random;

public class Gambler {
    int saldo;
    Bank bank;
    Random random = new Random();

    public Gambler(int saldo, Bank bank) {
        this.saldo = saldo;
        this.bank = bank;

    }



}
