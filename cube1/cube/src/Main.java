import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.scale(30, 30, 30);
        //cube.rotate(45, 45, 45);
        //cube.translate(50, 0, 0);
        //cube.rotate(0, 0, 0);

        Screen screen = new Screen();
        Container pane = screen.getContentPane();
        pane.setLayout(new GridLayout(2, 0));


        MyPanel panel = new MyPanel(cube);
        Controller controller = new Controller(panel, cube);



        pane.add(controller.getRx());


        pane.add(controller.getRy());


        pane.add(controller.getRz());

        pane.add(controller.getS());


        pane.add(controller.getTx());


        pane.add(controller.getTy());


        pane.add(controller.getTz());

        pane.add(panel);

        cube.addObserver(controller.getRx());
        cube.addObserver(controller.getRy());
        cube.addObserver(controller.getRz());
        cube.addObserver(controller.getS());
        cube.addObserver(controller.getTx());
        cube.addObserver(controller.getTy());
        cube.addObserver(controller.getTz());
    }
}