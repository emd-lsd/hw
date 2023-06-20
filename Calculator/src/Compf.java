//Стековый компилятор формул.
public class Compf extends Stack{
    //Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3;
    protected  boolean flag = false;

    /*
    public Compf(){
        //
    }
    */

    private int symType(char c){
        switch(c){
            case '(':
                return SYM_LEFT;
            case ')':
                return SYM_RIGHT;
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '$':
                return SYM_OPER;
            default:
                return symOther(c);
        }
    }

    private void processSymbol(char c){
        switch(symType(c)){
            case SYM_LEFT:
                flag = false;
                push(c);
                break;
            case SYM_RIGHT:
                flag = false;
                processSuspendedSymbols(c);
                pop();
                break;
            case SYM_OPER:
                flag = false;
                processSuspendedSymbols(c);
                push(c);
                break;
            case SYM_OTHER:
                nextOther(c);
                flag = true;
                break;
        }
    }

    private void processSuspendedSymbols(char c){
        while(precedes(top(), c))
            nextOper(pop());
    }

    private int priority(char c){
        int r = 0;
        if (c == '+' || c == '-') r=1;
        else if (c == '*' || c == '/') r= 2;
        else if (c=='^'||c=='$') r= 3;

        return r;
        //return c == '+' || c == '-' ? 1 : 2;
    }

    private boolean precedes(char a, char b){
        if(symType(a) == SYM_LEFT) return false;
        if(symType(b) == SYM_RIGHT) return true;

        return priority(a) >= priority(b);
    }

    protected int symOther(char c){
        if (c < 'a' || c > 'z'){
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }

        return SYM_OTHER;
    }

    protected void nextOper(char c){
        System.out.print("" + c + " ");
    }

    protected void nextOther(char c){
        nextOper(c);
    }

    public void compile(char[] str){
        processSymbol('(');

        for(int i = 0; i < str.length; i++) {
            if (str[i] == '*' && str[i+1] == '*') {
                i++;
                str[i] = '^';
            }
            if(top() == '(' && str[i]=='-' && !flag){ // не флаг делает проверку что индекс на операции а не на идентификаторе и помогает исключить выборку всех минусов как унарные
                str[i]='$';
            }
            processSymbol(str[i]);
            /*while(Character.isDigit(str[i])){
                String s = String.valueOf(str[i]);
                if(Character.isDigit(str[i+1])) {
                    s+=str[i+1];
                    i++;
                }
                else {
                    Calc.s.push();
                }
            }*/
        }

        processSymbol(')');

        System.out.print("\n");
    }
}
