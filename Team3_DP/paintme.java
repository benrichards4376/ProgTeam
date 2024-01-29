import java.util.*;
public class paintme
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int num_apartments = in.nextInt();
            if (num_apartments == 0)
                return;
            int width = in.nextInt();
            int length = in.nextInt();
            int height = in.nextInt();
            double paint_area = in.nextDouble();
            int m = in.nextInt();
            int wd_size = 0;
            for (int i = 0; i < m; i++)
            {
                wd_size += in.nextInt() * in.nextInt();
            }
            double total_area = (((2 * height) * (length + width) + (length * width) - wd_size) * num_apartments);
            double num_cans = Math.ceil(total_area / paint_area);
            System.out.println((int)num_cans);

        }
    }
}
