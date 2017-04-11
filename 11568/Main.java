/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11568
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = input.nextInt();

		System.out.println(lis(array).length);
	}

	private static int[] lis(int[] array) {
		int[] tail = new int[array.length];
		int[] prev = new int[array.length];

		int length = 0;
		for (int i = 0; i < array.length; i++) {
			int pos = lowerBound(array, tail, length, array[i]);
			if (pos == length)
				length++;

			prev[i] = (pos > 0) ? tail[pos - 1] : -1;
			tail[pos] = i;
		}

		int[] result = new int[length];
		for (int i = tail[length - 1]; i >= 0; i = prev[i])
			result[--length] = array[i];

		return result;
	}

	private static int lowerBound(int[] array, int[] tail, int legnth, int key) {
		int low = -1;
		int high = legnth;

		while (high - low > 1) {
			int mid = (low + high) >>> 1;

			if (array[tail[mid]] < key)
				low = mid;
			else
				high = mid;
		}

		return high;
	}
}