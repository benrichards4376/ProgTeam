import java.util.*;
import java.lang.Math;

public class lotto
{
    public static int n;
    public static int m;
    public static int count;


    static int getSolutions(int x, int depth)
    {
        if (depth == n)
            return (m - x + 1);

            int base = getSolutions(x*2, depth+1);

            count += summation(base, depth)

        return base;
    }

    static int summation(int c, int depth)
    {
        int temp = 0;

        int start = c - (int) (Math.pow(2, n - depth));
    }

    public static void main(String [] args)
    {
        int num_cases = 1;
        Scanner in = new Scanner(System.in);

        while (true)
        {

            n = in.nextInt();
            m = in.nextInt();

            if (n == 0) return;

            int end = m;

            for (int i = 1; i < n; i++)
                end = end/2;

             count = 0;

            for (int i = 1; i <= end; i++)
            {
                count += getSolutions(2*i, 2);
            }

            System.out.println("Case " + num_cases + ": n = " + n + ", m = " + m + ", # lists = " + count);
            num_cases++;
        }
    }



}
