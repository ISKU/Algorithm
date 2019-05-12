/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12273
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };
	private static int[][] map = new int[100][100];
	private static int[][] step = new int[100][100];
	private static int[][] power = new int[100][100];
	private static int Y, X;
	private static int sy, sx, ey, ex;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());

			for (int y = 0; y < Y; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < X; x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}

			int power = bfs();
			bw.write("Case #");
			bw.write(String.valueOf(t));
			bw.write(": ");
			bw.write((power == -1) ? "Mission Impossible." : String.valueOf(power));
			bw.write('\n');
		}

		bw.close();
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int y = 0; y < Y; y++) {
			Arrays.fill(step[y], 0, X, Integer.MAX_VALUE);
			Arrays.fill(power[y], 0, X, -1);
		}
		q.add(new int[] { sy, sx });
		step[sy][sx] = 1;
		power[sy][sx] = map[sy][sx];

		while (!q.isEmpty()) {
			int[] c = q.poll();
			int y = c[0];
			int x = c[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= Y || nx < 0 || nx >= X || map[ny][nx] == -1)
					continue;

				int s = step[y][x] + 1;
				int p = power[y][x] + map[ny][nx];
				if (s > step[ny][nx] || p <= power[ny][nx])
					continue;

				q.add(new int[] { ny, nx });
				step[ny][nx] = s;
				power[ny][nx] = p;
			}
		}

		return power[ey][ex];
	}
}