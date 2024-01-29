import java.util.*;

public class upwards2
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            String word = in.next();
            // solve(word);
            System.out.println(solve(word));
        }
    }

    public static String solve(String word)
    {
        StringBuilder str = new StringBuilder();
        ArrayList<String> longest = new ArrayList<>();
        int index = 0;
        int len = 0;
        while (true)
        {

            StringBuilder temp = findLong(word, index);

            if (temp.length() >= len)
            {
                longest.add(new String(temp));
                len = temp.length();
            }
            index += temp.length();
            //System.out.println(index);
            if (index > word.length() - 1)
                break;
        }
        // for (int i = 0; i < longest.size(); i++)
        //     System.out.println(longest.get(i));
        len = 0;
        for (int i = 0; i < longest.size(); i++)
            if (longest.get(i).length() > len)
                len = longest.get(i).length();

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < longest.size(); i++)
            if (longest.get(i).length() == len)
                ans.add(longest.get(i));

        Collections.sort(ans);
        return ans.get(0);
    }
    public static StringBuilder findLong(String word, int start)
    {
        StringBuilder temp = new StringBuilder();
        temp.append(word.charAt(start));
        for (int i = start + 1; i < word.length(); i++)
        {
            if (word.charAt(i) > word.charAt(i - 1))
            {
                temp.append(word.charAt(i));
            }
            else
                return temp;
        }
        return temp;
    }
}
