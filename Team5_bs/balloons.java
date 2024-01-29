import java.util.*;

public class balloons
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();

        for (int i = 0; i < c; i++)
        {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            boolean easy = false;
            boolean hard = false;

            for (int j = 0; j < n; j++)
            {
                int tmp = in.nextInt();
                if (j == 0 && tmp == x) easy = true;
                if (j == n - 1 && tmp == y) hard = true;
            }

            if (easy && hard)
                System.out.println("BOTH");
            else if (easy)
                System.out.println("EASY");
            else if (hard)
                System.out.println("HARD");
            else
                System.out.println("OKAY");
        }
    }
}