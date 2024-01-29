import java.util.*;

public class mine
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int rows = in.nextInt();
            int cols = in.nextInt();
            int [][] board = new int[rows][cols];
            if (rows == 0 || cols == 0)
                return;

            for (int i = 0; i < rows; i++)
            {
                String temp = in.next();
                for (int j = 0; j < cols; j++)
                {
                    board[i][j] = temp.charAt(j);
                }
            }

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    if (board[i][j] == '.')
                        board[i][j] = getMines(board, i, j) + '0';

                    System.out.print((char)board[i][j]);
                }
                System.out.println();
            }

        }
    }

    public static int getMines(int [][] board, int i, int j)
    {
        int num_mines = 0;
        if (i + 1 < board.length && board[i + 1][j] == '*')
            num_mines++;
        if (i - 1 >= 0 && board[i - 1][j] == '*')
            num_mines++;
        if (j + 1 < board[0].length && board[i][j + 1] == '*')
            num_mines++;
        if (j - 1 >= 0 && board[i][j - 1] == '*')
            num_mines++;
        if (j + 1 < board[0].length && i + 1 < board.length && board[i + 1][j + 1] == '*')
            num_mines++;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == '*')
            num_mines++;
        if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == '*')
            num_mines++;
        if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] == '*')
            num_mines++;

        return num_mines;
    }
}
