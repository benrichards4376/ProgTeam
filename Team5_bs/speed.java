import java.util.*;

public class speed
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        ArrayList<Double> speed = new ArrayList<>();
        ArrayList<duo> ds = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            
            double d = in.nextDouble();
            double s = in.nextDouble();
            ds.add(new duo(d, s));
            speed.add(s);
        }
        print(ds);
        double max_speed = max(speed);
        double low = 0;
        double high = 120;
        double mid = 60;
        // Collections.sort(ds);
        // Positive check
        while (high - low > 10e-6)
        {
            mid = low + (high - low) / 2;
            if (mid <= 10e-6)
            {
                
            }

            System.out.println("mid " + mid);
            double temp = solve(ds, mid);
            System.out.println("solve " + temp);
            
            if (temp < t)
            {
                low = mid;
            }
            else if (temp > t)
            {
                high = mid;
            }
            else if (temp == t)
            {
                break;
            }
            else
            {
                high = mid;
            }

        }
        System.out.printf("%.9f\n", mid);

    }
    public static void print(ArrayList<duo> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("Distance: " + list.get(i).d + " Speed: " + list.get(i).s);
        }
    }
    public static double solve(ArrayList<duo> ds, double c)
    {
        double sum = 0;
        for (int i = 0; i < ds.size(); i++)
        {
            sum += ds.get(i).d / (ds.get(i).s + c);
        }
        return sum;
    }
    public static double max(ArrayList<Double> list)
    {
        double max = list.get(0);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i) > max) max = list.get(i);
        return max;
    }
}

class duo implements Comparable<duo>
{
    double d;
    double s;

    duo(double d1, double s1)
    {
        d = d1;
        s = s1;
    }
    public int compareTo(duo b)
    {
        if (this.d > b.d) return 1;
        else if (this.d < b.d) return -1;
        return 0;
    }
}