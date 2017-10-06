/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.10.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14501
 */

import java.util.*;

public class Main {

	private static int N;
	private static Node[] works;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		works = new Node[N];

		for (int i = 0; i < N; i++)
			works[i] = new Node(input.nextInt(), input.nextInt());

		System.out.print(find(0));
	}

	private static int find(int index) {
		if (index >= N)
			return 0;

		int max = index + works[index].T - 1 < N ? 
				works[index].P + find(index + works[index].T) : 0;

		for (int i = 1; i < works[index].T; i++)
			max = Math.max(max, find(i + index));

		return max;
	}

	private static class Node {
		public int T;
		public int P;

		public Node(int T, int P) {
			this.T = T;
			this.P = P;
		}
	}
}