package Threads.Casino;

public class GambleMartindala extends Gambler implements Runnable{

    int nChoose;
    int apuestaActual = 10;

    public GambleMartindala(int saldo, Bank bank) {
        super(saldo, bank);
        nChoose = random.nextInt(36) + 1;
    }

    @Override
    public void run() {
        while(true){
            int apuesta = apuestaActual;
            if (saldo < apuesta) {
                break;
            }
            saldo += - apuesta;
            bank.totalMoney += apuesta;

            int result = random.nextInt(37);

            if (result == nChoose) {
                saldo += apuesta * 36;
                bank.totalMoney += -apuesta * 36;
                System.out.println("Has ganado a Martindala, Saldo: " + saldo);
                apuestaActual = 10;
                nChoose = random.nextInt(36) + 1;
            }else{
                apuestaActual *= 2;
                System.out.println("Has Perdido a Martindala, Nueva apuesta: " + apuestaActual);
            }
            esperar();
        }
    }

    public void esperar(){
        try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}
    }
}
