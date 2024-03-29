class Queue {
    private final static int DEFSIZE = 16;
    static char[] array;
    static int size, head, tail;

    public Queue(int capacity) {
        array = new char[capacity];

        clear();
    }


    public Queue(){

        this(DEFSIZE);

    }

    //Пуста ли очередь?
    public boolean empty() {
        return size == 0;
    }

    //Сделать очередь пустой.
    public void clear() {
        size = head = 0;
        tail = array.length - 1;
    }

    //Вернуть индекс следующего за данным элемента.
    int forward(int index) {

        return ++index < array.length ? index : 0;
    }

    //Добавить число в очередь (в конец).
    public void push(char val) throws Exception {
        if(++size > array.length)
            throw new Exception();

        array[tail = forward(tail)] = val;
    }

    //Удалить число из начала очереди.
    public char pop() throws Exception {
        char val = front();
        head = forward(head);
        size -= 1;

        return val;
    }

    //Получить начало очереди (не удаляя его).
    public char front() throws Exception {
        if(empty())
            throw new Exception();

        return array[head];
    }
    public int getSize(){
        return size;
    }
}