/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15724
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] psum = new int[Y + 1][X + 1];
		for (int y = 1; y <= Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= X; x++) {
				psum[y][x] += Integer.parseInt(st.nextToken());
				psum[y][x] += psum[y - 1][x] + psum[y][x - 1];
				psum[y][x] -= psum[y - 1][x - 1];
			}
		}

		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			int sum = psum[y2][x2] + psum[y1 - 1][x1 - 1];
			sum -= psum[y2][x1 - 1];
			sum -= psum[y1 - 1][x2];
			bw.write(sum + "\n");
		}

		bw.close();
	}
}