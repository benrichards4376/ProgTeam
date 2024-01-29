import java.util.*;

public class covid19
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int num_cases = in.nextInt();
        for (int i = 0; i < num_cases; i++)
        {
            int num_people = in.nextInt();
            int num_correct = 0;
            for (int j = 0; j < num_people; j++)
            {
                if (in.nextInt() - in.nextInt() == -19)
                    num_correct++;
            }
            System.out.println(num_correct);
        }
    }
}
