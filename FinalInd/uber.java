import java.util.*;
import java.awt.geom.Point2D;
import java.awt.Point;

// Should've used floyd instead :(
public class uber
{
    static int oo = (int) 1e9 + 1;
    static int n;
    static ArrayList<edge>[] g;

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();

        for (int i = 0; i < c; i++)
        {
            n = in.nextInt();
            int numTrips = in.nextInt();
            g = new ArrayList[n];

            for (int j = 0; j < n; j++)
                g[j] = new ArrayList<>();

            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    g[j].add(new edge(k, in.nextInt()));
                }
            }
            // ArrayList<Integer>[] stops = new ArrayList[numTrips];
            // for (int j = 0; j < numTrips; j++)
            //     stops[j] = new ArrayList<>();
            //
            // for (int j = 0; j < numTrips; j++)
            // {
            //     int numStops = in.nextInt();
            //     for (int k = 0; k < numStops; k++)
            //         stops[j].add(in.nextInt() - 1);
            // }
            HashMap<Point, Integer> dp = new HashMap<>();
            for (int j = 0; j < numTrips; j++)
            {
                int numStops = in.nextInt();
                ArrayList<Integer> stops = new ArrayList<>();
                for (int k = 0; k < numStops; k++)
                    stops.add(in.nextInt() - 1);

                int sum = 0;
                for (int k = 0; k < numStops - 1; k++)
                {
                    int temp;
                    Point check = new Point(stops.get(k), stops.get(k + 1));
                    if (dp.containsKey(check))
                    {
                        temp = dp.get(check);
                    }
                    else
                    {
                        temp = dijkstras(stops.get(k), stops.get(k + 1));
                        dp.put(check, temp);
                    }

                    if (temp == oo)
                    {
                        sum = -1;
                        break;
                    }
                    sum += temp;
                }
                System.out.println(sum);
            }
        }
    }
    public static int dijkstras(int s, int d) {

        // Set up the priority queue.
        boolean[] visited = new boolean[n];
        PriorityQueue<edge> pq = new PriorityQueue<edge>();
        pq.add(new edge(s, 0));

        // Go till empty.
        while (!pq.isEmpty()) {

          // Get the next edge.
          edge at = pq.poll();
          if (visited[at.e])
            continue;

          visited[at.e] = true;

          // We made it, return the distance.
          if (at.e == d)
            return at.w;

          // Enqueue all the neighboring edges.
          for (edge adj : g[at.e])
            if (!visited[adj.e] && adj.w != -1)
                pq.add(new edge(adj.e, adj.w + at.w));
        }
        return oo;
  }
}
// Stores where an edge is going to and its weight.
class edge implements Comparable<edge> {
    int e, w;

    public edge(int e, int w) {
      this.e = e;
      this.w = w;
    }

    public int compareTo(edge o) {
      return w - o.w;
    }
}
