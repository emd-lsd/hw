import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TranslateX extends JTextField implements Observer {
    //JTextField smallField;
    private MyPanel panel;
    private Cube cube;

    public TranslateX(MyPanel panel, Cube cube){
        this.panel = panel;
        this.cube = cube;
        // Создание текстовых полей
        new JTextField(15);
        setToolTipText("translateX");
        addActionListener(new MyButtonListener());
        //panel.add(smallField);

    }

    @Override
    public void update(Observable o, Object arg) {
        cube = (Cube) o;
        //panel.setStr(counter.getCounter());
        panel.repaint();
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Отображение введенного текста
            //JOptionPane.showMessageDialog(panel,"Ваше слово: " + smallField.getText());
            String s = getText();
            System.out.println(s);
            cube.translate(Double.parseDouble(s), 0, 0);
        }
    }
}