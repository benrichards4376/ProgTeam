import java.util.*;

public class sd
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 0; i < c; i++)
        {
            int n = in.nextInt();
            int k = in.nextInt();

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < n; j++)
            {
                int s = in.nextInt();
                Integer temp = map.get(s);
                if (temp == null)
                    map.put(s, 1);
                else
                    map.put(s, temp);
            }
            for (int j = 0; j < k; k++)
            {
                int lowest = map.firstKey();
                

                map.put(lowest, map.get(lowest) - 1);
                if (map.get(lowest) == 0)
                    map.remove(lowest);

                int highest = map.lastKey();
                map.put(highest, map.get(highest) - 1);
                if (map.get(highest) == 0)
                    map.remove(highest);
            }
            int sum = sum(map);
            System.out.println();
        }
    }

    public static int sum(TreeMap<Integer, Integer> map)
    {
        int sum = 0;
        for (Integer i : map.keySet())
        {
            sum += map.get(i) * i;
        }
        return sum;
    }
}