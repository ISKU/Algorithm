/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1377
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Node> array = new ArrayList<Node>();
		int N = input.nextInt();

		for (int i = 0; i < N; i++)
			array.add(new Node(input.nextInt(), i));

		Collections.sort(array);

		int max = 0;
		for (int i = 0; i < N; i++)
			if (max < array.get(i).position - i)
				max = array.get(i).position - i;

		System.out.println(max + 1);
	}

	private static class Node implements Comparable<Node> {
		public int value;
		public int position;

		public Node(int value, int position) {
			this.value = value;
			this.position = position;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value < o.value)
				return -1;
			else if (this.value > o.value)
				return 1;
			else {
				if (this.position < o.position)
					return -1;
				else if (this.position > o.position)
					return 1;
				else
					return 0;
			}
		}
	}
}