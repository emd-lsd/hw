public class R3Vector {
    private double _x, _y, _z;
    int c = -100;



    public R3Vector(double x, double y, double z){
        _x = x;
        _y = y;
        _z = z;

    }

    public double getX(){
        return _x;
    }

    public double getY(){
        return _y;
    }

    public double getZ(){
        return _z;
    }

    public void scale(double kx, double ky, double kz){
        _x *= kx;
        _y *= ky;
        _z *= kz;
        //this.actual();
    }

    public void translate(double dx, double dy, double dz){
        _x += dx;
        _y += dy;
        _z += dz;
        //this.actual();
    }

    private void rotateZ(double u){ //угол в градусах
        // u *= Math.PI/180;
        u = Math.toRadians(u);
        double x = _x;
        double y = _y;
        _x = x*Math.cos(u) - y*Math.sin(u);
        _y = x*Math.sin(u) + y*Math.cos(u);
    }
    private void rotateX(double u){ //угол в градусах
        // u *= Math.PI/180;
        u = Math.toRadians(u);
        double y = _y;
        double z = _z;
        _y = y*Math.cos(u) + z*Math.sin(u);
        _z = z*Math.cos(u) - y*Math.sin(u);
    }
    private void rotateY(double u){ //угол в градусах
        // u *= Math.PI/180;
        u = Math.toRadians(u);
        double x = _x;
        double z = _z;
        _x = x*Math.cos(u) + z*Math.sin(u);
        _z = z*Math.cos(u) - x*Math.sin(u);
    }

    public void rotate(double ux, double uy, double uz){
        this.rotateX(ux);
        this.rotateY(uy);
        this.rotateZ(uz);
        //this.actual();
    }

    public R3Vector actual(){
        double t = c/(c+_z);
        return new R3Vector(t*_x, t*_y, _z);
    }



    public static R3Vector toR3Vector(R3Vector begin, R3Vector end){
        return new R3Vector(end._x - begin._x,
                end._y - begin._y,
                end._z - begin._z);
    }

    public static R3Vector vect(R3Vector a, R3Vector b){
        return new R3Vector(a._y*b._z - a._z*b._y,
                a._z*b._x - a._x*b._z,
                a._x*b._y - a._y*b._x);
    }
    // расстояние от точки в пространстве до точки С
    public double mod(){
        R3Vector a = this.actual();
        return Math.sqrt(a._x*a._x + a._y*a._y + Math.pow(a._z-Math.abs(c), 2));
    }

    public static boolean equal(R3Vector a, R3Vector b){
        return(a._x==b._x && a._y==b._y && a._z== b._z);
    }

	/*
	public static R3Vector dot(R3Vector a, R3Vector b){
		return new R3Vector(a._x*b._x,a._y*b._y, a._z*b._z);
	}
	*/

}
