/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12738
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = input.nextInt();

		System.out.print(lis(array, N));
	}

	private static int lis(int[] array, int size) {
		int[] tail = new int[size];
		int length = 1;
		tail[0] = array[0];

		for (int i = 1; i < size; i++) {
			if (array[i] < tail[0])
				tail[0] = array[i];
			else if (array[i] > tail[length - 1])
				tail[length++] = array[i];
			else {
				int pos = Arrays.binarySearch(tail, 0, length, array[i]);
				tail[(pos < 0) ? -pos - 1 : pos] = array[i];
			}
		}

		return length;
	}
}