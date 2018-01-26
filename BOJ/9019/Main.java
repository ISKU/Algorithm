/*
 * Author: Minho Kim (ISKU)
 * Date: January 26, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9019
 */

import java.util.*;

public class Main {

	private static final int MAX = 10000;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			Queue<Integer> q = new LinkedList<Integer>();
			String[] visited = new String[MAX];
			q.add(A);
			visited[A] = "";

			while (!q.isEmpty()) {
				A = q.poll();
				int L = (A % 1000) * 10 + A / 1000;
				int R = (A % 10) * 1000 + (A / 10);

				if (A == B) {
					System.out.println(visited[A]);
					break;
				}

				if (visited[(2 * A) % MAX] == null) {
					q.add((2 * A) % MAX);
					visited[(2 * A) % MAX] = visited[A] + "D";
				}
				if (visited[(A == 0) ? MAX - 1 : A - 1] == null) {
					q.add((A == 0) ? MAX - 1 : A - 1);
					visited[(A == 0) ? MAX - 1 : A - 1] = visited[A] + "S";
				}
				if (visited[L] == null) {
					q.add(L);
					visited[L] = visited[A] + "L";
				}
				if (visited[R] == null) {
					q.add(R);
					visited[R] = visited[A] + "R";
				}
			}
		}
	}
}