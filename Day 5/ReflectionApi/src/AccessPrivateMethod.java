import java.lang.reflect.Method;

class Apple{
    private void repair()
    {
        System.out.println("In Repair Method");
    }
}

public class AccessPrivateMethod {
    public static void main(String[] args) throws Exception {
        //we can;t access directly we get error "The method repair() from the type Apple is not visible"
    /* 
        Apple a = new Apple();
        a.repair();
    */

    Class c = Class.forName("Apple");
    Apple apple = (Apple)c.newInstance();

    Method m = c.getDeclaredMethod("repair", null);
    m.setAccessible(true);
    m.invoke(apple);
    
    }
}
