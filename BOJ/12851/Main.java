/*
 * Author: Minho Kim (ISKU)
 * Date: January 23, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12851
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		visited[N] = 0;
		queue.add(N);

		int min = Integer.MAX_VALUE;
		int count = 0;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int step = visited[x];

			if (x == K) {
				if (min >= step) {
					min = step;
					count++;
				} else
					break;
			}

			if (x - 1 >= 0 && (visited[x - 1] == -1 || visited[x - 1] == step + 1)) {
				visited[x - 1] = step + 1;
				queue.add(x - 1);
			}
			if (x + 1 <= 100000 && (visited[x + 1] == -1 || visited[x + 1] == step + 1)) {
				visited[x + 1] = step + 1;
				queue.add(x + 1);
			}
			if (x * 2 <= 100000 && (visited[x * 2] == -1 || visited[x * 2] == step + 1)) {
				visited[x * 2] = step + 1;
				queue.add(x * 2);
			}
		}

		System.out.printf("%d\n%d", min, count);
	}
}