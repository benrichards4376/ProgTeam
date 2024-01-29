import java.util.*;

public class stars
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            int num_stars = in.nextInt();
            int num_connections = in.nextInt();
            ArrayList<Integer>[] adj_list = new ArrayList[num_stars + 1];
            for (int j = 1; j < num_stars + 1; j++)
            {
                adj_list[j] = new ArrayList<Integer>();

            }
            int [] incoming = new int[num_stars + 1];
            for (int j = 0; j < num_connections; j++)
            {
                int from = in.nextInt();
                int to = in.nextInt();
                adj_list[from].add(to);
                adj_list[to].add(from);
            }

            int num_visited = 0;

            int[] visited = new int[num_stars + 1];
            Arrays.fill(visited, -1);
            int numComp = 0;
            ArrayList<Integer> roots = new ArrayList<>();
            ArrayList<Integer> num_vertices = new ArrayList<>();
            int [] degree = new int[num_stars + 1];
            num_vertices.add(-1);
            for (int j = 1; j < num_stars + 1; j++)
            {
                int cnt = 1;
                if (visited[j] == -1)
                {
                    numComp++;
                    roots.add(j);
                    cnt += dfs(adj_list, j, visited, numComp, degree);
                    num_vertices.add(cnt);
                }
            }
            int [] edges = new int[num_vertices.size()];
            for (int j = 1; j < degree.length; j++)
            {
                edges[visited[j]] += degree[j];
                if (num_vertices.get(visited[j]) < 2)
                    numComp--;
            }
            int fix = 0;

            for (int j = 1; j < edges.length; j++)
                if (edges[j] != (2 * num_vertices.get(j) - 2))
                    fix++;
            System.out.println();
            System.out.println("Night sky #" + (i+1) + ": " + numComp + " constellations, of which " + fix + " need to be fixed.");

        }
    }
// dfs + count components -- see stars for more
{
    int[] compNum = new int[numV];
	Arrays.fill(compNum, -1);
	// Try starting from each vertex.
	for (int i=0; i<numV; i++)
    {

		// We haven't been here yet, DFS from here.
		if (compNum[i] == -1)
        {
			dfs(i, compNum, numComponents);
			numComponents++;
		}
	}
}
    public static int dfs(ArrayList[] g, int node, int[] visited, int numComp, int [] degree)
    {
        visited[node] = numComp;
        int cnt = 0;
        for (int i = 0; i < g[node].size(); i++)
        {
            if (visited[(Integer)g[node].get(i)] == -1)
            {
                cnt += 1 + dfs(g, (Integer)g[node].get(i), visited, numComp, degree);
            }
            degree[(Integer)g[node].get(i)]++;
        }

        return cnt;
    }
}
