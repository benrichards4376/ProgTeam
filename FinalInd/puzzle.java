import java.util.*;

public class puzzle
{
    public static HashMap<String, Integer> dist = new HashMap<>();
    public static int [] check = {-3, -1, 1, 3};
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        String win = new String("123456780");
        reverseSolve(win);


        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int [][] temp = new int[3][3];
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    temp[j][k] = in.nextInt();

            String s = boardToString(temp);
            System.out.println(dist.get(s));
        }
        // System.out.println(dist.keySet());

        // int [][] temp = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        // System.out.println(boardToString(temp));
        // for (String s : dist.keySet())
        //     System.out.println(dist.get(s));
    }

    public static void reverseSolve(String win)
    {

        Queue<String> q = new ArrayDeque<>();
        q.add(win);
        dist.put(win, 0);
        while (!q.isEmpty())
        {
            String str = q.remove();

            ArrayList<String> next = getNext(str);

            for (int i = 0; i < next.size(); i++)
            {
                String t = next.get(i);
                if (!dist.containsKey(t))
                {
                    dist.put(t, dist.get(str) + 1);
                    q.add(t);
                }
            }
        }
    }

    public static ArrayList<String> getNext(String s)
    {
        int index = -1;
        // char [] temp = new char[s.length()];

        for (int i = 0; i < s.length(); i++)
        {
            // temp[i] = s.charAt(i);
            if (s.charAt(i) == '0')
                index = i;
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 4; i++)
        {
            if (i == 2 && (index == 2 || index == 5))
                continue;
            if (i == 1 && (index == 3 || index == 6))
                continue;
            if (check[i] + index > 8 || check[i] + index < 0)
                continue;
            String str = getMove(s.toCharArray(), index, check[i]);
            if (dist.containsKey(str))
                continue;

            list.add(str);
        }
        return list;
    }

    public static String getMove(char [] temp, int index, int num)
    {
        temp[index] = temp[index + num];
        temp[index + num] = '0';

        return new String(temp);
    }

    public static String boardToString(int [][] board)
    {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                str.append((char)(board[i][j] + '0'));

        return new String(str);
    }

    public static int [][] stringToBoard(String s)
    {
        int index = 0;
        int [][] board = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = s.charAt(index);
                index++;
            }
        }

        return board;
    }
}
