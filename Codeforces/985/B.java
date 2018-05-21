/*
 * Author: Minho Kim (ISKU)
 * Date: May 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/985/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] matrix = new boolean[N][M];
		int[] lamp = new int[M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) != '1')
					continue;

				matrix[i][j] = true;
				lamp[j]++;
			}
		}

		for (int i = 0; i < N; i++) {
			boolean check = true;
			for (int j = 0; j < M; j++)
				if (matrix[i][j] && lamp[j] == 1)
					check = false;

			if (check) {
				System.out.print("YES");
				System.exit(0);
			}
		}

		System.out.print("NO");
	}
}