import java.util.*;

public class robot
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int n = in.nextInt();
            if (n == 0) return;
            Target [] arr = new Target[n + 2];
            arr[0] = new Target(0, 0, 0);
            arr[n + 1] = new Target(100, 100, 0);
            for (int i = 1; i <= n; i++)
            {
                arr[i] = new Target(in.nextDouble(), in.nextDouble(), in.nextDouble());
            }

            double [] cumfreq = new double[n + 2];
		    for (int i = 1; i < n + 2; i++)
                cumfreq[i] = cumfreq[i - 1] + arr[i].penalty;

            double [] dp = new double[n + 2];

            for (int i = 1; i < dp.length; i++)
            {
                Double min = dp[0] + cumfreq[i - 1] + dist(arr[0], arr[i]);
                for (int j = 1; j < i; j++)
                {
                    double sum = dp[j] + cumfreq[i - 1] - cumfreq[j] + dist(arr[j], arr[i]);
                    if (sum < min)
                        min = sum;
                }
                dp[i] = min + 1;
            }
            System.out.printf("%.3f\n", dp[n + 1]);
        }
    }
    public static double cost(double [] sum, Target a, Target b, int i)
    {
        return sum[i - 1] + dist(a, b);
    }
    public static double dist(Target a, Target b)
    {
        return Math.sqrt(Math.pow(b.y - a.y, 2) + Math.pow(b.x - a.x, 2));
    }
}


class Target
{
    double x;
    double y;
    double penalty;

    Target(double x1, double y1, double p)
    {
        x = x1;
        y = y1;
        penalty = p;
    }
}
