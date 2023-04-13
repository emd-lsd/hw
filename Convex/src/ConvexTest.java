//Тест для выпуклой оболочки.
class ConvexTest{
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        Frame w = new Frame(convex);

        while(true){
            convex.add(new R2Point());
            w.repaint();
            System.out.println("S = " + convex.area()+ ", P = " + convex.perimeter());
        }
    }
}
