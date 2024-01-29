import java.util.*;

public class bracelets
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            int total = in.nextInt();
            int temp = 1;
            int num_orders = 0;
            while (temp < total)
            {
                num_orders++;
                temp = 2 * temp + 3;
            }
            System.out.println(num_orders);

        }
    }
}
