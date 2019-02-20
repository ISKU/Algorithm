/*
 * Author: Minho Kim (ISKU)
 * Date: February 18, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16953
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(bfs(sc.nextInt(), sc.nextInt()));
	}

	private static int bfs(int A, int B) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { A, 1 });

		while (!q.isEmpty()) {
			int[] N = q.poll();
			if (N[0] == B)
				return N[1];

			if (N[0] <= Integer.MAX_VALUE / 2)
				q.add(new int[] { N[0] * 2, N[1] + 1 });
			if (N[0] <= Integer.MAX_VALUE / 10)
				q.add(new int[] { N[0] * 10 + 1, N[1] + 1 });
		}

		return -1;
	}
}