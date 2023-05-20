public class Fibonacci_Iteration {

    static int fib(int n)
    {
        int a=0;
        int b=1;
        int c=0;

        for (int i = 2; i <= n; i++) {
            c=a+b;
            a=b;
            b=c;
        }

        return c;
    }
    public static void main(String[] args) {
        int position=8;

        System.out.println(fib(position));
    }
}
