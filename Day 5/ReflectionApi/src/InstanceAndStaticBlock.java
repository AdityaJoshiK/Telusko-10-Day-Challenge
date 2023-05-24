class A
    {
        //instance Block
        {
            System.out.println("Instance Block");
        }

        public A()
        {
            System.out.println("Constructor");
        }

        static{
            System.out.println("Static Block");
        }
    }
    
public class InstanceAndStaticBlock {

    public static void main(String[] args) throws Exception {
        A a =new A();
    }
}
