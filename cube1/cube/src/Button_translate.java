import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Button_translate extends JButton implements Observer{
    private Cube cube;
    private Screen panel;

    public Button_translate(Cube cube, Screen panel){
        this.setText("Rotate");

        MyButtonListener listener = new MyButtonListener(); //реакция на нажатие кнопки
        this.addActionListener(listener);

        this.cube = cube;
        this.panel = panel;

    }

    public void update(Observable o, Object arg) {
        cube = (Cube) o;
        //panel.setStr(counter.getCounter());
        panel.repaint();
    }

    private class MyButtonListener implements ActionListener { //реакция на событие(не кнопка)
        public void actionPerformed(ActionEvent e){
            cube.increment_rotatex();
        }
    }
}