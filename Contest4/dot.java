import java.util.*;
public class dot
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++)
        {
            int size = in.nextInt();
            int num_dots = in.nextInt();
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            int eaten = 0;
            for (int j = 0; j < num_dots; j++)
            {
                Integer temp = in.nextInt();
                Integer t = mp.get(temp);
                //System.out.println(temp + " " + t);
                mp.put(temp, (t == null) ? 1 : t + 1);
            }
            // for (Integer x : mp.keySet())
            //     System.out.println("key: " + x + " value: " + mp.get(x));
            while (size <= mp.lastKey() && eaten != -1)
            {
                // for (Integer x : mp.keySet())
                //     System.out.println("key: " + x + " value: " + mp.get(x));
                Integer temp = mp.lowerKey(size);
                if (temp == null)
                {
                    eaten = -1;
                    break;
                }
                else
                {
                    Integer a = mp.get(temp);
                    if (a < 1)
                    {
                        mp.remove(temp);
                        continue;
                    }
                    size += temp;
                    mp.put(temp, a - 1);
                    eaten++;
                }
            }
            System.out.println(eaten);
        }
    }
}
