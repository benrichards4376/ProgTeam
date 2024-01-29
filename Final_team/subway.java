import java.util.*;

public class subway
{
    public static duo position;
    public static int flag = 1;
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 0; i < c; i++)
        {
            flag = 1;
            int n = in.nextInt();
            char [][] maze = new char [n][3];
            for (int j = 0; j < n; j++)
            {
                String temp = in.next();
                maze[j][0] = temp.charAt(0);
                maze[j][1] = temp.charAt(1);
                maze[j][2] = temp.charAt(2);
            }

        
            duo position = new duo(0, 1);
            int [][] memo = new int [n][3];
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[j], -1);
            boolean [][] visited = new boolean[n][3];
            int coins = solve(maze, position, memo, visited);

            System.out.println(coins < 0 ? -1 : coins);
        }
    }

    public static int solve(char[][] maze, duo position, int[][] memo, boolean [][] visited)
    {
        int coins = 0;
        if (!isValidMove(maze, position) || visited[position.x][position.y])
        {
            // System.out.println("made it");
            return flag == -1 ? -1 : 0;
        }
        visited[position.x][position.y] = true;
        if (memo[position.x][position.y] != -1)
            return flag == -1 ? -1 : memo[position.x][position.y];
        
        coins += clearRow(maze, position);

        return flag == -1 ? -1 : (memo[position.x][position.y] = coins + max(solve(maze, new duo(position.x, position.y - 1), memo, visited), 
                                                            solve(maze, new duo(position.x, position.y + 1), memo, visited),
                                                            solve(maze, new duo(position.x + 1, position.y), memo, visited)));
    }

    public static int max(int x, int y, int z)
    {
        return Math.max(x, Math.max(y, z));
    }

    public static int clearRow(char [][] maze, duo position)
    {
        int coins = 0;
        if (maze[position.x][0] == '#' && maze[position.x][1] == '#' && maze[position.x][2] == '#')
            return flag = -1;
        // right moves
        for (int i = 1; i < 3; i++)
        {
            if (isValidMove(maze, new duo(position.x, position.y + i)))
            {
                if (maze[position.x][position.y + i] == 'c')
                {
                    coins++;
                    maze[position.x][position.y + i] = '.';
                    position.y = position.y + i;
                }
            }
            else
                break;
        }
        // left moves
        for (int i = 1; i < 3; i++)
        {
            if (isValidMove(maze, new duo(position.x, position.y - i)))
            {
                if (maze[position.x][position.y - i] == 'c')
                {
                    coins++;
                    maze[position.x][position.y - i] = '.';
                    position.y = position.y - i;
                }
            }
            else
                break;
        }
        return coins;
    }

    public static boolean isValidMove(char[][] maze, duo d)
    {
        // System.out.println(d);
        // System.out.println("length: " + maze.length);
        // System.out.println("maze: " + maze[d.x][d.y]);
        return !(d.y > 2 || d.y < 0 || d.x > maze.length || maze[d.x][d.y] == '#');
    }
}

class duo
{
    public int x;
    public int y; 
    duo(int x1, int y1)
    {
        x = x1;
        y = y1;
    }

    public String toString()
    {
        return "Point: (" + x + ", " + y + ")";
    }
}