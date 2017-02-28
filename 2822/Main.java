/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2822
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Node[] array = new Node[8];
		int[] pos = new int[5];

		for (int i = 1; i <= 8; i++)
			array[i - 1] = new Node(input.nextInt(), i);

		Arrays.sort(array, (a, b) -> {
			if (a.num > b.num)
				return -1;
			else if (a.num < b.num)
				return 1;
			else
				return 0;
		});

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += array[i].num;
			pos[i] = array[i].pos;
		}
		System.out.println(sum);

		Arrays.sort(pos);
		for (int i = 0; i < 5; i++)
			System.out.print(pos[i] + " ");
	}

	private static class Node {
		public int num;
		public int pos;

		public Node(int num, int pos) {
			this.num = num;
			this.pos = pos;
		}
	}
}