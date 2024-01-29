import java.util.*;

public class news
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int num_emp = in.nextInt();
            Node [] a = new Node[num_emp];
            a[0] = new Node(-1);
            for (int j = 1; j < num_emp; j++)
            {
                a[j] = new Node(in.nextInt());
                a[a[j].supervisor].employees.add(j);
            }
            int time = solve(a, 0);
            System.out.println(time);
        }
    }

    public static int solve(Node [] a, int index)
    {
        if (a[index].employees.size() == 0)
            return 0;

        Integer [] time = new Integer[a[index].employees.size()];
        for (int i = 0; i < a[index].employees.size(); i++)
        {
            time[i] = 1 + solve(a, a[index].employees.get(i));
        }

        Arrays.sort(time, Collections.reverseOrder());
        int max = time[0];
        for (int i = 1; i < time.length; i++)
        {
            time[i] += i;
            if (time[i] > max)
                max = time[i];
        }

        return max;
    }
}

class Node
{
    ArrayList<Integer> employees;
    int supervisor;

    Node(int supervisor)
    {
        this.supervisor = supervisor;
        this.employees = new ArrayList<>();
    }
}
