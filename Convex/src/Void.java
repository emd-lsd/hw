import java.awt.*;

//Класс "Нульугольник", реализующий интерфейс фигуры.
class Void implements Figure{
    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public int amount(){return 0;}

    public Figure add(R2Point p){
        return new Point(p);
    }
    public void draw(Graphics2D g){;}
}
