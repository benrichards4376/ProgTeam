import java.util.*;
public class fruit
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int num_stands = in.nextInt();
        for (int i = 0; i < num_stands; i++)
        {
            int days = in.nextInt();
            ArrayList<Integer> sales = new ArrayList<>();

            for (int j = 0; j < days; j++)
                sales.add(in.nextInt());

            int min_num = sales.get(0);
            int leftover = 0;
            int max_leftover = 0;
            int num_fruit = min_num;
            for (int j = 0; j < sales.size(); j++)
            {

                if (num_fruit - sales.get(j) < 0)
                {
                    min_num++;
                    j = -1;
                    num_fruit = min_num;
                    continue;
                }
                else if (num_fruit - sales.get(j) >= 0)
                {
                    num_fruit -= sales.get(j);
                    if (num_fruit > 0 && num_fruit > max_leftover)
                        max_leftover = num_fruit;
                }

                num_fruit += min_num;
            }

            System.out.println(min_num + " " + max_leftover);
        }
    }
}
