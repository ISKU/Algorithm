/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14719
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		boolean[][] graph = new boolean[input.nextInt()][input.nextInt()];

		for (int i = 0; i < graph[0].length; i++) {
			int h = input.nextInt();
			for (int j = graph.length - 1; h > 0; j--, h--)
				graph[j][i] = true;
		}

		int answer = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j])
					continue;

				boolean left = false;
				boolean right = false;
				int leftIndex = j;
				int rightIndex = j;

				while (--leftIndex >= 0)
					if (graph[i][leftIndex]) {
						left = true;
						break;
					}

				while (++rightIndex < graph[i].length)
					if (graph[i][rightIndex]) {
						right = true;
						break;
					}

				if (left && right) {
					for (int index = leftIndex + 1; index <= rightIndex - 1; index++) {
						graph[i][index] = true;
						answer++;
					}
				}
			}
		}

		System.out.print(answer);
	}
}