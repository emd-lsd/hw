import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MyButton1 extends JButton implements Observer{
    private Counter counter;
    private MyPanel panel;

    public MyButton1(Counter counter, MyPanel panel){
        this.setText("Pop");

        MyButtonListener listener = new MyButtonListener();

        this.addActionListener(listener);


        this.counter = counter;
        this.panel = panel;
    }

    public void update(Observable o, Object arg) {
        counter = (Counter) o;
        panel.setStr(counter.getCounter());
        panel.repaint();
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            counter.decrement();
        }
    }


}
