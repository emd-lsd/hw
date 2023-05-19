public class Main {

    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.scale(50, 50, 50);
        cube.rotate(0,0,45);
        Screen screen = new Screen(cube);
    }
}
