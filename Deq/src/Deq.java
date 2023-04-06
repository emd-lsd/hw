public class Deq extends Queue {

    //Вернуть индекс следующего перед данным элементом.
    private int backward(int index) {
        return --index > -1 ? index : array.length-1;
    }
    //Добавить число в начало дека
    public void pushFront(char val) throws Exception{
        if(++size > array.length)
            throw new Exception();

        array[tail = forward(tail)] = val;
    }

    //Добавить число в конец дека
    public void pushBack(char val) throws Exception {
        if(++size > array.length)
            throw new Exception();

        array[head = backward(head)] = val;
        //return super.push(val)
    }
    //Удалить число из начала очереди.
    public char popFront() throws Exception {
        char val = front();
        head = forward(head);
        size -= 1;
        return val;
    }
    //Удалить число из конца очереди.
    public char popBack() throws Exception{
        char val = back();
        tail = backward(tail);
        size -= 1;

        return val;
    }
    //Получить конец очереди (не удаляя его).
    public char back() throws Exception {
        if(empty())
            throw new Exception();

        return array[tail];
    }
    public int getSize(){
        return super.getSize();
    }
}
