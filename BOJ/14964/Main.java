/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.26
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14964
 */

import java.util.*;

public class Main {

	private static String[][] graph;
	private static boolean[][] visited;
	private static int Y, X;
	private static String figure;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Y = input.nextInt();
		X = input.nextInt();

		int[] answer = new int[5];
		HashMap<String, Integer> map = new HashMap<String, Integer>() {{
				put("01b2r3t", 0);
				put("01r2r3r", 1);
				put("01b2b3b", 1);
				put("01b2l1r", 2);
				put("01b2r3b", 2);
				put("01r2b3r", 3);
				put("01b2l3b", 3);
				put("01b2r2l", 4);
				put("01b2b2r", 4);
				put("01r2b2r", 4);
				put("01b2b2l", 4);
		}};

		graph = new String[Y][X];
		for (int y = 0; y < Y; y++) {
			String[] line = input.next().split("");
			for (int x = 0; x < X; x++)
				graph[y][x] = line[x];
		}

		visited = new boolean[Y][X];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (!visited[y][x] && ".".equals(graph[y][x]) == false) {
					figure = "";
					dfs(y, x, graph[y][x], "", 0);
					answer[map.get(figure)]++;
				}
			}
		}

		for (int figure : answer)
			System.out.println(figure);
	}

	private static void dfs(int y, int x, String shape, String direction, int depth) {
		visited[y][x] = true;
		figure += depth + direction;

		if (y - 1 >= 0 && !visited[y - 1][x] && graph[y - 1][x].equals(shape))
			dfs(y - 1, x, shape, "t", depth + 1);
		if (y + 1 < Y && !visited[y + 1][x] && graph[y + 1][x].equals(shape))
			dfs(y + 1, x, shape, "b", depth + 1);
		if (x + 1 < X && !visited[y][x + 1] && graph[y][x + 1].equals(shape))
			dfs(y, x + 1, shape, "r", depth + 1);
		if (x - 1 >= 0 && !visited[y][x - 1] && graph[y][x - 1].equals(shape))
			dfs(y, x - 1, shape, "l", depth + 1);
	}
}