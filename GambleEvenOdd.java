package Threads.Casino;


public class GambleEvenOdd extends Gambler implements Runnable{

    public GambleEvenOdd(int saldo, Bank bank) {
        super(saldo, bank);
    }



    @Override
    public void run() {
        while(true){
            Boolean apuestaPar = random.nextBoolean();
            int apuesta = 10;
            if (saldo > apuesta) {
                break;
            }
            saldo += - apuesta;
            bank.totalMoney += apuesta;
            int result = random.nextInt(37);

            if (result != 0 && (result % 2 == 0) == apuestaPar) {
                saldo += apuesta * 2;
                bank.totalMoney += - apuesta * 2;
                System.out.println("Ganaste apostando a par o impar, Saldo: " + saldo);
            }else if (result == 0) {
                System.out.println("Perdiste (salio 0), Saldo: " + saldo);
            }
            esperar();
        }
    }



   public void esperar(){
    try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}
   }
    
}