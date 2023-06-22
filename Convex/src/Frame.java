import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Convex convex;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public Frame(Convex c){

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Convex");
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна и завершение программы
        this.setVisible(true); //--> paint(g)
        convex = c;
    }

    public void paint(Graphics g){
        Graphics2D d = (Graphics2D) g;

        super.paint(d);
        d.scale(3,3);
        d.setColor(Color.black);
        d.translate(WIDTH/2, HEIGHT/2);
        d.drawLine(0, HEIGHT, 0, -HEIGHT);
        d.drawLine(WIDTH,0,-WIDTH,0);
        d.setColor(Color.MAGENTA);
        convex.draw(d);
        d.setColor(Color.GREEN);
        d.drawOval(-10,-10,20,20);
        d.drawOval(-20,-20,40,40);
        //d.fillOval();

    }
}
