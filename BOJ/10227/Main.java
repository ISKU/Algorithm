/*
 * Author: Minho Kim (ISKU)
 * Date: September 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10227
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int R, C, H, W;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];
		for (int y = 1; y <= R; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= C; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		int l = 1;
		int r = R * C;
		while (true) {
			int mid = (l + r) / 2;
			int result = findMedian(mid);
			if (result == 0) {
				System.out.print(mid);
				break;
			}

			if (result == 1)
				l = mid + 1;
			else
				r = mid - 1;
		}
	}

	static int findMedian(int m) {
		int[][] psum = new int[R + 1][C + 1];
		for (int y = 1; y <= R; y++) {
			for (int x = 1; x <= C; x++) {
				psum[y][x] = (map[y][x] < m) ? -1 : (map[y][x] > m) ? 1 : 0;
				psum[y][x] += psum[y - 1][x] + psum[y][x - 1] - psum[y - 1][x - 1];
			}
		}

		boolean checkMedian = false;
		for (int y = H; y <= R; y++) {
			for (int x = W; x <= C; x++) {
				int sum = psum[y][x] - psum[y - H][x] - psum[y][x - W] + psum[y - H][x - W];
				if (sum < 0)
					return -1;
				if (sum == 0)
					checkMedian = true;
			}
		}

		return (checkMedian) ? 0 : 1;
	}
}