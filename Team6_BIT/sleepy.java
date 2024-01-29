import java.util.*;
import java.io.*;

public class sleepy {

	public static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(stdin.readLine().trim());

		// start is a map start[x-1] = index where x is stored.
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		int[] start = new int[n];
		for (int i=0; i<n; i++)
			start[Integer.parseInt(tok.nextToken())-1] = i+1;

		// end[i] will equal the index of where the ith value
		// in this array appears in the first array.
		int [] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = i + 1;
        }
		int[] end = new int[n];
		for (int i=0; i<n; i++) {
			int tmp = arr[i] - 1;
			end[i] = start[tmp];
		}

		// Count inversions in second array.
		System.out.println(countInversions(end));
	}

	public static long countInversions(int[] array) {

		// Will insert locations of items from array.
		bit tree = new bit(n+5);

		long res = 0L;
		
		// Go through items.
		for (int i=0; i<n; i++) {
			
			// All of the items higher than me in the bit are inversions.
			res += tree.atOrAbove(array[i]+1);
			
			// Add me to the bit.
			tree.add(array[i], 1);
		}
		return res;
	}
}

class bit {

	public long[] cumfreq;

	// Do indexes 1 to n.
	public bit(int n) {

		int size = 1;
		while (size < n) size <<= 1;
		n = size;

		cumfreq = new long[n+1];
	}

	// Uses 1 based indexing.
	public void add(int index, long value) {
		while (index < cumfreq.length) {
			cumfreq[index] += value;
			index += Integer.lowestOneBit(index);
		}
	}

	// Returns the sum of everything upto index.
	public long sum(int index) {
		long ans = 0;
		while (index > 0) {
			ans += cumfreq[index];
			index -= (Integer.lowestOneBit(index));
		}
		return ans;
	}

	// Use 1 based indexing.
	public long sum(int low, int high) {
		return sum(high) - sum(low-1);
	}

	// Return the total number of items in the BIT.
	public long all() {
		return sum(cumfreq.length-1);
	}

	// Return the total number of items in the BIT at or above index.
	public long atOrAbove(int index) {
		long sub = 0;
		if (index > 0) sub = sum(index-1);
		return all() - sub;
	}
}