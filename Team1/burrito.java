import java.util.*;

public class burrito
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++)
        {
            int chicken = in.nextInt();
            int steak = in.nextInt();
            int n = in.nextInt();

            for (int j = 0; j < n; j++)
            {
                int c_wanted = in.nextInt();
                int s_wanted = in.nextInt();
                if (j == n - 1)
                {
                    if (chicken < 0)
                        chicken = 0;
                    if (steak < 0)
                        steak = 0;
                    System.out.print(Math.min(c_wanted, chicken) + " ");
                    System.out.println(Math.min(s_wanted, steak));
                    continue;
                }
                chicken -= c_wanted;
                steak -= s_wanted;
            }
        }
    }
}
