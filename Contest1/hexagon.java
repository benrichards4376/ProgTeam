import java.util.*;

public class hexagon
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int num_cases = in.nextInt();
        int [][] hexagons = new int[7][6];
        for (int i = 0; i < num_cases; i++)
        {
            for (int j = 0; j < 7; j++)
                for (int k = 0; k < 6; k++)
                    hexagons[j][k] = in.nextInt();

            int [] perm = new int[7];
            boolean [] used = new boolean[7];
            System.out.printf("Case %d: ", i + 1);
            if (!run_perms(hexagons, perm, used, 0))
                System.out.println("No solution");

        }

    }
    public static boolean run_perms(int [][] hexagons, int[] perm, boolean[] used, int k)
     {
        if (k == perm.length)
        {
            int [][] temp_hex = new int[7][6];
            for (int i = 0; i < 7; i++)
                for (int j = 0; j < 6; j++)
                    temp_hex[i][j] = hexagons[perm[i]][j];
            if (isSolvable(temp_hex, perm))
                return true;
        }

        for (int i = 0; i < perm.length; i++)
        {
            if (!used[i])
            {
                used[i] = true;
                perm[k] = i;
                if(run_perms(hexagons, perm, used, k + 1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }
    public static boolean isSolvable(int [][] temp_hex, int [] perm)
    {
        temp_hex[0] = rotate(temp_hex[0], 1, 0);

        for (int i = 1; i <= 6; i++)
            temp_hex[i] = rotate(temp_hex[i], temp_hex[0][i - 1], ((i + 8) % 6));

        if (temp_hex[1][2] != temp_hex[2][5])
            return false;
        if (temp_hex[2][3] != temp_hex[3][0])
            return false;
        if (temp_hex[3][4] != temp_hex[4][1])
            return false;
        if (temp_hex[4][5] != temp_hex[5][2])
            return false;
        if (temp_hex[5][0] != temp_hex[6][3])
            return false;
        if (temp_hex[6][1] != temp_hex[1][4])
            return false;

        for (int i = 0; i < perm.length; i++)
        {
            System.out.printf("%d%s", perm[i], (i == perm.length - 1)? "" : " ");
        }
        System.out.println();
        return true;
    }
    // public static int [][] rotate(int [][] hexagons, int piece, int start_num, int end_pos)
    // {
    //     while (hexagons[piece][end_pos] != start_num)
    //         hexagons = rotateClock(hexagons, piece);
    //
    //     return hexagons;
    // }
    public static int [] rotate(int [] temp, int start_num, int end_pos)
    {

        while (temp[end_pos] != start_num)
            temp = rotateClock(temp);

        return temp;
    }

    // Backtracking top piece is a 1, temp arrqy of 42, copy as it would lie into the puzzle. place 0 rotate till
    public static int [] rotateClock(int [] temp)
    {
        int [] temp_piece = new int[temp.length];
        temp_piece[0] = temp[temp.length - 1];
        for (int i = 1; i < temp_piece.length; i++)
        {
            temp_piece[i] = temp[i - 1];
        }

        return temp_piece;
    }
    // public static int [][] rotateClock(int [][] hexagons, int piece)
    // {
    //     int [] temp_piece = new int[hexagons[piece].length];
    //     temp_piece[0] = hexagons[piece][temp_piece.length - 1];
    //     for (int i = 1; i < temp_piece.length; i++)
    //     {
    //         temp_piece[i] = hexagons[piece][i - 1];
    //     }
    //     for (int i = 0; i < temp_piece.length; i++)
    //     {
    //         hexagons[piece][i] = temp_piece[i];
    //     }
    //
    //     return hexagons;
    // }
}
