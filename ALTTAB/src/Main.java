import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("txt.txt"));
        L1List list = new L1List();
        int n = 0;
        while(in.hasNextLine()){
            String s = in.nextLine();
            String [] data; String [] pr; int k;
            if(!s.equals("")){
                data = s.split(" ");
                if (Objects.equals(data[0],"Run")){
                    int j=1; String ss = "";
                    while (j < data.length){
                        ss += " " + data[j]; // ss - сборка названия приложения в одну строку
                        j++;
                    }
                    list.insert(ss);
                    n++; // n- количество приложений
                    System.out.println(list.after());
                }
                else{
                    String d = data[0];
                    pr = d.split("\\+");
                    if (Objects.equals(pr[1],"Tab")) {
                        k = pr.length - 1; // к -  количество табов
                        int var = k % n + 1; // на каком месте находится действующее приложение
                        try {
                            for (int b = 1; b < var; b++) { // двигаем указатель до нужного приложения
                                list.forward();
                            }
                        }
                        catch (Exception e){
                            list.toFront();
                        }
                        String act = list.erase();
                        System.out.println(act); // выводим табнутое приложение
                        list.toFront();
                        list.insert(act); // вырезаем последнее выведенное приложение и вставляем последним в лист

                    }
                    else { // Обработка команды Delete
                        list.toFront();
                        list.erase();
                        System.out.println(list.after());
                    }
                }
            }
        }
    }
}
