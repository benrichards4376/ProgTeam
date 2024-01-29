import java.util.*;
public class lottery
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 0; i < c; i++)
        {
            TrieNode orig = new TrieNode();
            TrieNode rev = new TrieNode();
            int q = in.nextInt();
            System.out.println("Lottery #" + (i + 1) + ":");
            boolean isRev = false;
            for (int j = 0; j < q; j++)
            {
                int temp = in.nextInt();

                if (temp == 1)
                {
                    String word = in.next();
                    if (!isRev)
                    {
                        orig.insert(word);
                        rev.insert((new StringBuilder(word)).reverse().toString());
                    }
                    else
                    {
                        rev.insert(word);
                        orig.insert((new StringBuilder(word)).reverse().toString());
                    }
                }
                else if (temp == 2)
                {
                    String winner = in.next();
                    int numWin = (isRev) ? rev.numPrefix(winner) : orig.numPrefix(winner);
                    System.out.println(numWin);
                }
                else if (temp == 3)
                {
                    isRev = !isRev;
                }
                else
                {
                    String word = in.next();
                    System.out.println("orig: " + orig.search(word));
                    System.out.println("rev " + rev.search((new StringBuilder(word)).reverse().toString()));
                }
            }
            if (i != c - 1)
                System.out.println();
        }
    }
}

class TrieNode
{
    int flag = 0;
    TrieNode [] children = new TrieNode[26];

    public void insert(String word)
    {
        TrieNode temp = this;
        for (int i = 0; i < word.length(); i++)
        {
            char c = (char)(word.charAt(i) - 'a');
            if (temp.children[c] == null)
                temp.children[c] = new TrieNode();

            if (i == word.length() - 1)
                temp.children[c].flag++;

            temp = temp.children[c];
        }
    }

    public boolean search(String word)
    {
        if (this == null)
            return false;
        TrieNode wizard = this;
        for (int i = 0; i < word.length(); i++)
        {
            System.out.println(wizard.flag);
            char c = (char)(word.charAt(i) - 'a');
            if (wizard.children[c] == null)
                return false;

            if (i == word.length() - 1)
                return wizard.children[c].flag > 0;
            wizard = wizard.children[c];
        }
        return false;
    }
    public int numPrefix(String prefix)
    {
        if (prefix == "")
            return countWords(this);

        TrieNode temp = this;
        for (int i = 0; i < prefix.length(); i++)
        {
            char c = (char)(prefix.charAt(i) - 'a');
            if (temp.children[c] == null)
                return 0;
            temp = temp.children[c];
        }
        return countWords(temp);
    }
    public static int countWords(TrieNode wizard)
    {
        if (wizard == null)
            return 0;

        int num = wizard.flag;
        for (int i = 0; i < 26; i++)
        {
            num += countWords(wizard.children[i]);
        }
        return num;
    }
}
