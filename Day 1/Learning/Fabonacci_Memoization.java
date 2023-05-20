import java.util.*;

public class Fabonacci_Memoization {

    private static Map<Integer,Integer> cache = new HashMap<>();
    
    static int fib(int n)
    {
        if (n==0) {
            return 0;
        }

        if (n==1 || n==2) {
            return 1;
        }

        if(cache.containsKey(n))
        {
            return cache.get(n);
        }

        int result = fib(n-1)+fib(n-2);
        cache.put(n, result);

        return result;
    }
    public static void main(String[] args) {
        int position=8;

        System.out.println(fib(position));
    }
}
