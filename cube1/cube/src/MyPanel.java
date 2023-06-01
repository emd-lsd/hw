import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private Cube cube;
    private static int _WIDTH = 300;
    private static int _HEIGHT = 300;
    public MyPanel(Cube cube){
        this.cube = cube;
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);

        g2d.translate(_WIDTH/2, _HEIGHT/2);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 0, _WIDTH/2, 0);
        g2d.drawLine(0, 0, 0, _HEIGHT/2);
        cube.draw(g2d);
    }
}
