import java.util.*;

public class order
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 0; i < c; i++)
        {
            int n = in.nextInt();
            int q = in.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<Integer> sorted = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                int temp = in.nextInt();
                ArrayList<Integer> list = map.get(temp);
                if (list == null)
                {
                    sorted.add(temp);
                    list = new ArrayList<>();
                    list.add(j);
                    map.put(temp, list);
                } 
                else
                {
                    list.add(j);
                }
            }
            Collections.sort(sorted);
            for (int j = 0; j < q; j++)
            {
                int k = in.nextInt() - 1;
                int m = in.nextInt() - 1;
                if (k >= sorted.size())
                {
                    System.out.println(-1);
                    continue;
                }
                ArrayList<Integer> temp = map.get(sorted.get(k));
                if (temp.size() <= m)
                {
                    System.out.println(-1);
                    continue;
                }
                else
                    System.out.println(temp.get(m) + 1);
            }
        }
    }
}