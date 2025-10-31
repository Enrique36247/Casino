package Threads.Casino;

import java.util.Random;

public class Gambler implements Runnable {
    int saldo = 1000;
    Bank bank;

    public Gambler(int saldo, Bank b) {
        this.saldo = saldo;
        this.bank = b;

    }

    @Override
    public void run() {
        System.out.println("Apuesta Par o Inpar");
        gmableParInpar();
        System.out.println("Apuesta a un numero");
        gambleANumber();
        System.out.println("Apuesta Martingala");
        gambleMartindala();
    }

    public boolean tQSD(int a) {
        if (saldo > a || saldo == a) {
            return true;
        } else {
            return false;
        }
    }

    public void gmableParInpar() {
        if (tQSD(10)) {

            Random generator = new Random();
            int nW = this.bank.rollRoulette();
            String inpar = "Inpar";
            String par = "Par";
            String result = generator.nextBoolean() ? par : inpar;
            saldo += -10;
            this.bank.totalMoney += 10;
            if (result.contains(par)) {
                if (nW % 2 == 0) {
                    System.out.println("Ganaste");
                    saldo += -1 * (10 * 2);
                    this.bank.totalMoney += -20;
                } else {
                    System.out.println("Perdiste");
                }
            } else {
                if (nW % 2 == 1) {
                    System.out.println("Ganaste");
                    saldo += -1 * (10 * 2);
                } else {
                    System.out.println("Perdiste");
                }
            }
        }

    }

    public void gambleANumber() {
        if (tQSD(10)) {
            Random generator = new Random();
            int winnern = this.bank.rollRoulette();
            int gamble = 1 + generator.nextInt(36);

            saldo += -10;
            this.bank.totalMoney += 10;
            if (gamble == winnern) {
                saldo += -1 * (10 * 36);
                System.out.println("Ganaste");
                this.bank.totalMoney += -10 * 36;
            } else {
                System.out.println("Perdiste");
            }
        }

    }

    public void gambleMartindala() {

        Random generator = new Random();
        int winn = this.bank.rollRoulette();
        int gamble = 1 + generator.nextInt(36);
        int apuesta = 10;

        while (winn != gamble && saldo>apuesta) {
            if (saldo <= 0) {
                System.out.println("Te quedaste sin dinero");
                break;
            }
            saldo += -apuesta;
            apuesta = apuesta * 2;
            System.out.println("Perdiste");
            gamble = 1 + generator.nextInt(36);
            this.bank.totalMoney += (apuesta);

        }
        if (winn == gamble) {
            System.out.println("Ganaste");
            saldo += (apuesta * 36);
            this.bank.totalMoney += apuesta * 36;
        }
        if (saldo<apuesta) {
            System.out.println("");
        }

    }
}
