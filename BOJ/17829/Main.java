/*
 * Author: Minho Kim (ISKU)
 * Date: January 17, 2020
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17829
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] mat = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				mat[i][j] = Integer.parseInt(st.nextToken());
		}

		while (mat.length > 1) {
			int[][] temp = new int[mat.length / 2][mat.length / 2];

			for (int i = 0; i < mat.length; i += 2) {
				for (int j = 0; j < mat.length; j += 2) {
					int[] pool = { mat[i][j], mat[i][j + 1], mat[i + 1][j], mat[i + 1][j + 1] };
					Arrays.sort(pool);

					temp[i / 2][j / 2] = pool[2];
				}
			}

			mat = temp;
		}

		System.out.println(mat[0][0]);
	}
}
