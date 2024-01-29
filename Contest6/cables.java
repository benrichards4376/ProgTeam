import java.util.*;
import java.awt.geom.Point2D;
import java.awt.Point;

public class cables
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            int n = in.nextInt();
            if (n == 0)
                return;
            ArrayList<Point> list = new ArrayList<>();
            ArrayList<edge>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
            {
                list.add(new Point(in.nextInt(), in.nextInt()));
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < list.size(); j++)
                {
                    if (j == i)
                        continue;

                    graph[i].add(new edge(i, j, distance(list.get(i), list.get(j))));
                }
            }
            double min_cables = mst(graph, 0);
            System.out.printf("%.2f\n", min_cables);
        }

    }
    public static double distance(Point a, Point b)
    {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public static double mst(ArrayList[] graph, int v) {

		// Mark vertex v as being in mst.
		int n = graph.length;
		boolean[] used = new boolean[n];
		used[v] = true;
		// Add all of v's edges into the priority queue.
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		for (int i=0; i<graph[v].size(); i++)
			pq.offer(((ArrayList<edge>)graph[v]).get(i));

		int numEdges = 0;
        double res = 0;

		while (pq.size() > 0) {

			// Get next edge.
			edge next = pq.poll();
			if (used[next.v1] && used[next.v2]) continue;

            // Add new items to priority queue - need to check which vertex is new.
			if (!used[next.v1]) {
                for (int i=0; i<graph[next.v1].size(); i++)
                    pq.offer( ((ArrayList<edge>)graph[next.v1]).get(i));
                used[next.v1] = true;
			}
			else {
                for (int i=0; i<graph[next.v2].size(); i++)
                    pq.offer( ((ArrayList<edge>)graph[next.v2]).get(i));
                used[next.v2] = true;
			}

			// Bookkeeping
			numEdges++;
			res += next.w;
			if (numEdges == n-1) break;
		}

		// -1 indicates no MST, so not connected.
		return numEdges == n-1 ? res : -1;
	}
}
class edge implements Comparable<edge>
{

    public int v1;
    public int v2;
    public double w;

    public edge(int a, int b, double weight)
    {
        v1 = a;
        v2 = b;
        w = weight;
    }

    public int compareTo(edge other)
    {
        if (this.w > other.w)
            return 1;
        else if (this.w == other.w)
            return 0;
        else
            return -1;
    }
}
