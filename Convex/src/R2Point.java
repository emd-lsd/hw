import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Класс, описывающий точку (Point) на плоскости (R2).
class R2Point extends Object{
    private double x, y;
    protected static boolean f = false;

    public R2Point(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        FileWriter fw = new FileWriter("Точки.txt",f);
        fw.write(("x-> "+x+" y-> "+y));
        fw.close();
        f = true;

    }

    public R2Point() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("x -> ");
        x = in.nextDouble();
        System.out.print("y -> ");
        y = in.nextDouble();
        FileWriter fw = new FileWriter("Точки.txt",f);
        fw.write(("x-> "+x+" y-> "+y+"\n"));
        fw.close();
        f = true;
    }

    public static double dist(R2Point a, R2Point b){
        return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }

    public static double area(R2Point a, R2Point b, R2Point c){
        return 0.5*((a.x - c.x)*(b.y - c.y) - (a.y - c.y)*(b.x - c.x));
    }

    public static boolean equal(R2Point a, R2Point b){
        return a.x == b.x && a.y == b.y;

    }

    public boolean equals(Object a){
        R2Point ob = (R2Point) a;
        return x ==ob.x && y==ob.y;

    }

    public static boolean isTriangle(R2Point a, R2Point b, R2Point c){
        return area(a, b, c) != 0.0;
    }

    public boolean inside(R2Point a, R2Point b){
        return(a.x <= x && x <= b.x || a.x >= x && x >= b.x)&&(a.y <= y && y <= b.y|| a.y>= y && y >= b.y);
    }

    public boolean light(R2Point a, R2Point b){
        double s = area(a, b, this);
        return s < 0.0 || (s == 0.0 && ! inside(a,b));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}