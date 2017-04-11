/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2565
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Node[] array = new Node[input.nextInt()];

		for (int i = 0; i < array.length; i++)
			array[i] = new Node(input.nextInt(), input.nextInt());

		Arrays.sort(array, (a, b) -> {
			if (a.left < b.left)
				return -1;
			else if (a.left > b.left)
				return 1;
			else
				return 0;
		});

		System.out.print(array.length - lis(array));
	}

	private static int lis(Node[] array) {
		int[] tail = new int[array.length];
		int length = 1;
		tail[0] = array[0].right;

		for (int i = 1; i < array.length; i++) {
			if (array[i].right < tail[0])
				tail[0] = array[i].right;
			else if (array[i].right > tail[length - 1])
				tail[length++] = array[i].right;
			else {
				int pos = Arrays.binarySearch(tail, 0, length, array[i].right);
				tail[(pos < 0) ? -pos - 1 : pos] = array[i].right;
			}
		}

		return length;
	}

	private static class Node {
		public int left = 0;
		public int right = 0;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}