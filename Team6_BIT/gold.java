import java.util.*;
public class gold {

	// Impossible value to achieve in the game.
	final public static int UNFILLED = -1000000000;

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		int numCases = stdin.nextInt();

		for (int loop=0; loop<numCases; loop++) {

			int N = stdin.nextInt();
			int[] vals = new int[N];
			for (int i=0; i<N; i++)
				vals[i] = stdin.nextInt();

			// table[i][j] will store my best score on sequence [i...j].
			int[][] table = new int[N][N];

			for (int i=0; i<N; i++)
				Arrays.fill(table[i],UNFILLED);
				
			// Solve this case.
			System.out.println(rec(vals, 0, N-1, table));
		}
	}

	// Returns the best outcome for the player going first if the input
	// sequence is vals[start...end].
	public static int rec(int[] vals, int start, int end, int[][] table) {
		
		// No need to run the recursion, we know the answer already.
		if (table[start][end] != UNFILLED)
			return table[start][end];

		// If one number is left, player number one gets it!
		if (start == end) {
			table[start][start] = vals[start];
			return vals[start];
		}
		
		// If I took the first term, this would be my score, because we
		// assume the other player would play optimally.
		int res1 = vals[start] - rec(vals, start+1, end, table);
			
		// This would be my score if I took the last term...	
		int res2 = vals[end] - rec(vals, start, end-1, table);

		// I just want to pick the better of my two options.
		if (res2 > res1) 
			res1 = res2;
			
		table[start][end] = res1;
		return res1;
	}
}