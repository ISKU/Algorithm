/*
 * Author: Minho Kim (ISKU)
 * Date: June 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15784
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken()) - 1;
		int X = Integer.parseInt(st.nextToken()) - 1;

		int[][] map = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		boolean check = true;
		for (int y = 0; y < N; y++)
			if (map[y][X] > map[Y][X])
				check = false;
		for (int x = 0; x < N; x++)
			if (map[Y][x] > map[Y][X])
				check = false;

		System.out.print(check ? "HAPPY" : "ANGRY");
	}
}