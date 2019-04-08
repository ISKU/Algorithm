/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17129
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };

	private static char[][] map;
	private static boolean[][] visited;
	private static Queue<int[]> q;
	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		visited = new boolean[Y][X];
		map = new char[Y][X];
		for (int y = 0; y < Y; y++) {
			String line = br.readLine();
			for (int x = 0; x < X; x++) {
				map[y][x] = line.charAt(x);
				if (map[y][x] == '2') {
					visited[y][x] = true;
					q.add(new int[] { y, x, 0 });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] p = q.poll();
			if (map[p[0]][p[1]] >= '3') {
				System.out.println("TAK\n" + p[2]);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int y = p[0] + dy[i];
				int x = p[1] + dx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || visited[y][x] || map[y][x] == '1')
					continue;

				visited[y][x] = true;
				q.add(new int[] { y, x, p[2] + 1 });
			}
		}

		System.out.println("NIE");
	}
}