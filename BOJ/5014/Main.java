/*
 * Author: Minho Kim (ISKU)
 * Date: January 25, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5014
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();

		int[] visited = new int[F + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[S] = 1;
		q.add(S);

		while (!q.isEmpty()) {
			int floor = q.poll();

			if (floor == G) {
				System.out.print(visited[G] - 1);
				System.exit(0);
			}

			if (floor + U <= F && visited[floor + U] == 0) {
				q.add(floor + U);
				visited[floor + U] = visited[floor] + 1;
			}
			if (floor - D >= 1 && visited[floor - D] == 0) {
				q.add(floor - D);
				visited[floor - D] = visited[floor] + 1;
			}
		}

		System.out.print("use the stairs");
	}
}