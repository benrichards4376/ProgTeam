import java.util.*;

public class segment
{
    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            double x_center = in.nextDouble();
            double y_center = in.nextDouble();
            double r = in.nextDouble();

            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double x2 = in.nextDouble() /*- x1*/;
            double y2 = in.nextDouble() /*- y1*/;

            double dist_x = x2 - x1;
            double dist_y = y2 - y1;

            double a = Math.pow(dist_x, 2) + Math.pow(dist_y, 2);
            double b = 2 * (dist_x * (x1 - x_center) + dist_y * (y1 - y_center));
            double c = Math.pow(x1 - x_center, 2) + Math.pow(y1 - y_center, 2) - Math.pow(r, 2);

            double root = Math.pow(b, 2) - 4 * a * c;



            if (a == 0 || root < 0)
            {
                System.out.println("The line segment does not intersect the circle.");
                continue;
            }

            double positive = (-b + Math.sqrt(root)) / (2 * a);
            double negative = (-b - Math.sqrt(root)) / (2 * a);

            if ((x1 + positive * dist_x >= Math.min(x1, x2) && x1 + positive * dist_x <= Math.max(x1, x2)) && (y1 + positive * dist_y >= Math.min(y1, y2) && y1 + positive * dist_y <= Math.max(y1, y2)))
            {
                System.out.println("The line segment intersects the circle.");
                continue;
            }
            if ((x1 + negative * dist_x >= Math.min(x1, x2) && x1 + negative * dist_x <= Math.max(x1, x2)) && (y1 + negative * dist_y >= Math.min(y1, y2) && y1 + negative * dist_y <= Math.max(y1, y2)))
            {
                System.out.println("The line segment intersects the circle.");
                continue;
            }

            System.out.println("The line segment does not intersect the circle.");
        }
    }
}
