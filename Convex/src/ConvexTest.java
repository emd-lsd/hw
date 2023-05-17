import java.io.FileWriter;

//Тест для выпуклой оболочки.
class ConvexTest{
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        boolean f = false;
        Frame w = new Frame(convex);

        while(true){
            R2Point point = new R2Point();
            convex.add(point);

            w.repaint();
            System.out.println("S = " + convex.area()+ ", P = " + convex.perimeter() + ", Amount of dots in the ring = " + convex.amount());





        }
    }
}
