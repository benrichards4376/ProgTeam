import java.util.*;

public class balloons implements Comparable<balloons>
{
    int needed;
    int dist_a;
    int dist_b;

    balloons()
    {
        needed = 0;
        dist_a = 0;
        dist_b = 0;
    }
    balloons(int need, int a, int b)
    {
        needed = need;
        dist_a = a;
        dist_b = b;
    }
    public static void main(String [] args)
    {

        Scanner in = new Scanner(System.in);
        int zero_count = 0;
        while (zero_count != 3)
        {
            int distance = 0;
            int num_teams = in.nextInt();
            int num_bal_a = in.nextInt();
            int num_bal_b = in.nextInt();
            if (num_teams == 0 && num_bal_a == 0 && num_bal_b == 0)
                return;
            ArrayList<balloons> array = new ArrayList<>();


            for (int i = 0; i < num_teams; i++)
            {
                array.add(new balloons());
                array.get(i).needed = in.nextInt();
                array.get(i).dist_a = in.nextInt();
                array.get(i).dist_b = in.nextInt();
            }
            Collections.sort(array, Collections.reverseOrder());
            boolean done = false;
            for (int i = 0; i < array.size(); i++)
            {
                if (array.get(i).dist_a < array.get(i).dist_b && array.get(i).needed > 0)
                {
                    while (array.get(i).needed > 0)
                    {
                        // System.out.println("A has " + num_bal_a + " balloons left");
                        // System.out.println("B has " + num_bal_b + " balloons left");
                        if (num_bal_a > 0)
                        {
                            //System.out.println("Team " + i + " needs " + array.get(i).needed + " balloons and takes 1 from A at " + array.get(i).dist_b + " units away");
                            num_bal_a--;
                            distance += array.get(i).dist_a;
                        }
                        else if (num_bal_b > 0)
                        {
                            //System.out.println("Team " + i + " needs " + array.get(i).needed + " balloons and takes 1 from B at " + array.get(i).dist_b + " units away");
                            num_bal_b--;
                            distance += array.get(i).dist_b;
                        }
                        else
                        {
                            System.out.println(distance);
                            done = true;
                            break;
                        }
                        array.get(i).needed--;
                    }
                }
                if (array.get(i).dist_a >= array.get(i).dist_b && array.get(i).needed > 0)
                {
                    while (array.get(i).needed > 0)
                    {
                        // System.out.println("A has " + num_bal_a + " balloons left");
                        // System.out.println("B has " + num_bal_b + " balloons left");

                        if (num_bal_b > 0)
                        {
                            // System.out.println("Team " + i + " needs " + array.get(i).needed + " balloons and takes 1 from B at " + array.get(i).dist_b + " units away");
                            num_bal_b--;
                            distance += array.get(i).dist_b;
                        }
                        else if (num_bal_a > 0)
                        {
                            // System.out.println("Team " + i + " needs " + array.get(i).needed + " balloons and takes 1 from A at " + array.get(i).dist_b + " units away");
                            num_bal_a--;
                            distance += array.get(i).dist_a;
                        }
                        else
                        {
                            System.out.println(distance);
                            done = true;
                            break;
                        }
                        array.get(i).needed--;

                    }
                }
                if (done)
                    break;
            }
            System.out.println(distance);
            if (zero_count >= 3)
                return;


        }


    }

    public int compareTo(balloons b)
    {
        if (Math.abs(dist_a - dist_b) == Math.abs(b.dist_a - b.dist_b))
            return 1;
        return Integer.compare(Math.abs(dist_a - dist_b), Math.abs(b.dist_a - b.dist_b));
    }
}
