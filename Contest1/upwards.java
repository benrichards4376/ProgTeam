import java.util.*;

public class upwards
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int num_words = in.nextInt();
        for (int i = 0; i < num_words; i++)
        {
            String word = in.next();
            isUpWord(word);
        }
    }
    public static void isUpWord(String word)
    {
        HashSet<Character> repeat = new HashSet<>();
        for (int i = 0; i < word.length(); i++)
        {
            Character temp = word.charAt(i);
            if (repeat.contains(temp))
            {
                System.out.println("NO");
                return;
            }
            repeat.add(word.charAt(i));
            if (i < word.length() - 1 && word.charAt(i + 1) < word.charAt(i))
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
