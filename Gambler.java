package Threads.Casino;

import java.util.Random;

public abstract class Gambler  {
    private int saldo;
    private Bank bank;
    private Random random = new Random();

    public Gambler(int saldo, Bank bank) {
        this.saldo = saldo;
        this.bank = bank;

    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Random getRandom() {
        return random;
    }
    public void setRandom(Random random) {
        this.random = random;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }


}
