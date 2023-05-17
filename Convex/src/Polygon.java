import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends ArrayDeque implements Figure{
    private double s, p;
    private int am;

    public Polygon(R2Point a, R2Point b, R2Point c){
        //pushFront(b);
        addFirst(b);


        if (b.light(a, c)){
            //pushFront(a);
            //pushBack(c);
            addFirst(a);
            addLast(c);
        }
        else{
            //pushFront(c);
            //pushBack(a);
            addFirst(c);
            addLast(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c)+ R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
        am=0;
        if((1<=Math.pow(a.getX(), 2)+Math.pow(a.getY(),2)) && (Math.pow(a.getX(), 2)+Math.pow(a.getY(),2)<=4)) am++;
        if((1<=Math.pow(b.getX(), 2)+Math.pow(b.getY(),2)) && (Math.pow(b.getX(), 2)+Math.pow(b.getY(),2)<=4)) am++;
        if((1<=Math.pow(c.getX(), 2)+Math.pow(c.getY(),2)) && (Math.pow(c.getX(), 2)+Math.pow(c.getY(),2)<=4)) am++;
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    public int amount() {return am;}

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));

    }

    public Figure add(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = size(); i>0 && !t.light((R2Point) getLast(), (R2Point) getFirst()); i--)
            addLast(removeFirst());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow((R2Point) getLast(),(R2Point) getFirst(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = (R2Point) removeFirst(); t.light(x, (R2Point) getFirst()); x = (R2Point) removeFirst()) {
                grow(x, (R2Point) getFirst(), t);
                if((1<=Math.pow(x.getX(), 2)+Math.pow(x.getY(),2)) && (Math.pow(x.getX(), 2)+Math.pow(x.getY(),2)<=4)) am--;
            }
            addFirst(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = (R2Point) removeLast(); t.light((R2Point) getLast(), x); x = (R2Point)removeLast()) {
                grow((R2Point) getLast(), x, t);
                if((1<=Math.pow(x.getX(), 2)+Math.pow(x.getY(),2)) && (Math.pow(x.getX(), 2)+Math.pow(x.getY(),2)<=4)) am--;
            }
            addLast(x);

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist((R2Point)getLast(), t) + R2Point.dist(t, (R2Point)getFirst());
            addFirst(t);
            if((1<=Math.pow(t.getX(), 2)+Math.pow(t.getY(),2)) && (Math.pow(t.getX(), 2)+Math.pow(t.getY(),2)<=4)) am++;
        }

        return this;
    }
    public void draw(Graphics2D g){
        for(int i = 0; i<size(); i++){
            BasicStroke pen = new BasicStroke(1.5f);
            g.setStroke(pen);
            //g.drawLine((int) back().getX(), (int) back().getY(), (int) front().getX(), (int) front().getY());
            R2Point back = (R2Point) getLast();
            R2Point first = (R2Point) getFirst();
            int back_x = (int) back.getX();
            int back_y = (int) back.getY();
            int first_x = (int) first.getX();
            int first_y = (int) first.getY();
            g.drawLine(back_x, back_y, first_x, first_y);
            addLast(removeFirst());
        }
    }

}