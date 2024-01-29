import java.util.*;

public class welcome
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int n = in.nextInt();
            if (n == 0)
                return;

            int [] first = new int[26];
            int [] last = new int[26];

            ArrayList<String> f_names = new ArrayList<>();
            ArrayList<String> l_names = new ArrayList<>();

            for (int i = 0; i < n; i++)
            {
                String first_name = in.next();
                String last_name = in.next();
                f_names.add(first_name);
                l_names.add(last_name);

                first[(int)first_name.charAt(0) - 'A']++;
                last[(int)last_name.charAt(0) - 'A']++;
            }
            int tot_f = 0;
            int tot_l = 0;
            for (int i = 0; i < 26; i++)
            {
                if (first[i] > 0)
                    tot_f++;
                if (last[i] > 0)
                    tot_l++;
            }
            int l = Math.min(tot_f, tot_l);

            int [] f_group = new int[26];
            int [] l_group = new int[26];
            for (int i = 0; i < f_names.size(); i++)
            {
                String first_name = f_names.get(i);
                String last_name = l_names.get(i);

                if (first[(int)first_name.charAt(0) - 'A'] >= last[(int)last_name.charAt(0) - 'A'])
                {
                    f_group[(int)first_name.charAt(0) - 'A']++;
                    last[(int)last_name.charAt(0) - 'A']--;
                }
                else if (first[(int)first_name.charAt(0) - 'A'] < last[(int)last_name.charAt(0) - 'A'])
                {
                    l_group[(int)last_name.charAt(0) - 'A']++;
                    first[(int)first_name.charAt(0) - 'A']--;
                }

            }
            int num_groups = 0;
            for (int i = 0; i < 26; i++)
            {
                if (f_group[i] > 0)
                    num_groups++;
                if (l_group[i] > 0)
                    num_groups++;
            }
            System.out.println(Math.min(num_groups, l));
        }
    }
}
