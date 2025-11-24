package Threads.Casino;

public class GambleNumber extends Gambler implements Runnable{

	public GambleNumber(int saldo, Bank bank) {
		super(saldo, bank);
	}

	@Override
	public void run() {
        int c = 0;
        while (true) {
            c++;
            int nChoose = random.nextInt(36) + 1;
            int apuesta = 10;
            if (saldo < apuesta || c == 10) {
                break;
            }
            saldo += - apuesta;
            bank.totalMoney += apuesta;
            int result = random.nextInt(37);

            if (result == nChoose) {
                saldo += apuesta * 36;
                bank.totalMoney += -apuesta * 36;
                System.out.println("Has ganado apostando a un numero, Saldo: " + saldo);
                
            }else if (result == 0) {
                System.out.println("Pierdes (salio 0), Saldo: " + saldo);
            }else{
                System.out.println("Perdiste apostando a un numero, Saldo:" + saldo);
            }
            esperar();
        }
	}

    public void esperar(){
        try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}
    }
}