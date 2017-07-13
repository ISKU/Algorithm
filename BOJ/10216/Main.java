/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.15
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10216
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	private static ArrayList<Node> graph;
	private static boolean[] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int nodes = input.nextInt();
			graph = new ArrayList<Node>();
			visited = new boolean[nodes];

			for (int i = 0; i < nodes; i++)
				graph.add(new Node(input.nextInt(), input.nextInt(), input.nextInt()));

			for (int i = 0; i < nodes; i++) {
				for (int j = i + 1; j < nodes; j++) {
					int x = (graph.get(i).x - graph.get(j).x) * (graph.get(i).x - graph.get(j).x);
					int y = (graph.get(i).y - graph.get(j).y) * (graph.get(i).y - graph.get(j).y);
					int r = (graph.get(i).r + graph.get(j).r) * (graph.get(i).r + graph.get(j).r);

					if (x + y <= r) {
						graph.get(i).group.add(j);
						graph.get(j).group.add(i);
					}
				}
			}

			int answer = 0;
			for (int i = 0; i < nodes; i++)
				if (!visited[i]) {
					answer++;
					dfs(i);
				}

			System.out.println(answer);
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;

		for (int index : graph.get(cur).group)
			if (!visited[index])
				dfs(index);
	}

	private static class Node {
		public int x;
		public int y;
		public int r;
		ArrayList<Integer> group = new ArrayList<Integer>();

		public Node(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
}