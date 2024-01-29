import java.util.*;

public class passwords
{
    int rank;

    passwords()
    {
        rank = 0;
    }
    public static void main(String [] args)
    {
        passwords pass = new passwords();
        Scanner in = new Scanner(System.in);
        int num_cases = in.nextInt();
        for (int i = 0; i < num_cases; i++)
        {
            pass.rank = 0;
            int pass_len = in.nextInt();
            ArrayList<String> letters = new ArrayList<>();
            for (int j = 0; j < pass_len; j++)
            {
                String temp = in.next();
                letters.add(temp);
            }
            StringBuilder temp = new StringBuilder("");

            Integer goal = in.nextInt();
            int x = pass.get_passwords(0, pass_len, letters, goal, temp);




        }

    }
    public int get_passwords(int index, int pass_len, ArrayList<String> letters, Integer goal, StringBuilder temp_pass)
    {

        if (index >= pass_len)
        {
            this.rank++;
            return 1;
        }
        String curr_letters = letters.get(index);
        for (int i = 0; i < curr_letters.length(); i++)
        {
            temp_pass.append(curr_letters.charAt(i));
            int x = this.get_passwords(index + 1, pass_len, letters, goal, temp_pass);
            if (x == -1)
                return -1;
            //System.out.println("rank: " + this.rank);
            if (rank == goal)
            {
                System.out.println(temp_pass.toString());
                return -1;
            }
            temp_pass.setLength(temp_pass.length() - 1);
        }
        return 0;
    }
}
