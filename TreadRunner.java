package Threads.Casino;

public class TreadRunner {
    public static void main(String[] args) throws InterruptedException{
        Bank b = new Bank(50000);
        Gambler g;
        Thread hilo[] = new Thread[4];
        for(int i = 0; i<4; i++){
            g = new Gambler(1000, b);
            hilo[i] = new Thread(g);
            hilo[i].start();
            hilo[i].join();
            System.out.println(g.saldo);
            System.out.println(b.totalMoney);
            Thread.sleep(3000);
        }
    }
}
