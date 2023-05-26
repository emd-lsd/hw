import javax.swing.*;
import java.awt.*;

//PropertyChangeListener
//PropertyChangeSupport

public class Main extends JFrame{
    public Main(){
        this.setTitle("MVC");
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(3, 1)); // разметка


        Counter counter = new Counter(); // model
        MyPanel panel = new MyPanel(counter); //view
        //MyButton button = new MyButton(counter, panel); // controller
        Controller controller = new Controller(counter, panel);

        pane.add(panel); // контейнер элементов окна
        pane.add(controller.getAdd()); //
        pane.add(controller.getPop());

        this.setVisible(true);
		
		counter.addObserver(controller.getAdd()); // задает наблюдателя экземпляр класса Модели за экземпляром класса контроллера
        counter.addObserver(controller.getPop());
    }

    public static void main(String[] args) {
        new Main();
    }
}
