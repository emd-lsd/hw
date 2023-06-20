import java.awt.*;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Observable;

public class Cube extends Observable {
    private Facet[] _facets;



    ArrayList<Facet> nearT;

    public Cube(){
        _facets = new Facet[6];
        nearT = new ArrayList<>();

        //дальняя грань, в плоскости XY
        _facets[0] = new Facet(new R3Vector(0, 0, 0),
                new R3Vector(0, 1, 0),
                new R3Vector(1, 1, 0),
                new R3Vector(1, 0, 0));
        _facets[0].setColor(Color.RED);

        //передняя грань
        _facets[1] = new Facet(new R3Vector(0, 0, 1),
                new R3Vector(1, 0, 1),
                new R3Vector(1, 1, 1),
                new R3Vector(0, 1, 1));
        _facets[1].setColor(Color.BLUE);

        //верхняяя грань
        _facets[2] = new Facet(new R3Vector(0, 1, 0),
                new R3Vector(0, 1, 1),
                new R3Vector(1, 1, 1),
                new R3Vector(1, 1, 0));
        _facets[2].setColor(Color.GREEN);

        //нижняя грань, в плоскоти XY
        _facets[3] = new Facet(new R3Vector(0, 0, 0),
                new R3Vector(1, 0, 0),
                new R3Vector(1, 0, 1),
                new R3Vector(0, 0, 1));
        _facets[3].setColor(Color.MAGENTA);

        //левая боковая грань, в плоскости YZ
        _facets[4] = new Facet(new R3Vector(0, 0, 0),
                new R3Vector(0, 0, 1),
                new R3Vector(0, 1, 1),
                new R3Vector(0, 1, 0));
        _facets[4].setColor(Color.ORANGE);

        //правая боковая грань
        _facets[5] = new Facet(new R3Vector(1, 0, 0),
                new R3Vector(1, 1, 0),
                new R3Vector(1, 1, 1),
                new R3Vector(1, 0, 1));
        _facets[5].setColor(Color.PINK);
        this.translate(-0.5, -0.5, -0.5);
    }

    public void scale(double kx, double ky, double kz){
        for(Facet v: _facets) //(int i = 0; i<_vertex.length; i++)
            v.scale(kx, ky, kz);
        this.setChanged();
        this.notifyObservers(); //this.notifyObservers("1");
    }

    public void translate(double dx, double dy, double dz){
        for(Facet v: _facets) //(int i = 0; i<_vertex.length; i++)
            v.translate(dx, dy, dz);
        this.setChanged();
        this.notifyObservers(); //this.notifyObservers("1");
    }

    public void rotate(double ux, double uy, double uz){
        for(Facet v: _facets) //(int i = 0; i<_vertex.length; i++)
            v.rotate(ux, uy, uz);
        this.setChanged();
        this.notifyObservers(); //this.notifyObservers("1");
    }
    public void increment_rotatex(){
        rotate(1, 0, 0);
        this.setChanged();
        this.notifyObservers(); //this.notifyObservers("1");
    }

    public void draw(Graphics2D g){
        near();
        /*
        for(int i = 0; i < _facets.length; i++)
            _facets[i].draw(g);

         */

        for(int i = 0; i < nearT.size(); i++){
            nearT.get(i).draw(g);
        }
        for(int i = 0; i<nearT.size(); i++){
            if (R3Vector.vect(R3Vector.toR3Vector(nearT.get(i)._vertex[0], nearT.get(i)._vertex[1]), R3Vector.toR3Vector(nearT.get(i)._vertex[1], nearT.get(i)._vertex[2])).getZ() > 0){
                nearT.get(i).draw(g);
            }
        }


    }
    public void near() {
        double min = _facets[0].nearest().mod();
        for (int i = 1; i < 6; i++) {
            if (min > _facets[i].nearest().mod()) {
                min = _facets[i].nearest().mod();
            }
        }
        for (int i = 0; i < _facets.length; i++) {
            if(_facets[i].nearest().mod()==min)
                nearT.add(_facets[i]);

        }
    }

    public void flag(){
        Facet.flag();
    }
}
