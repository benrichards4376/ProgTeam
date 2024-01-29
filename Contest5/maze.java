import java.util.*;
import java.awt.geom.Point2D;
import java.awt.Point;

public class maze
{
    public static int[] DX = {-1,0,0,1};
	public static int[] DY = {0,-1,1,0};
    public static char [][] maze;
    public static int [][] dist;
    public static Point start;
    public static HashSet<Point> visited = new HashSet<>();
    // public static int cols;

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            int rows = in.nextInt();
            int cols = in.nextInt();

            dist = new int[rows][cols];
            for (int j = 0; j < rows; j++)
                Arrays.fill(dist[j], -1);

            maze = new char[rows][cols];
            start = new Point();

            for (int j = 0; j < rows; j++)
            {
                String temp = in.next();
                for (int k = 0; k < temp.length(); k++)
                {
                    maze[j][k] = temp.charAt(k);
                    if (temp.charAt(k) == 'S')
                    {
                        start.setLocation(j, k);
                        dist[j][k] = 0;
                    }
                }
            }


            int moves = solve(start);
            System.out.println(moves);
            visited = new HashSet<>();
        }
    }

    public static boolean checkWin(Point current)
    {
        if (maze[(int)current.getX()][(int)current.getY()] == '~')
            return true;

        return false;
    }
    public static boolean validMove(Point current)
    {
        if (maze[(int)current.getX()][(int)current.getY()] == 'X' || visited.contains(current))
            return false;
        return true;
    }
    public static int solve(Point start)
    {

        Queue<Point> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty())
        {
            Point temp = q.remove();

            if (checkWin(temp))
            {
                return dist[(int)temp.getX()][(int)temp.getY()];
            }

            ArrayList<Point> list = getNext(temp);

            for (int i = 0; i < list.size(); i++)
            {
                if (!visited.contains(list.get(i)))
                {
                    q.add(list.get(i));
                    visited.add(list.get(i));
                }
            }
        }
        return -1;
    }

    public static ArrayList<Point> getNext(Point current)
    {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            Point temp = new Point((int)current.getX() + DX[i], (int)current.getY() + DY[i]);

            if (!validMove(temp))
            {
                continue;
            }
            dist[(int)temp.getX()][(int)temp.getY()] = dist[(int)current.getX()][(int)current.getY()] + 1;
            list.add(temp);

        }
        return list;
    }

}
