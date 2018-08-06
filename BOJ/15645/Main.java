/*
 * Author: Minho Kim (ISKU)
 * Date: August 6, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15645
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[][] map, max, min;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		max = new int[N][3];
		min = new int[N][3];
		map = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			max[0][i] = map[0][i];
			min[0][i] = map[0][i];
		}

		for (int i = 1; i < N; i++) {
			max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + map[i][0];
			max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + map[i][1];
			max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + map[i][2];
			
			min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + map[i][0];
			min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + map[i][1];
			min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + map[i][2];
		}

		System.out.print(Math.max(max[N - 1][0], Math.max(max[N - 1][1], max[N - 1][2])) + " ");
		System.out.print(Math.min(min[N - 1][0], Math.min(min[N - 1][1], min[N - 1][2])));
	}
}