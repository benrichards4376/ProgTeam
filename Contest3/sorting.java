import java.util.*;

public class sorting {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<nC; loop++) {

			int n = stdin.nextInt();

			// Add each item to a priority queue.
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			for (int i=0; i<n; i++)
				pq.offer(stdin.nextLong());

			long cost = 0;

			// We stop when the numbers have all been added.
			while (pq.size() > 1) {

				// Get the two minimums.
				long a = pq.poll();
				long b = pq.poll();

				// Cost added.
				cost += (a+b);

				// Put back into the priority queue.
				pq.add(a+b);
			}

			// Our answer.
			System.out.println(cost);
		}
	}
}
