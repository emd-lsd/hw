import java.util.Observable;

public class Counter extends Observable {
    private int counter;

    public Counter(){
        counter = 0;
    }

    public int getCounter(){
        return counter;
    }

    public void increment(){
        counter++;

        this.setChanged();
        this.notifyObservers(); //this.notifyObservers("1");
    }

    public void decrement(){
        counter--;

        this.setChanged();
        this.notifyObservers();
    }
}
