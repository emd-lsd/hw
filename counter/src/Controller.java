public class Controller {
    private MyButton add;
    private MyButton1 pop;
    public Controller(Counter counter, MyPanel panel){
        add = new MyButton(counter, panel);
        pop = new MyButton1(counter, panel);
    }

    public MyButton getAdd(){return add;}

    public MyButton1 getPop(){return pop;}
}
