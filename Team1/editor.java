import java.util.*;
import java.awt.geom.Point2D;
import java.awt.Point;

public class editor
{
    static HashMap<Point, Integer> visited;
    static boolean debug = false;
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            visited = new HashMap<>();
            int num_lines = in.nextInt();
            int [] lines = new int[num_lines];
            for (int j = 0; j < num_lines; j++)
            {
                lines[j] = in.nextInt() + 1;
            }
            Point start = new Point(in.nextInt() - 1, in.nextInt());
            Point end = new Point(in.nextInt() - 1, in.nextInt());

            int presses = solve(num_lines, lines, start, end);
            System.out.println(presses);
        }
    }

    public static int solve(int num_lines, int [] len, Point start, Point end)
    {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);

        visited.put(start, 0);
        while (!q.isEmpty())
        {
            // System.out.println("h");
            Point temp = q.remove();
            if (debug)
                System.out.println(temp.toString());

            if (temp.equals(end))
                return visited.get(temp);

            ArrayList<Point> next = new ArrayList<>();

            Point check = left(temp, len);
            if (check != null)
            {
                next.add(check);
                // System.out.println(temp.toString() + " left to " + check);
            }

            check = up(temp, len);
            if (check != null)
            {
                next.add(check);
                // System.out.println(temp.toString() + " up to " + check);
            }

            check = right(temp, len);
            if (check != null)
            {
                next.add(check);
                // System.out.println(temp.toString() + " right to " + check);
            }

            check = down(temp, len);
            if (check != null)
            {
                next.add(check);
                // System.out.println(temp.toString() + " down to " + check);
            }

            for (int i = 0; i < next.size(); i++)
            {
                check = next.get(i);
                if (!visited.containsKey(check))
                {
                    q.add(check);
                    visited.put(check, visited.get(temp) + 1);
                }
            }
        }
        return -1;
    }

    public static Point left(Point temp, int [] len)
    {
        int x = (int)temp.getX();
        int y = (int)temp.getY();
        if (x == 0 && y == 0)
        {
            return null;
        }
        else if (y == 0)
        {
            return new Point(x - 1, len[x - 1] - 1);
        }
        else
        {
            return new Point(x, y - 1);
        }
    }

    public static Point up(Point temp, int [] len)
    {
        int x = (int)temp.getX();
        int y = (int)temp.getY();

        if (x == 0)
        {
            return null;
        }
        if (y > len[x - 1] - 1)
        {
            return new Point(x - 1, len[x - 1] - 1);
        }
        else
        {
            return new Point(x - 1, y);
        }
    }

    public static Point right(Point temp, int [] len)
    {
        int x = (int)temp.getX();
        int y = (int)temp.getY();

        if (x == len.length - 1 && y == len[x] - 1)
        {
            return null;
        }
        else if (y == len[x] - 1)
        {
            return new Point(x + 1, 0);
        }
        else
        {
            return new Point(x, y + 1);
        }
    }

    public static Point down(Point temp, int [] len)
    {
        int x = (int)temp.getX();
        int y = (int)temp.getY();

        if (x == len.length - 1)
        {
            return null;
        }
        if (y > len[x + 1] - 1)
        {
            return new Point(x + 1, len[x + 1] - 1);
        }
        else
        {
            return new Point(x + 1, y);
        }
    }
}
class node
{
    edge [] connections = new edge[4];

}
class edge implements Comparable<edge>
{

    public Point v1;
    public Point v2;
    public double w;

    public edge(Point a, Point b, double weight)
    {
        v1 = a;
        v2 = b;
        w = weight;
    }

    public int compareTo(edge other)
    {
        if (this.w > other.w)
            return 1;
        else if (this.w == other.w)
            return 0;
        else
            return -1;
    }
}
