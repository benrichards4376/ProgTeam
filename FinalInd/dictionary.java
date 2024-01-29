import java.util.*;

public class dictionary
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 0; i < c; i++)
        {
            int numWords = in.nextInt();
            int numQ = in.nextInt();
            TrieNode dict = new TrieNode();
            for (int j = 0; j < numWords; j++)
            {
                dict.insert(in.next());
            }

            for (int j = 0; j < numQ; j++)
            {
                String search = in.next();
                
                System.out.println()
            }
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
