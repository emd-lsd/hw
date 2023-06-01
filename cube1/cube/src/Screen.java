import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private static int _WIDTH = 1200;
    private static int _HEIGHT = 500;

    public Screen(){

        //this.setDoubleBuffered(true); //для JPanel
        this.setTitle("CUBE");
        this.setSize(_WIDTH, _HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        super.paint(g2d);
/*
        g2d.translate(_WIDTH/2, _HEIGHT/2);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 0, _WIDTH/2, 0);
        g2d.drawLine(0, 0, 0, _HEIGHT/2);
        _cube.draw(g2d);

 */
    }
}
