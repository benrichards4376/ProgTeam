import java.util.*;

public class relatives
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int cases = 1;
        while (true)
        {
            int num_people = in.nextInt();
            int num_rel = in.nextInt();

            if (num_people == 0 && num_rel == 0)
                return;
            HashMap<String, Integer> people = new HashMap<>();
            int [][] g = new int[num_people][num_people];
            for (int i = 0; i < num_people; i++)
                Arrays.fill(g[i], (int)1e9);
            for (int i = 0; i < num_rel; i++)
            {
                String from = in.next();
                String to = in.next();

                if (people.get(from) == null)
                    people.put(from, people.size());

                if (people.get(to) == null)
                    people.put(to, people.size());

                Integer getFrom = people.get(from);
                Integer getTo = people.get(to);
                g[getFrom][getTo] = 1;
                g[getTo][getFrom] = 1;
                g[getFrom][getFrom] = 0;
                g[getTo][getTo] = 0;
            }
            // print(g);
            System.out.print("Network " + cases + ": ");
            int [][] floyd = shortestpath(g);
            int max = 0;
            boolean flag = false;
            for (int i = 0; i < floyd.length; i++)
            {
                for (int j = 0; j < floyd[0].length; j++)
                {
                    if (floyd[i][j] == 1e9)
                    {
                        flag = true;
                        break;
                    }
                    if (floyd[i][j] > max)
                        max = floyd[i][j];
                }
                if (flag)
                    break;
            }
            System.out.println((flag) ? "DISCONNECTED" : max);
            System.out.println();

            cases++;
        }
    }
    public static void print(int [][] g)
    {
        for (int i = 0; i < g.length; i++)
        {
            for (int j = 0; j < g[0].length; j++)
                System.out.print(g[i][j] + " ");
            System.out.println();
        }
    }
    public static int [][] shortestpath(int[][] adj)
    {
        int n = adj.length;
        int [][] m = copy(adj);

        for (int k=0; k<n;k++)
            for (int i=0; i<n; i++)
                for (int j=0; j<n;j++)
                    m[i][j] = Math.min(m[i][j], m[i][k] + m[k][j]);

        return m;
    }
    public static int [][] copy(int[][] a)
    {
        int [][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                res[i][j] = a[i][j];
        return res;
    }

}
