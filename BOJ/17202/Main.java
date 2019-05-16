/*
 * Author: Minho Kim (ISKU)
 * Date: May 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17202
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int[][] table = new int[15][16];
		for (int i = 0; i < 8; i++) {
			table[0][i * 2] = A.charAt(i) - '0';
			table[0][i * 2 + 1] = B.charAt(i) - '0';
		}

		for (int i = 1; i < 15; i++)
			for (int j = 0; j < 16 - i; j++)
				table[i][j] = (table[i - 1][j] + table[i - 1][j + 1]) % 10;

		System.out.printf("%d%d", table[14][0], table[14][1]);
	}
}