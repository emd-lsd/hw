//Рекурсивный компилятор формул.
public class RecursCompf{
    //private static final int DEFSIZE = 256;
    private char[] str;
    private int index; //Число обработанных символов.
//    public RecursCompf(){
//        str = new char[DEFSIZE];
//    }
    private void compileF(){
        compileT();
        if(index >= str.length)
            return;
        /*while(index< str.length && str[index] == '+'){
            index++;
            compileT();
            System.out.print("+");
            //return;
        }
        while(index < str.length && str[index] == '-'){
            index++;
            compileT();
            System.out.print("-");
        }*/
        while(index < str.length && (str[index] == '+' || str[index]=='-')){
            if (str[index] == '+') {
                index++;
                compileT();
                System.out.print("+ ");
            }
            else if(str[index] == '-'){
                index++;
                compileT();
                System.out.print("- ");
            }
        }
    }
    private void compileT(){
        compileM();
        if(index >= str.length)
            return;
        /*while (index < str.length && str[index] == '*'){
            index++;
            compileT();
            System.out.print("*");
            //return;
        }
        while (index < str.length && str[index] == '/'){
            index++;
            compileT();
            System.out.print("/");
        }*/
        while(index < str.length && (str[index] == '*' || str[index]=='/')){
            if (str[index] == '*') {
                index++;
                compileT();
                System.out.print("* ");
            }
            else if(str[index] == '/'){
                index++;
                compileT();
                System.out.print("/ ");
            }
        }
    }
    private void compileM(){
        if(str[index] == '(' || str[index] == '['){
            index++;
            compileF();
            index++;
        }
        else
            compileV();
    }
    private void compileV(){
        if(str[index] == '-' || str[index] == '+') System.out.print(str[index++]);
        //System.out.print("" + str[index++]);
        while(index < str.length && String.valueOf(str[index]).matches("[0-9a-zA-Z]")) System.out.print(str[index++] + "");
        System.out.print(" ");
    }

    private void num(){

    }

    public void compile(char[] str){
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}