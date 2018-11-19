/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16510
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] queue = new int[N + 1];
		for (int i = 1; i <= N; i++)
			queue[i] = Integer.parseInt(st.nextToken());

		int[] psum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			psum[i] = psum[i - 1] + queue[i];

		while (M-- > 0) {
			int T = Integer.parseInt(br.readLine());
			bw.write(lowerBound(psum, T) + "\n");
		}

		bw.close();
	}

	private static int lowerBound(int[] array, int value) {
		int l = 0;
		int r = array.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (array[mid] < value)
				l = mid + 1;
			else
				r = mid;
		}

		return (array[l] <= value) ? l : l - 1;
	}
}