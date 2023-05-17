import java.awt.*;

//Класс "Одноугольник", реализующий интерфейс фигуры.
class Point implements Figure{
    private R2Point p;

    public Point(R2Point p){
        this.p = p;

    }

    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public int amount(){
        int count = 0;
        if((1<=Math.pow(p.getX(), 2)+Math.pow(p.getY(),2)) && (Math.pow(p.getX(), 2)+Math.pow(p.getY(),2)<=4)) count++;
        return count;
    }

    public Figure add(R2Point q){
        if(!p.equals(q))
            return new Segment(p, q);
        else
            return this;
    }
    public void draw(Graphics2D g){
        g.fillOval((int) p.getX(), (int) p.getY(), 5, 5);
    }


}