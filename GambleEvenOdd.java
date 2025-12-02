package Threads.Casino;


public class GambleEvenOdd extends Gambler implements Runnable{

    public GambleEvenOdd(int saldo, Bank bank) {
        super(saldo, bank);
    }



    @Override
    public void run() {
        int c = 0;
        while(true){
            c++;
            Boolean apuestaPar = random.nextBoolean();
            int apuesta = 10;
            if (saldo > apuesta || c == 10) {
                break;
            }
            saldo += - apuesta;
            bank.setTotalMoney(bank.getTotalMoney() + apuesta); 
            int result = random.nextInt(37);

            if (result != 0 && (result % 2 == 0) == apuestaPar) {
                saldo += apuesta * 2;
                bank.setTotalMoney(bank.getTotalMoney() - apuesta *2);
                System.out.println("Ganaste apostando a par o impar, Saldo: " + saldo);
            }else if (result == 0) {
                System.out.println("Perdiste (salio 0), Saldo: " + saldo);
            }else{
                System.out.println("Perdiste apostando a par o impar, Saldo: " + saldo);
            }
            esperar();
        }
    }



   public void esperar(){
    try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}
   }
    
}