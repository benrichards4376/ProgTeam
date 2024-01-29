import java.util.*;

public class duel
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int num_essays = in.nextInt();
            int num_rel = in.nextInt();

            if (num_essays == 0 && num_rel == 0)
                return;
            boolean [][] graph = new boolean[num_essays][num_essays];
            // ArrayList<Integer>[] graph = new ArrayList[num_essays];
            for (int i = 0; i < num_rel; i++)
            {
                graph[in.nextInt() - 1][in.nextInt() - 1] = true;
            }
            int temp = topo_sort(graph);
            if (temp > 1)
                System.out.println(2);
            else
                System.out.println(temp);
        }
    }
    public static int topo_sort(boolean [][] matrix)
    {
        int[] incoming = new int[matrix.length];
        int cnt = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                incoming[j] += (matrix[i][j] ? 1 : 0);

        ArrayList<Integer> q = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < incoming.length; i++)
            if (incoming[i] == 0)
                q.add(i);

        while (!q.isEmpty())
        {
            res = Math.max(res, q.size());
            int node = q.remove(0);

            cnt++;

            for (int i = 0; i < matrix.length; i++)
                if (matrix[node][i] && --incoming[i] == 0)
                    q.add(i);
        }

        if (cnt != matrix.length)
            return 0;

        return res;
    }
}
