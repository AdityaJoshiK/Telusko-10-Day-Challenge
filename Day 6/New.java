@FunctionalInterface //we write if someone find that it use lamda exp. and then it also add new method then compiler throw error
interface Demo
{
    void disp();
}
//we can lamba exp. if write there is functional intefrace, which has single abstract method is functional interface

class Animal{
    public void eat()
    {
        System.out.println("Animal eats");
    }
}

class Tiger extends Animal{
    @Override //use to avoid mistakes
    public void eat(){
        System.out.println("Tiger Hunts and eats");
    }
}

public class New {
    public static void main(String[] args) {
        Demo d=()->{
            System.out.println("Lambda");
        };
    }
}
