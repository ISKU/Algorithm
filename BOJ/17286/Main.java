/*
 * Author: Minho Kim (ISKU)
 * Date: June 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17286
 */

import java.io.*;
import java.util.*;

public class Main {

	private static double[][] points;
	private static double answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		points = new double[4][3];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Double.parseDouble(st.nextToken());
			points[i][1] = Double.parseDouble(st.nextToken());
		}

		answer = Double.MAX_VALUE;
		for (int i = 1; i <= 3; i++) {
			points[i][2] = 1;
			dfs(1, points[i], distance(points[0], points[i]));
			points[i][2] = 0;
		}

		System.out.print((int) answer);
	}

	private static void dfs(int n, double[] u, double dist) {
		if (n == 3) {
			answer = Math.min(answer, dist);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			double[] v = points[i];
			if (v[2] == 1)
				continue;

			v[2] = 1;
			dfs(n + 1, v, dist + distance(u, v));
			v[2] = 0;
		}
	}

	private static double distance(double[] A, double[] B) {
		return Math.sqrt(((A[0] - B[0]) * (A[0] - B[0])) + ((A[1] - B[1]) * (A[1] - B[1])));
	}
}