import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private Cube _cube;

    private static int _WIDTH = 450;
    private static int _HEIGHT = 450;

    public Screen(Cube cube){
        _cube = cube;


        //this.setDoubleBuffered(true); //для JPanel
        this.setTitle("CUBE");
        this.setSize(_WIDTH, _HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        Graphics2D d = (Graphics2D) g;
        super.paint(d);
        d.setColor(Color.black);
        d.translate(_WIDTH/2, _HEIGHT/2);
        d.drawLine(0, 0, _WIDTH/2, 0);
        d.drawLine(0,0,0,_HEIGHT/2);
        //d.fillOval(0,0,3,3);

        _cube.draw(d);
    }
}