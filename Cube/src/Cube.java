import java.awt.*;

public class Cube {
    private Facet[] _facets;

    public Cube() {
        _facets = new Facet[6];

        //дальняя грань в XY
        _facets[0] = new Facet(new R3Vector(0,0,0),
                                new R3Vector(0,1,0),
                                new R3Vector(1,1,0),
                                new R3Vector(1,0,0));
        _facets[0].setColor(Color.RED);

        //передня грань
        _facets[1] = new Facet(new R3Vector(0,0,1),
                                new R3Vector(1,0,1),
                                new R3Vector(1,1,1),
                                new R3Vector(0,1,1));
        _facets[1].setColor(Color.BLUE);

        //верхняя грань
        _facets[2] = new Facet(new R3Vector(0,1,0),
                                new R3Vector(0,1,1),
                                new R3Vector(1,1,1),
                                new R3Vector(1,1,0));
        _facets[2].setColor(Color.GREEN);

        //нижняя грань
        _facets[3] = new Facet(new R3Vector(0,0,0),
                                new R3Vector(1,0,0),
                                new R3Vector(1,0,1),
                                new R3Vector(0,0,1));
        _facets[3].setColor(Color.MAGENTA);

        //левая боковая в плоскости YZ
        _facets[4] = new Facet(new R3Vector(0,1,0),
                                new R3Vector(0,0,0),
                                new R3Vector(0,0,1),
                                new R3Vector(0,1,1));
        _facets[4].setColor(Color.ORANGE);

        //правая боковая
        _facets[5] = new Facet(new R3Vector(1,0,0),
                                new R3Vector(1,1,0),
                                new R3Vector(1,1,1),
                                new R3Vector(1,0,1));
        _facets[5].setColor(Color.PINK);



        this.translate(-0.5, -0.5, -0.5);
    }
    public void scale(double kx, double ky, double kz){
        for (Facet f: _facets ) f.scale(kx, ky, kz);
    }

    public void translate(double dx, double dy, double dz){
        for(Facet f: _facets ) f.translate(dx, dy, dz);
    }

    public void rotate(double ux, double uy, double uz){
        for(Facet f: _facets ) f.rotate(ux, uy, uz);
    }

    public void draw(Graphics2D g){
        for(int i = 0; i < _facets.length; i++)
            _facets[i].draw(g);
    }
}
