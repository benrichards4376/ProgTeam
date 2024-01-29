import java.util.*;
import java.awt.Point;
public class radios
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++)
        {
            int t = in.nextInt();
            ArrayList<Point> towers = new ArrayList<>();
            for (int j = 0; j < t; j++)
            {
                Point temp = new Point(in.nextInt(), in.nextInt());
                towers.add(temp);
            }

            int low = 0, high = (int)1e9;
            int mid = 0;
            while (low < high)
            {
                mid = low + (high - low) / 2;
                if (check(towers, mid))
                {
                    high = mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
            System.out.println("Island #" + i + ": " + high);
        }
    }

    public static boolean check(ArrayList<Point> towers, int r)
    {
        boolean [][] g = new boolean[towers.size()][towers.size()];

        for (int i = 0; i < towers.size(); i++)
        {
            for (int j = 0; j < towers.size(); j++)
            {
                if (touching(towers.get(i), towers.get(j), r))
                {
                    g[i][j] = true;
                }
            }
        }
        return isConnected(g, towers);
    }
    
    private static boolean touching(Point a, Point b, int r)
    {
        return dist(a, b) <= r;
    }
    
    public static double dist(Point a, Point b)
    {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    private static boolean isConnected(boolean [][] g, ArrayList<Point> towers)
    {
        boolean [] visited = new boolean[g.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        visited[0] = true;
        int cnt = 1;
        while (!stack.isEmpty())
        {
            int temp = stack.pop();
            for (int i = 0; i < g.length; i++)
            {
                if (!visited[i] && g[temp][i])
                {
                    visited[i] = true;
                    stack.push(i);
                    cnt++;
                }
            }

        }
        return cnt == g.length;
    }


}