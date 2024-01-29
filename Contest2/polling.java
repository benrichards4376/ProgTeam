import java.util.*;
public class polling
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int num_votes = in.nextInt();
        HashMap<String, Integer> votes = new HashMap<>();

        for (int i = 0; i < num_votes; i++)
        {
            String name = in.next();
            Integer temp = votes.get(name);
            if (temp == null)
                votes.put(name, 1);
            else
                votes.put(name, temp + 1);
        }
        int max = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (String s : votes.keySet())
        {
            if (votes.get(s) > max)
                max = votes.get(s);
        }
        for (String s : votes.keySet())
        {
            if (votes.get(s) == max)
                winners.add(s);
        }
        Collections.sort(winners);

        for (int i = 0; i < winners.size(); i++)
        {
            System.out.println(winners.get(i));
        }
    }
}
