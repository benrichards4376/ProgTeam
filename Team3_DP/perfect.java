import java.util.*;
public class perfect
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int base = in.nextInt();
            int temp = base;
            int z = in.nextInt();
            if (z == temp)
            {
                System.out.println("NO");
                continue;
            }


            while (temp < z)
            {
                temp *= base;
            }
            if (temp == z)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
