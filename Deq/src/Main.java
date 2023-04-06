import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        Deq d = new Deq();
        for(int j =0; j<a.length();j++){
            d.pushBack(a.charAt(j));
        }
        int i=0;
        boolean f = true;
        while(i<=d.getSize()/2){
            if(d.popFront()!=d.popBack()) f = false;
            i++;
        }
        if(f) System.out.println(a +" является палиндромом");
        else System.out.println(a +" не является палиндромом");
    }
}
