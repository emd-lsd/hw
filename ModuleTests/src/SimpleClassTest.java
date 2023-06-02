import org.junit.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SimpleClassTest{
    static int i;
    /*@Test
    public void testMin(){ //Тестирование метода класса.
        int min = SimpleClass.min(3, 5, 4);
        if(min != 3){
            //Assert.fail();
            fail("Тест не пройден.");
        }
    }*/
    @Test(timeout = 10)
    public void testMin() throws InterruptedException { //Тестирование метода класса.
        assertEquals(3, SimpleClass.min(3, 5, 4));
        assertEquals("Тест не пройден.", 3, SimpleClass.min(3, 5, 4));
        assertEquals(5, SimpleClass.min(5, 5, 5));
        assertEquals(2, SimpleClass.min(2, 2, 2));

        TimeUnit.SECONDS.sleep(20);
    }
    @Ignore
    @Test
    public void testConstructor(){ //Тестирование конструктора.
        SimpleClass obj = new SimpleClass(100);
        assertEquals(100, obj.getAttr());
    }

    @Test
    public void testDiv(){ //Тестирование метода экземпляра класса.
        SimpleClass obj = new SimpleClass(100);
        assertEquals(10, obj.div(10));
        assertEquals(20, obj.div(5));
        assertEquals(0, obj.div(200));
        assertEquals(1, obj.div(100));
    }
    /*
    @Test
    public void testDivExcept(){ //Тестирование метода экземпляра класса.
        SimpleClass obj = new SimpleClass(100);

        try{
            obj.div(0);
            fail("Тест не пройден.");
        }
        catch(Exception e){
            //Тест пройден.
        }
    }
*/
    @Test(expected = Exception.class) //Тип (один) ожидаемого исключения - Exception.
    public void testDivExcept(){ //Тестирование метода экземпляра класса.
        //f();
        new SimpleClass(100).div(0);
    }
@BeforeClass
//@After
    public static void f(){ //Не тест.
        i = -1;
        System.out.println("i = " + i);
    }
}