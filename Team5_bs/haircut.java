import java.util.*;

public class haircut
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 1; i <= c; i++)
        {
            int b = in.nextInt();
            int n = in.nextInt();
            ArrayList<barber> list = new ArrayList<>();
            for (int j = 0; j < b; j++)
            {
                list.add(new barber(j + 1, in.nextInt()));
            }

            for (int j = 0; j < n; j++)
            {
                Collections.sort(list);
                list.get(0).current += list.get(0).time;

            }
            System.out.println("Case #" + i + ": " + list.get(0).id);
            
        }
        
    }
}

class barber implements Comparable<barber>
{
    int id;
    int time;
    long current = 0;

    barber(int i, int t)
    {
        id = i;
        time = t;
    }

    public int compareTo(barber b)
    {
        if (this.current < b.current)
        {
            return -1;
        }
        else if (this.current > b.current)
        {
            return 1;
        }
        else
        {
            return this.id - b.id;
        }
    }
}