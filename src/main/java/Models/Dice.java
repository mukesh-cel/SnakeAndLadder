package Models;

public class Dice {
    private int n;

    public Dice(int n) {
        this.n = n;
    }
    public int rollDice(){
       return  (int)((Math.random()*(6*(n)-1*(n)))+1);
    }
}
