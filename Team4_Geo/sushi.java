import java.util.*;

public class sushi
{
    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++)
        {
            int cars = in.nextInt();
            TreeMap<Integer, Integer> travel = new TreeMap<>();
            for (int j = 0; j < cars; j++)
            {
                int temp = in.nextInt();
                travel.put(temp, travel.getOrDefault(temp, 0) + 1);
            }

            TreeMap<Integer, Integer> eat = new TreeMap<>();
            for (int j = 0; j < 4 * cars; j++)
            {
                int temp = in.nextInt();
                eat.put(temp, eat.getOrDefault(temp, 0) + 1);
            }

            int minutes = 0;
            for (int j = 0; j < cars; j++)
            {
                int car = travel.firstKey();

                for (int k = 0; k < 4; k++)
                {
                    int temp = eat.lastKey();
                    if (temp + car > minutes)
                        minutes = temp + car;
                    if (eat.get(temp) - 1 == 0)
                        eat.remove(temp);
                    else
                        eat.put(temp, eat.get(temp) - 1);

                }
                if (travel.get(car) - 1 == 0)
                    travel.remove(car);
                else
                    travel.put(car, travel.get(car) - 1);
            }
            System.out.println("Trip #" + i + ": " + minutes);
        }
    }
}
