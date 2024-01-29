import java.util.*;

public class paper
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            int num_exams = in.nextInt();
            double paper = 0;
            for (int j = 0; j < num_exams; j++)
            {
                double s = in.nextDouble();
                double p = in.nextDouble();

                paper += Math.ceil(p / 4.0) * s;
            }
            System.out.println((int)paper);
        }
    }
}
