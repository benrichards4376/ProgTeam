import java.util.*;

public class girlscout
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();

        for (int i = 0; i < c; i++)
        {
            long num_girls = in.nextLong();
            long percent = in.nextLong();

            ArrayList<Node> girls = new ArrayList<>();
            for (int j = 0; j < num_girls; j++)
            {
                int g = in.nextInt();
                if (g == 0)
                {
                    girls.add(new Node(in.nextInt()));
                }
                else
                {
                    girls.add(new Node(-1));
                    for (int k = 0; k < g; k++)
                    {
                        int temp = in.nextInt() - 1;
                        girls.get(j).kids.add(temp);
                    }
                }
            }
            long total = solve(girls, 0, percent);
            System.out.println(total);
        }
    }
    public static long solve(ArrayList<Node> girls, int index, long percent)
    {
        if (girls.get(index).kids.size() == 0)
            return girls.get(index).data;

        long tally = 0;
        for (int i = 0; i < girls.get(index).kids.size(); i++)
        {
            long temp = solve(girls, girls.get(index).kids.get(i), percent);
            temp = (temp * percent) / 100;
            if (temp == 0)
                temp = 1;
            tally += temp;
        }
        return tally;
    }
}


class Node
{
    ArrayList<Integer> kids;
    int data;

    Node(int data)
    {
        this.data = data;
        this.kids = new ArrayList<>();
    }

}
