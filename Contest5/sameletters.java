import java.util.*;

public class sameletters
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int end = 0;
        int n = 0;
        boolean fail = false;
        while (end < 2)
        {
            String temp = in.next();
            String temp2 = in.next();
            if (temp.charAt(0) == 'E')
                return;

            if (temp.length() != temp2.length())
            {
                System.out.println("Case " + (n+1) + ": different");
                n++;
                continue;
            }

            HashMap<Character, Integer> set = new HashMap<>();
            for (int i = 0; i < temp.length(); i++)
            {
                Integer m = set.get(temp.charAt(i));
                if (m == null)
                    set.put(temp.charAt(i), 1);
                else
                    set.put(temp.charAt(i), m + 1);
            }
            fail = false;
            for (int i = 0; i < temp2.length(); i++)
            {
                Integer p = set.get(temp2.charAt(i));
                if (!set.containsKey(temp2.charAt(i)) || p == 0)
                {
                    System.out.println("Case " + (n+1) + ": different");
                    fail = true;
                    break;
                }
                set.put(temp2.charAt(i), set.get(temp2.charAt(i)) - 1);
            }
            if (!fail)
                System.out.println("Case " + (n+1) + ": same");
            n++;

        }
    }
}
