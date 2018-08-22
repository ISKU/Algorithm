/*
 * Author: Minho Kim (ISKU)
 * Date: August 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1797
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Fan[] fans = new Fan[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gender = st.nextToken().equals("0") ? -1 : 1;
			int index = Integer.parseInt(st.nextToken());
			fans[i] = new Fan(gender, index);
		}
		Arrays.sort(fans, 1, N + 1, new Comparator<Fan>() {
			@Override
			public int compare(Fan o1, Fan o2) {
				return o1.index - o2.index;
			}
		});

		int[] psum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			psum[i] = psum[i - 1] + fans[i].gender;

		int[][] map = new int[N * 2 + 1][2];
		for (int i = 0; i < map.length; i++)
			Arrays.fill(map[i], -1);

		int max = 0;
		for (int i = 0; i <= N; i++) {
			int[] p = map[psum[i] + N];

			if (p[0] == -1)
				p[0] = i;
			else
				p[1] = i;

			if (p[1] != -1)
				max = Math.max(max, fans[p[1]].index - fans[p[0] + 1].index);
		}

		System.out.print(max);
	}

	private static class Fan {
		public int gender, index;

		public Fan(int gender, int index) {
			this.gender = gender;
			this.index = index;
		}
	}
}
