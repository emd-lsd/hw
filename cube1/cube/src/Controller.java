public class Controller {
    private MyPanel panel;
    private Cube cube;

    private RotateX rx;
    private RotateY ry;
    private RotateZ rz;
    private Scale s;
    private TranslateX tx;
    private TranslateY ty;
    private TranslateZ tz;
    private Flag fl;
    public Controller(MyPanel panel, Cube cube){
        this.cube = cube;
        this.panel = panel;

        rx = new RotateX(panel, cube);
        ry = new RotateY(panel, cube);
        rz = new RotateZ(panel, cube);
        s = new Scale(panel, cube);
        tx = new TranslateX(panel, cube);
        ty = new TranslateY(panel, cube);
        tz = new TranslateZ(panel, cube);
        fl = new Flag(cube, panel);
    }
    public RotateX getRx(){ return rx;}
    public RotateY getRy(){ return ry;}
    public RotateZ getRz(){ return rz;}
    public Scale getS(){ return s;}
    public TranslateX getTx(){ return tx;}
    public TranslateY getTy(){ return ty;}
    public TranslateZ getTz(){ return tz;}
    public Flag getFl() { return fl;}






}
