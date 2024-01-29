import java.util.*;
public class railroad
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int n1 = in.nextInt();
            if (n1 == 0) return;
            int n2 = in.nextInt();
            if (n2 == 0) return;

            int [] products1 = new int[n1];
            int [] products2 = new int[n2];
            int [] pattern = new int[n1 + n2];
            for (int i = 0; i < n1; i++)
            {
                products1[i] = in.nextInt();
            }
            for (int i = 0; i < n2; i++)
            {
                products2[i] = in.nextInt();
            }
            for (int i = 0; i < n1 + n2; i++)
            {
                pattern[i] = in.nextInt();
            }
            Boolean [][] memo = new Boolean[n1 + 1][n2 + 1];
            boolean solved = solve(products1, products2, pattern, 0, 0, memo);
            System.out.println((solved == true) ? "possible" : "not possible");

        }
    }
    public static boolean solve(int [] a, int [] b, int [] pattern, int i, int j, Boolean [][] memo)
    {
        if (i + j >= pattern.length) return true;

        if (i < a.length && j < b.length && a[i] == pattern[i + j] && b[j] == pattern[i + j])
        {
            if (memo[i][j] != null)
            {
                return memo[i][j];
            }
            return memo[i][j] = (solve(a, b, pattern, i + 1, j, memo) || solve(a, b, pattern, i, j + 1, memo));
        }
        else if (i < a.length && a[i] == pattern[i + j])
        {
            if (memo[i][j] != null)
            {
                return memo[i][j];
            }
            return memo[i][j] = solve(a, b, pattern, i + 1, j, memo);
        }
        else if (j < b.length && b[j] == pattern[i + j])
        {
            if (memo[i][j] != null)
            {
                return memo[i][j];
            }
            return memo[i][j] = solve(a, b, pattern, i, j + 1, memo);
        }
        return false;
    }

}
