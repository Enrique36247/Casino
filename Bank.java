package Threads.Casino;


public class Bank {
    private int totalMoney;

    public Bank(int totalMoney){
        this.totalMoney = totalMoney;
    }
    public synchronized int getTotalMoney() {return totalMoney;}
    public synchronized void setTotalMoney(int totalMoney) {this.totalMoney = totalMoney;}
}
