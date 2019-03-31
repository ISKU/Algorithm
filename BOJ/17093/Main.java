/*
 * Author: Minho Kim (ISKU)
 * Date: April 1, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17093
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Point[] nPoints = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			nPoints[i] = new Point(y, x);
		}
		Point[] mPoints = new Point[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			mPoints[i] = new Point(y, x);
		}

		long answer = Long.MIN_VALUE;
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				answer = Math.max(answer, euclidean(mPoints[i], nPoints[j]));

		System.out.println(answer);
	}

	private static long euclidean(Point A, Point B) {
		return ((A.y - B.y) * (A.y - B.y)) + ((A.x - B.x) * (A.x - B.x));
	}

	private static class Point {
		public long y, x;

		public Point(long y, long x) {
			this.y = y;
			this.x = x;
		}
	}
}