import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int i =0, k=0;

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        Deq d = new Deq();
        for(int j =0; j<a.length();j++){
            d.pushBack(a.charAt(j));
        }

        int t =0;
        i=0;
        while(i<=d.getSize()/2){
            if(d.popFront()!=d.popBack()) t=1;
            i++;
        }
        if(t==0) System.out.println("Палиндром");
        else System.out.println("Не палиндром");

//        i =0;
//        k = d.getSize();
//        while(i<k){
//            char e = d.popFront();
//            System.out.println(e);
//            d.pushBack(e);
//            i++;
//        }

    }
}
