import java.util.Scanner;

public class christmas
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        long [] dp = new long[(int)1e6 + 1];
        dp[1] = 1;
        for (int i = 2; i <= 1e6; i++)
        {
            dp[i] = dp[i - 1] + sum(i);
        }
        while (true)
        {
            long n = in.nextLong();
            if (n == 0)
                return;

            System.out.println(dp[(int)n]);

        }
    }
    public static long sum(long n)
    {
        return (n * (n + 1) / 2);
    }
}
