/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.09
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2667
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	private static boolean[][] graph;
	private static boolean[][] visited;
	private static int N;
	private static int count = 0;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		graph = new boolean[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] line = input.next().toCharArray();
			for (int j = 0; j < line.length; j++)
				graph[i][j] = (line[j] == '1') ? true : false;
		}

		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (graph[y][x] && !visited[y][x]) {
					dfs(y, x);
					answer.add(count);
					count = 0;
				}

		Collections.sort(answer);
		System.out.println(answer.size());
		for (int number : answer)
			System.out.println(number);
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		count++;

		if (y - 1 >= 0 && graph[y - 1][x] && !visited[y - 1][x])
			dfs(y - 1, x);
		if (y + 1 < N && graph[y + 1][x] && !visited[y + 1][x])
			dfs(y + 1, x);
		if (x - 1 >= 0 && graph[y][x - 1] && !visited[y][x - 1])
			dfs(y, x - 1);
		if (x + 1 < N && graph[y][x + 1] && !visited[y][x + 1])
			dfs(y, x + 1);
	}
}