import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

//Класс "Выпуклая оболочка".
class Convex{
    private Figure fig;



    public Convex(){
        fig = new Void();
    }

    public void add(R2Point p){
        fig = fig.add(p);
    }

    public double area(){
        return fig.area();
    }

    public double perimeter(){
        return fig.perimeter();
    }

    public void draw(Graphics2D g){fig.draw(g);}




}
