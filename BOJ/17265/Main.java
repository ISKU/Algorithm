/*
 * Author: Minho Kim (ISKU)
 * Date: June 5, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17265
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		int[][] max = new int[N][N];
		int[][] min = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = st.nextToken().charAt(0);
				max[i][j] = Integer.MIN_VALUE;
				min[i][j] = Integer.MAX_VALUE;
			}
		}

		max[0][0] = map[0][0] - '0';
		min[0][0] = map[0][0] - '0';
		for (int i = 0; i < N; i++) {
			for (int j = i % 2; j < N; j += 2) {
				if (j - 2 >= 0) {
					int A = calculate(max[i][j - 2], map[i][j - 1], map[i][j] - '0');
					int B = calculate(min[i][j - 2], map[i][j - 1], map[i][j] - '0');
					max[i][j] = Math.max(max[i][j], A);
					min[i][j] = Math.min(min[i][j], B);
				}
				if (i - 2 >= 0) {
					int A = calculate(max[i - 2][j], map[i - 1][j], map[i][j] - '0');
					int B = calculate(min[i - 2][j], map[i - 1][j], map[i][j] - '0');
					max[i][j] = Math.max(max[i][j], A);
					min[i][j] = Math.min(min[i][j], B);
				}
				if (i - 1 >= 0 && j - 1 >= 0) {
					int A = calculate(max[i - 1][j - 1], map[i - 1][j], map[i][j] - '0');
					int B = calculate(max[i - 1][j - 1], map[i][j - 1], map[i][j] - '0');
					int C = calculate(min[i - 1][j - 1], map[i - 1][j], map[i][j] - '0');
					int D = calculate(min[i - 1][j - 1], map[i][j - 1], map[i][j] - '0');
					max[i][j] = Math.max(max[i][j], Math.max(A, B));
					min[i][j] = Math.min(min[i][j], Math.min(C, D));
				}
			}
		}

		System.out.printf("%d %d", max[N - 1][N - 1], min[N - 1][N - 1]);
	}

	private static int calculate(int A, char op, int B) {
		if (op == '+')
			return A + B;
		else if (op == '-')
			return A - B;
		else
			return A * B;
	}
}