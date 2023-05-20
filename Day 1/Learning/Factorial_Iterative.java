public class Factorial_Iterative {

    static int factorial(int n)
    {
        int ans=1;

        for (int i = 1;i<=n;i++) {
            ans = ans * i;
        }

        return ans;
    }
    public static void main(String[] args) {
        int n=5;

        System.out.println("Factorial Of "+n+" is "+factorial(n));
    }
}