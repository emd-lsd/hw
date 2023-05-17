import java.awt.*;

//Класс "Двуугольник", реализующий интерфейс фигуры.
class Segment implements Figure{
    private R2Point p, q;

    public Segment(R2Point p, R2Point q){
        this.p = p;
        this.q = q;
    }

    public double perimeter(){
        return 2.0 * R2Point.dist(p, q);
    }

    public double area(){
        return 0.0;
    }

    public int amount() {
        int count = 0;
        if((1<=Math.pow(p.getX(), 2)+Math.pow(p.getY(),2)) && (Math.pow(p.getX(), 2)+Math.pow(p.getY(),2)<=4)) count++;
        if((1<=Math.pow(q.getX(), 2)+Math.pow(q.getY(),2)) && (Math.pow(q.getX(), 2)+Math.pow(q.getY(),2)<=4)) count++;
        return count;
    }

    public Figure add(R2Point r){
        if(R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);

        if(q.inside(p, r))
            q = r;

        if(p.inside(r, q))
            p = r;

        return this;
    }
    public void draw(Graphics2D g){
        BasicStroke pen = new BasicStroke(1.5f);
        g.setStroke(pen);
        g.drawLine((int) p.getX(), (int) p.getY(), (int) q.getX(), (int) q.getY());}

}
