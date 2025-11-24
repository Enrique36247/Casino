package Threads.Casino;

public class TreadRunner {
    public static void main(String[] args) throws InterruptedException{
        
        Bank bank = new Bank(50000);
        Thread [] hilos = new Thread[12];
        
        System.out.println("-------Start-------");
        for(int i = 0; i < 4; i++){
            hilos[i] = new Thread(new GambleNumber(1000, bank));
        }
        for(int i = 4; i < 8; i++){
            hilos[i] = new Thread(new GambleEvenOdd(1000, bank));
        }
        for(int i = 8; i < 12; i++){
            hilos[i] = new Thread(new GambleMartindala(1000, bank));
        }
        
        for(Thread h : hilos){
            h.start();
        }
        
        
        
        // marca el hilo como interrumpido
        try{Thread.sleep(30000);}catch(InterruptedException e){Thread.currentThread().interrupt();}

        System.out.println("-------Fin-------");
        System.out.println("Saldo de la banca: " + bank.totalMoney);
    }
}
