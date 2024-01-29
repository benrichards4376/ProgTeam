import java.util.*;

public class sums
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int num = in.nextInt();
            int sum = 0;
            for (int k = 1; k <= num; k++)
                sum += k * getSum(k + 1);

            System.out.println((i + 1) + " " + num + " " + sum);
        }
    }
    public static int getSum(int k)
    {
        return (k * (k + 1)) / 2;
    }
}
