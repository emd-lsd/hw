import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
    	L1List list = new L1List(5);
	list.insert(1);
	list.insert(2);
	list.insert(3);
	list.insert(4);
	list.insert(5);
	int i = 0;
	int var = 15;
	while(i<var) {
		try {
			System.out.println(list.after());
			list.forward();
			i++;

		} catch (Exception e) {
			list.toFront();
		}
	}

    }
}
