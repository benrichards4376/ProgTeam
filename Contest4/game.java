import java.util.*;
public class game
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            String word = in.next();
            int level = 0;
            int max = 0;
            for (int j = 0; j < word.length(); j++)
            {
                if (word.charAt(j) == 'v')
                    level++;
                else if (word.charAt(j) == '^' && level != 0)
                    level--;
                if (level > max)
                    max = level;
            }
            System.out.println(max);
        }
    }
}
