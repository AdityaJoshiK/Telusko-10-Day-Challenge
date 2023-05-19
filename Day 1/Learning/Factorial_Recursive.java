public class Factorial_Recursive {

    static int factorial(int n)
    {
        if (n==0) {
            return 1;
        }

        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        int n=5;

        System.out.println("Factorial Of "+n+" is "+factorial(n));
    }
}
