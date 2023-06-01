import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    R3Vector[] _vertex;
    private Color _color;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4){
        _vertex = new R3Vector[]{v1, v2, v3, v4};
        setColor(Color.RED);
    }

    public void setColor(Color color){
        _color = color;
    }

    public void scale(double kx, double ky, double kz){
        for(R3Vector v: _vertex) //(int i = 0; i<_vertex.length; i++)
            v.scale(kx, ky, kz);
    }

    public void translate(double dx, double dy, double dz){
        for(R3Vector v: _vertex) //(int i = 0; i<_vertex.length; i++)
            v.translate(dx, dy, dz);
    }

    public void rotate(double ux, double uy, double uz){
        for(R3Vector v: _vertex) //(int i = 0; i<_vertex.length; i++)
            v.rotate(ux, uy, uz);
    }

    public void draw(Graphics2D g){
        Path2D p = new Path2D.Double();
        p.moveTo(_vertex[0].actual().getX(), _vertex[0].actual().getY());
        p.lineTo(_vertex[1].actual().getX(), _vertex[1].actual().getY());
        p.lineTo(_vertex[2].actual().getX(), _vertex[2].actual().getY());
        p.lineTo(_vertex[3].actual().getX(), _vertex[3].actual().getY());
        p.lineTo(_vertex[0].actual().getX(), _vertex[0].actual().getY());
        p.closePath();

        g.setColor(_color);
        g.fill(p);
        /*

        if (R3Vector.vect(R3Vector.toR3Vector(_vertex[0], _vertex[1]), R3Vector.toR3Vector(_vertex[1], _vertex[2])).getZ() > 0){
            g.fill(p);
        }
        if (R3Vector.vect(R3Vector.toR3Vector(_vertex[0], _vertex[1]), R3Vector.toR3Vector(_vertex[1], _vertex[2])).getZ() - _vertex[0].getZ() > 0){
            g.fill(p);
        }

         */


        //g.fill(p);

    }

    public R3Vector nearest(){
        double x = _vertex[0].getX();
        double y = _vertex[0].getY();
        double z = _vertex[0].getZ();
        double min = _vertex[0].mod();
        for(int i=1; i<4; i++){
            if(min>_vertex[i].mod()){
                x = _vertex[i].getX();
                y = _vertex[i].getY();
                z = _vertex[i].getZ();
            }
        }
        return new R3Vector(x, y, z);
    }

}
