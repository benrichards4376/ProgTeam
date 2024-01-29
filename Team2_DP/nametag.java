import java.util.*;

public class nametag
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            String temp = in.next();

            System.out.println(solve(temp));
        }
    }

    public static String solve(String str)
    {
        char min = str.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) < min)
                min = str.charAt(i);

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == min)
                list.add(getString(str, i));

        String small = list.get(0);
        for (int i = 1; i < list.size(); i++)
        {
            if (small.compareTo(list.get(i)) > 0)
                small = list.get(i);
        }
        return small;
    }
    public static String getString(String str, int start)
    {
        StringBuilder s = new StringBuilder();

        for (int i = start; i < str.length() + start; i++)
        {
            s.append(str.charAt(i % str.length()));
        }
        return new String(s);
    }
}
