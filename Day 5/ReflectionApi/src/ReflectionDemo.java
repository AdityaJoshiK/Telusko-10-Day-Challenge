public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        Class c = Class.forName("Product");

        System.out.println(c.getName());//get name of class

        System.out.println(c.getConstructors().length);//we can get all constructors

        System.out.println(c.getModifiers());

        c.getFields(); //returns array of all fields(variables)

        c.getMethods(); //returns array of all methods
    }
}
