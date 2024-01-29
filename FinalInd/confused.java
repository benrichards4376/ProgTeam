import java.util.*;

public class confused
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int num_villagers = in.nextInt();
            int queries = in.nextInt();

            PriorityQueue<villagers> v = new PriorityQueue<>();
            villagers [] list = new villagers[num_villagers + 1];
            for (int j = 1; j <= num_villagers; j++)
            {
                villagers f = new villagers(j, in.nextInt());
                v.add(f);
                list[j] = f;
            }

            for (int j = 0; j < queries; j++)
            {
                int type = in.nextInt();

                if (type == 2)
                {
                    int t = v.poll().id;
                    System.out.println(t);
                }
                else
                {
                    int person = in.nextInt();
                    int h = in.nextInt();
                    v.remove(list[person]);
                    list[person].health -= h;
                    v.add(list[person]);
                    if (list[person].health <= 0)
                        v.remove(list[person]);
                }
            }
        }
    }
}

class villagers implements Comparable<villagers>
{
    Integer id;
    Integer health;

    villagers(int n, int num)
    {
        id = n;
        health = num;
    }

    public int compareTo(villagers b)
    {
        return this.health - b.health;
    }
    public boolean equals(villagers b)
    {
        return this.id == b.id;
    }
}
