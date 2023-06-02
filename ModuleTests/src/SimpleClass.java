public class SimpleClass{
    private int _attr;

    public SimpleClass(int attr){
        _attr = attr;
    }

    public int getAttr(){
        return _attr;
    }

    public static int min(int a, int b, int c){
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;

        return min;
    }

    public int div(int a){
        return _attr/a;
    }
}