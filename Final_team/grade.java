import java.util.*;

public class grade
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int s = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            for (int j = 0; j < s; j++)
            {
                int temp = in.nextInt();
                if (temp < a)
                    System.out.println(30);
                else if (temp < b)
                    System.out.println(35);
                else if (temp < c)
                    System.out.println(40);
                else if (temp < d)
                    System.out.println(45);
                else if (temp <= 1000)
                    System.out.println(50);
            }
            
        }
    }
}