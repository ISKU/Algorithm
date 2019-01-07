/*
 * Author: Minho Kim (ISKU)
 * Date: January 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16712
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] man = new int[N];
		for (int i = 0; i < N; i++)
			man[i] = Integer.parseInt(st.nextToken());

		int[][] game = new int[M][2];
		for (int i = 0; i < M; i++) {
			game[i][0] = man[i];
			game[i][1] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - M; i++) {
			int v = Integer.parseInt(st.nextToken());
			Arrays.sort(game, cmp);
			game[v - 1][0] = man[M + i];
			game[v - 1][1] = M + i;
		}
		Arrays.sort(game, cmp);

		int exclude = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < M; i++)
			if (i != exclude)
				System.out.print(game[i][0] + " ");
	}

	private static Comparator cmp = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0])
				return Integer.compare(o1[1], o2[1]);
			return Integer.compare(o1[0], o2[0]);
		}
	};
}