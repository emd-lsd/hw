public class Main {

    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.scale(50, 50, 50);
        //cube.translate(45,45,45);
        cube.rotate(45,45,45);
        Screen screen = new Screen(cube);
    }
}
